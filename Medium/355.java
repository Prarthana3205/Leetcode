// 355. Design Twitter
// https://leetcode.com/problems/design-twitter/description/

import java.util.*;
class Twitter {
    class Tweet
    {
        int tweetId;
        int time;
        Tweet(int tweetId,int time)
        {
            this.tweetId=tweetId;
            this.time=time;
        }
    }
    HashMap<Integer,List<Tweet>> tweets;
    HashMap<Integer,HashSet<Integer>> followers;
    int time;
    public Twitter() {
        tweets=new HashMap<>();
        followers=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId,time++));        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> alltweets=new ArrayList<>();
        if(tweets.containsKey(userId))
            alltweets.addAll(tweets.get(userId));

        // Tweets from followers
        if(followers.containsKey(userId))
        {
            for(int f:followers.get(userId))
            {
                if(tweets.containsKey(f))
                    alltweets.addAll(tweets.get(f));
            }
        }

        // sorting in descending order
        alltweets.sort((a,b)->Integer.compare(b.time,a.time));
        List<Integer> feed=new ArrayList<>();

        for(int i=0;i<Math.min(10,alltweets.size());i++)
            feed.add(alltweets.get(i).tweetId);
        return feed;
        
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId,new HashSet<>());
        followers.get(followerId).add(followeeId);        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId))
            followers.get(followerId).remove(followeeId);        
    }
}

/**
 * Your Twitter object will beDesign a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

    Twitter() Initializes your twitter object.
    void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
    List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
    void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
    void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
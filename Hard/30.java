// 30. Substring with concatenation of all words
// https://leetcode.com/problems/substring-with-concatenation-of-all-words

// Brute Force Approach TLE (181/182)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> result=new ArrayList<>();

//         if(words[0].length()==0)
//             return result;

//         int numwords=words.length;
//         int wordlen=words[0].length();
//         int totallen=numwords*wordlen;

//         HashMap<String,Integer> freq=new HashMap<>(); // count of the words
//         for(String word:words)
//         {
//             int num=freq.getOrDefault(word,0)+1;
//             freq.put(word,num);
//         }

//         for(int i=0;i<=s.length()-totallen;i++)
//         {
//             HashMap<String,Integer> seen=new HashMap<>();
//             int j;
//             for(j=0;j<numwords;j++)
//             {
//                 int start=i+j*wordlen;
//                 String newword=s.substring(start,start+wordlen);
//                 if(!freq.containsKey(newword)) // Important condition 
//                     break;
//                 seen.put(newword,seen.getOrDefault(newword,0)+1);
//                 if(seen.get(newword)>freq.get(newword))
//                     break;
//             }
//             if(j==numwords)
//                 result.add(i);
//         }
//         return result;
//     }
// }

// Sliding Window Approach
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if(words==null || words[0].length()==0)
            return result;

        int numwords=words.length;
        int wordlen=words[0].length();
        int totallen=numwords*wordlen;

        if(s.length()<totallen)
            return result;

        HashMap<String,Integer> freq=new HashMap<>();
        for(String word:words)
            freq.put(word,freq.getOrDefault(word,0)+1);
        
        for(int offset=0;offset<wordlen;offset++)
        {
            HashMap<String,Integer> seen=new HashMap<>();
            int left=offset;
            int count=0;
            for(int right=offset;right<=s.length()-wordlen;right+=wordlen) // jumping word by word
            {
                String newword=s.substring(right,right+wordlen);
                if(freq.getOrDefault(newword,0)==0) // ignore the word and move to the next word to start a fresh window 
                {
                    seen.clear();
                    count=0;
                    left=right+wordlen;
                    continue;
                }

                seen.put(newword,seen.getOrDefault(newword,0)+1);
                count++;
                while(freq.get(newword)<seen.get(newword)) // Decreasing the window till the condition satisfies
                {
                    String rem=s.substring(left,left+wordlen);
                    seen.put(rem,seen.get(rem)-1);
                    left+=wordlen;
                    count--;
                }

                if(count==numwords)
                {
                    result.add(left);
                    String rem=s.substring(left,left+wordlen);
                    seen.put(rem,seen.get(rem)-1);
                    left+=wordlen;
                    count--;
                }
            }
        }
        return result;
    }
}
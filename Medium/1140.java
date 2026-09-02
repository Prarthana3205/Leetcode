// 1140. Stone Game II
// https://leetcode.com/problems/stone-game-ii/

// BRAINROTTTT

import java.util.Arrays;
class Solution {
    int dp[][];
    int suffix[];
    int n;
    int solve(int i,int M)
    {
        if(i>=n)
            return 0;
        if(dp[i][M]!=-1)
            return dp[i][M];
        int best=0;
        for(int X=1;X<=2*M && i+X<=n;X++) // All the possible number of piles that can be taken by the current player
        {
            int newM= Math.max(X,M);
            int opponent=solve(i+X,newM);
            int curr=suffix[i]-opponent; 
            // The current player's score is the total stones remaining (suffix[i]) minus the opponent's score.
            best=Math.max(curr,best);
        }
        return dp[i][M]=best;
    }
    public int stoneGameII(int[] piles) {
        n=piles.length;
        dp =new int[n][n+1];

        suffix=new int[n+1];
        for(int i=n-1;i>=0;i--)
            suffix[i]=piles[i]+suffix[i+1]; // suffix[i] = sum of piles from index i to end
        // This allows us to quickly calculate the total number of stones remaining after taking X piles starting from index i.
        
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return solve(0,1);        
    }
}
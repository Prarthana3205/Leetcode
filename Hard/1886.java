// 1886. Number of Ways to Rearrange Sticks With K Sticks Visible
// https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/

class Solution {
    public int rearrangeSticks(int n, int k) {
        int MOD=(int)1e9+7;
        int[][] dp=new int [n+1][k+1];
        dp[0][0]=1; // base case
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=k;j++)
                dp[i][j]=(int)((dp[i-1][j-1]+ 
                                    ((long)dp[i-1][j]*(i-1)) // typecasted to long because the multiplication can exceed the range of int
                                    )%MOD);
        }
        return dp[n][k];
    }
}
/*
If the tallest stick is placed at the end it will always be visible. there we need to arrange the remaining n-1 sticks with k-1 visible sticks.
That is case 1: dp[i-1][j-1]
If the tallest stick is placed anywhere else ,the other n-1 sticks can be placed at the end , the other n-1 stick will not be visible
That is case 2: dp[i-1][j]*(i-1) so we have to arrange teh remaining n-1 sticks with k visible sticks because the last stick will not be visible 
 */
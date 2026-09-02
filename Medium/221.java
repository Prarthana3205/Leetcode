// 221. Maximal Square
// https://leetcode.com/problems/maximal-square/description/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row][col];
        int max=0;

        // Initialisation
        for(int i=0;i<row;i++)
        {
            dp[i][0]=(matrix[i][0]=='1')?1:0;
            if(dp[i][0]==1)
                max=1;
        }
        for(int j=0;j<col;j++)
        {
            dp[0][j]=(matrix[0][j]=='1')?1:0;
            if(dp[0][j]==1)
                max=1;
        }   
        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(matrix[i][j]=='0')
                   dp[i][j]=0;
                else
                {
                    dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    max=max>dp[i][j]?max:dp[i][j];
                }
            }
        }
        return max*max;
    }
}
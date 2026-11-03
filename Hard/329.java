// 329. Longest Increasing Path in a Matrix
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

// optimised solution is to make sure to store the explored path
class Solution {
    int calculate(int row,int col,int[][] matrix,int[][] dp)
    {
        int m=matrix.length;
        int n=matrix[0].length;

        if(row>=m || row<0 || col>=n || col<0)
            return 0;
        if(dp[row][col]!=0)
            return dp[row][col];
        
        int right=0;
        int left=0;
        int up=0;
        int down=0;

        int current=matrix[row][col];
        if(col+1<n && current<matrix[row][col+1])
            right=calculate(row,col+1,matrix,dp);
        if(col-1>=0 && current<matrix[row][col-1])
            left=calculate(row,col-1,matrix,dp);
        if(row-1>=0 && current<matrix[row-1][col])
            up=calculate(row-1,col,matrix,dp);
        if(row+1<m && current<matrix[row+1][col])
            down=calculate(row+1,col,matrix,dp);

        dp[row][col]=1+Math.max(right,(Math.max(left,Math.max(up,down))));
        return dp[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[][] dp=new int[rows][cols];
        int maxpath=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                maxpath=Math.max(maxpath,
                    calculate(i,j,matrix,dp));
            }
        }
        return maxpath;
    }
}

/*
// TLE (135/139 test cases passed)
class Solution {
    int calculate(int row,int col,int[][] matrix,int prev)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        if(row>=n || row<0 || col>=m || col<0)
            return 0;
        if(matrix[row][col]<=prev)    
            return 0;
        return 
            Math.max(
                1+calculate(row,col+1,matrix,matrix[row][col]), // right 
                Math.max(
                    1+calculate(row,col-1,matrix,matrix[row][col]), // left
                    Math.max(
                        1+calculate(row+1,col,matrix,matrix[row][col]), // down
                        1+calculate(row-1,col,matrix,matrix[row][col])
                        ))); // up
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int path=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                path=Math.max(path,calculate(i,j,matrix,-1));
            }
        }
        return path;        
    }
}
*/
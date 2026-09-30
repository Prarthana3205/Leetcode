// 32`9. Longest Increasing Path in a Matrix
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

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
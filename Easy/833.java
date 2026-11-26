// 833. Projection Area of 3D shapes
// https://leetcode.com/problems/projection-area-of-3d-shapes/

class Solution {
    public int projectionArea(int[][] grid) {
        int top=0,front=0,side=0;
        int n=grid.length;
        int sum1,sum2;
        for(int i=0;i<n;i++)
        {
            sum1=0;
            sum2=0;
            for(int j=0;j<n;j++)
            {
                top+=(grid[i][j]>0)?1:0; // top will be XY plane we need to count the number of boxes 
                sum1=Math.max(sum1,grid[i][j]); 
                sum2=Math.max(sum2,grid[j][i]);
            }
            side+=sum1; // Sum of the max in each row
            front+=sum2; // Sum of max in each column
        }
        return top+side+front;
        
    }
}
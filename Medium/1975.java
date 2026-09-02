/*
1975. Maximum Matrix Sum
https://leetcode.com/problems/maximum-matrix-sum/

If there are even number of negative numbers, we can make all numbers positive and return the sum of all absolute values.
If there are odd number of negative numbers one number will be negative, we retain one with the smallest absolute value.
So we return the sum of all absolute values minus twice the smallest absolute value
 */

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int row=matrix.length;
        long sum=0;
        int count=0,min=Integer.MAX_VALUE;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<row;j++)
            {
                if(matrix[i][j]<0)
                    count++;
                int abs=Math.abs(matrix[i][j]);
                min=Math.min(min,abs); // Not out of all negative numbers but out of all numbers in the matrix
                sum+=abs;
            }
        }
        return count%2==0?sum:sum-2*min;  
    }
}
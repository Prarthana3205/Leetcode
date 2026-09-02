/* 
// 85. Maximal Rectangle
// https://leetcode.com/problems/maximal-rectangle/


Will use the same logic as 84. Largest Rectangle in Histogram
but we will calculate the heights of the histogram for each row of the matrix 
and then apply the largest rectangle area algorithm on those heights.
*/

import java.util.Stack;
class Solution {
    int calculate(int[] heights)
    {
        int max=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<=heights.length;i++)
        {
            int curr=(i==heights.length)?0:heights[i];
            while(!stk.isEmpty() && curr<heights[stk.peek()])
            {
                int height=heights[stk.pop()];
                int width=(stk.isEmpty())?i:i-stk.peek()-1;
                int area=height*width;
                max=Math.max(max,area);
            }
            stk.push(i);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int max=0;
        int row=matrix.length;
        int col=matrix[0].length;

        int[] heights=new int[col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                heights[j]=(matrix[i][j]=='1')?1+heights[j]:0;
            }
            int area=calculate(heights);
            max=Math.max(area,max);
        }
        return max;        
    }
}
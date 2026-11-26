// 84. Largest Rectangle in Histogram
// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] heights) {   
        int max=0;
        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<=heights.length;i++)
        {
            int curr=(i==heights.length)?0:heights[i];
            while(!stk.isEmpty() && curr<heights[stk.peek()])
            {
                int height=heights[stk.pop()]; 
                // We know the right side is the smaller bar and the left side is the smaller bar as well.
                //  So we can calculate the area with height as the popped element and width as the distance between the current index and the index of the top element in the stack after popping.

                int width;
                if(stk.isEmpty())
                    width=i; // Eventually there will be the smallest element in the stack and therefore we need to consider the width as i
                else
                    width=i-stk.peek()-1;

                int area=height*width;
                max=Math.max(area,max);
            }
            stk.push(i); // Keep pushing the heights which are in increasing order
        }
        return max;
    }
}

// TLE 93/99 test cases passed
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int max=0;
//         int n=heights.length;
//         for(int i=0;i<n;i++)
//         {
//             int left,right;
//             left=right=i;

//             while(left>=0 && heights[left]>=heights[i])
//                 left--;
//             while(right<n && heights[right]>=heights[i])
//                 right++;
//             int area=heights[i]*(right-left-1);
//             max=Math.max(max,area);
//         }
//         return max;        
//     }
// }


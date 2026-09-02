// 84. Largest Rectangle in Histogram
// https://leetcode.com/problems/largest-rectangle-in-histogram/

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

                int width;
                if(stk.isEmpty())
                    width=i;
                else
                    width=i-stk.peek()-1;

                int area=height*width;
                max=Math.max(area,max);
            }
            stk.push(i);
        }
        return max;
    }
}
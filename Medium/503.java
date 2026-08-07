// 503. Next Greater Element II
// https://leetcode.com/problems/next-greater-element-ii/description/

import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[n];

        for(int i=2*n-1;i>=0;i--) // to form a wrap around
        {
            int ind=i%n;

            while(!stack.isEmpty() && stack.peek()<=nums[ind])
            {
                stack.pop();
            }

            if(i<n)
                ans[i]=stack.isEmpty()?-1:stack.peek(); // element in this stack is the next greater element
            
            stack.push(nums[ind]);
        }
        return ans;
    }
}
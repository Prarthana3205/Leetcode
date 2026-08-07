// 239. Sliding window maximum
// https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<=0)
            return new int[0];

        int len=nums.length;
        int ind=0;
        int[] result=new int[len-k+1];
        Deque<Integer> deque=new LinkedList<>();

        for(int i=0;i<len;i++)
        {
            // Remove indices out of bound from the sliding window
            while(!deque.isEmpty() && deque.peekFirst()<=i-k)
                deque.pollFirst();
            
            // To ensure the maximum element remains
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i])
                deque.pollLast();
            
            deque.offerLast(i);
            if(i>=k-1)
                result[ind++]=nums[deque.peekFirst()];
        }
        return result;        
    }
}
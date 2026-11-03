// 462. Minimum Moves to Equal Array Elements II
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

// similar to 453, but here we can increase or decrease any element by 1. 
// So I made all elements equal to the median of the array.

import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=(0+(nums.length-1))/2;
        int middle=nums[mid];
        int count=0;
        for(int n:nums)
        {
            count+=Math.abs(n-middle);
        }
        return count;
        
    }
}
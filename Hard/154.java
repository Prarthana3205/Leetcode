// 154. Find Minimum in rotated sorted array II
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right])
                left=mid+1;
            else if(nums[mid]==nums[right])// Handle duplicates
                right--; // Just reduce the search space
            else
                right=mid;
        }
        return nums[left];   
    }
}
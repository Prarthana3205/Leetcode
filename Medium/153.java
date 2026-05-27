// 153. Find Minimum in rotated sorted array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// Minimum element will be the position where teh order will be broken

class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right])//Order broken therefore min element lies on right side
                left=mid+1;
            else 
                right=mid;
        }   
        return nums[left];  
    }
}
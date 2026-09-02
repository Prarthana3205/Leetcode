// 162. Find Peak Element
// https://leetcode.com/problems/find-peak-element/description/

// NOT AN OPTIMAL SOLUTION O(n)
// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n=nums.length;
//         if(n==1)
//             return 0;
//         if(n==2)
//             return (nums[0]>nums[1])?0:1;
//         for(int i=1;i<n-1;i++)
//         {
//             if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
//                 return i;
//         }
//         if(nums[n-1]>nums[n-2])
//             return n-1;
//         return 0;
//     }
// }


// Need to go uphill to find the peak element. binary search to find the peak element in O(log n) time complexity.
class Solution {
    public int findPeakElement(int[] nums) {        
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1])
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}
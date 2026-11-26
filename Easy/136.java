// 136. Single Number
// https://leetcode.com/problems/single-number/

 // XOR of a number with itself is 0 and XOR of a number with 0 is the number itself. So if we XOR all the numbers in the array
 // the numbers that appear twice will cancel each other out and we will be left with the number that appears only once.

class Solution {
    public int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++)
            ans=ans^nums[i];
            return ans;
    }
}
// 287. Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/

// Floyds Cycle Detection (Hare and Tortoise) 
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do // to find the cycle 
        {
            slow=nums[slow]; // move 1 step
            fast=nums[nums[fast]]; // move 2 steps
        }
        while(slow!=fast);

        // distance from start to entry = distance from meeting point to entry
        slow=nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;       
    }
}
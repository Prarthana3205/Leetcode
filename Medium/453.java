// 453. Minimum Moves to Equal Array Elements
// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

// Increasing n-1 elements = Decreasing 1 element
// 1,2,3 -> 2 can be decremented once to 1, 3 can be decremented twice to 1 therefore total moves = 3
class Solution {
    public int minMoves(int[] nums) {
        int min=nums[0];
        int count=0;
        for(int n:nums)
            min=Math.min(min,n);
        
        for(int i=0;i<nums.length;i++)
        {
            count+=nums[i]-min;
        }
        return count;
    }
}
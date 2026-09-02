// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes

// Two pointer approach 
// i keeps scanning all elements j keeps track of the next position to place a non-zero element. 
// When a non-zero is found, it is swapped with the element at j and j is incremented.

class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        int n=nums.length;

        for(int i=0;i<n;i++)
        {            
            if(nums[i]!=0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;

                j++;
            }
        }
    }
}
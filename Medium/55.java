// 55. Jump Game
// https://leetcode.com/problems/jump-game/description/


class Solution {
    public boolean canJump(int[] nums) {
        // int n=nums.length;
        // boolean[] dp=new boolean[n];

        // dp[n-1]=true; //base case
        // for(int i=n-2;i>=0;i--)
        // {
        //     for(int j=nums[i];j>0;j--)
        //     {
        //         int ind=j+i;
        //         if(ind<n && dp[ind]==true)
        //         {    
        //             dp[i]=true;
        //             break;
        //         }
        //     }
        // }   
        // return dp[0]; 

        // Optimised Approach
        int farthest=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>farthest) // checking if we can reach the current index or not
                return false;
            farthest=Math.max(farthest,i+nums[i]);
            if(farthest>=nums.length-1)
                return true;
        }    
        return true;
    }
}
// 137. Single Number II
// https://leetcode.com/problems/single-number-ii/

// Approach is to count the number of 1s in each bit position , and then modulo 3 to find the bit position of the single number.
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<32;i++) //integer has 32 position 0,1,2...31
        {
            int count=0;
            for(int num:nums)
            {
                if((num&(1<<i))!=0)
                 // to count the number 1 we create a mask such that it is 1 at the ith position and do & 
                 // if result is 1 then definitely 1 is in ith position of num
                    count++;
            }

            if(count%3!=0) // since each number appears 3 times except the single number, so if count%3!=0 then single number has 1 at ith position
                result|=1<<i; // we do | OR to insert the number 1 at ith position of result without altering the other numbers, if it is 0 it does not affect
        }
        return result;
    }
}
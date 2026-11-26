// 371. Sum of Two Integers
// https://leetcode.com/problems/sum-of-two-integers/

class Solution {
    public int getSum(int a, int b) {
        while(b!=0)
        {
            int sum=a^b; // XOR will give us the sum of a and b without considering the carry
            int carry=(a&b)<<1; 
            // AND will tell us where the carry is , so we left shift it by 1 to the actual position of the carry to be added
            a=sum;
            b=carry;
        }
        return a;
    }
}
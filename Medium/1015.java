// 1015. Smallest Integer Divisible by K
// https://leetcode.com/problems/smallest-integer-divisible-by-k/description/

class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0)
            return -1;
        
        int count=0,r=0;
        do
        {
            r=(r*10+1)%k;
            count++;
        }while(r!=0);
        return count;
        
    }
}

/*
We can generate 1, 11, 111 using n=n*10+1 and then get the remainder
 */
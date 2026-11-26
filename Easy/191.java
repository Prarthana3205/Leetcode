// 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/

class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0)
        {
            n= n&(n-1); // this operation removes the rightmost 1 bit from n, so we can count how many times we can do this until n becomes 0
            count++;
        }
        return count;        
    }
}

/*
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0)
        {
            while(n%2==0)
                n/=2;
            count++;
            n/=2;
        }
        return count;        
    }
}
*/

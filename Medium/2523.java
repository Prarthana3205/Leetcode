// 2523. Closest Prime Numbers in Range 
// https://leetcode.com/problems/closest-prime-numbers-in-range/description/

class Solution {
    boolean isprime(int num)
    {
        if(num<2)
            return false;
        
        for(int i=2;i*i<=num;i++)
        {
            if(num%i==0)
                return false;
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        int prev=-1,mindiff=Integer.MAX_VALUE;
        int[] res={-1,-1};
        for(int i=left;i<=right;i++)
        {
            if(isprime(i))
            {
                if(prev!=-1)
                {
                    int diff=i-prev;
                    if(diff<mindiff)
                    {
                        mindiff=diff;
                        res[0]=prev;
                        res[1]=i;
                    }
                }
                prev=i;
            }
        }
        return res;
    }
}
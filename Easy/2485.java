// 2485. Find the Pivot Integer
// https://leetcode.com/problems/find-the-pivot-integer/description/

class Solution {
    public int pivotInteger(int n) {
        if(n==1)
            return 1;
        int sum=(n*(n+1))/2;
        int sum2=n;
        for(int i=n;i>0;i--)
        {
            if(sum==sum2)
                return i;
            sum-=i;
            sum2+=i-1;
        }
        return -1;
    }
}

/*
if n=8
sum=36, 28, 21
sum2=8, 15, 21
 */
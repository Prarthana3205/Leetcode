/*
172. Factorial Trailing Zeroes
https://leetcode.com/problems/factorial-trailing-zeroes/

A zero is fromed when we multiply 5 and 2.
Till n occurences of factor 2 are definitely more than 5, so pairing wont be a problem
We therefore just count the occurence of factor 5
*/

// This approach I am calculating the number of multiples of 5 between 1 and n
class Solution {
    public int trailingZeroes(int n) {
        int count=0;
        while(n>0)
        {
            n/=5;
            count+=n;
        }
        return count;
    }
}

/*
// Understanding the solution approach 
class Solution {
    public int trailingZeroes(int n) {
        int count=0;
        for(int i=5;i<=n;i+=5)
        {
            int num=i;
            while(num%5==0)
            {
                count++;
                num/=5;
            }
        }
        return count;
    }
}
*/

/*
// Brute force approach,
class Solution {
    public int trailingZeroes(int n) {
        int fact=1;
        for(int i=2;i<=n;i++)
            fact*=i; // will cause integer overflow starting from 13! therefore this solution fails
        
        int count=0;
        do
        {
            int r=fact%10;
            if(r!=0)
                break;
            count++;
            fact/=10;
        }
        while(fact>0);

        return count; 
    }
}
*/
// 204. Count Primes
// https://leetcode.com/problems/count-primes/description/

// Sieve of Eratosthenes
class Solution {
    public int countPrimes(int n) {
        int c=0;
        boolean[] check=new boolean[n+1];
        for(int i=2;i<n;i++)
        {
            if(check[i]==false)
            {
                for(int j=i*2;j<n;j+=i)
                    check[j]=true;
                c+=1;
            }
        }
        return c;
    }
}
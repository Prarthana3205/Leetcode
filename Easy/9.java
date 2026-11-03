// 9. Palindrome Number
// https://leetcode.com/problems/palindrome-number/description/

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int sum=0;
        int n=x;
        while(x>0)
        {
            sum=(sum*10)+(x%10);
            x/=10;
        }
        return (sum==n);
    }
}
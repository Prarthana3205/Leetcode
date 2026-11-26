/*
233. Number of Digit One
https://leetcode.com/problems/number-of-digit-one/

We maintain factor which is ones,tens,hundreds etc, left is the left part of the number before current digit 
current is the current digit we are looking at, right is the right part of the number after current digit

CASE 1: left+1*factor if current>1 :
Example: 2345, current=3, left=2, right=45, factor=100
group1:100-199(100 occurences), group2:1100-199(100 occurences), group3:2100-2199(100 occurences) 
therefore we add 1 to left

CASE 2: left*factor+right+1 if current==1:
Example: 2145, current=1, left=2, right=45, factor=100
left*factor will count the before possible occurences , then we add the leftover right+1 to count the current occurences

CASE 3: left*factor if current==0:
No need of +1 as there are no occurences of 1 in the current digit
*/

class Solution {
    public int countDigitOne(int n) {
        int sum=0;
        int factor=1;
        int i=n;
        while(i>0)
        {
            int left=n/(factor*10);
            int current=(n/factor)%10;
            int right=n%factor;

            if(current==0)
                sum+=left*factor;
            else
                sum+=(current>1)?(left+1)*factor:(left*factor)+right+1;
            factor*=10;
            i/=10;
        }
        return sum;
    }
}
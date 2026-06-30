// 3. Longest Substring without repeating characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        int max=0;
        if(len==0) return 0;
        for(int i=0;i<len;i++)
        {
            int c=0;
            int[] freq=new int[128]; // Note the array declaration
            Arrays.fill(freq,0); // syntax
            for(int j=i;j<len;j++)
            {
                if(freq[s.charAt(j)]==0) // in Java string is not an array so use s.charAt(i) to get a character
                {
                    freq[s.charAt(j)]++;
                    c++;
                }
                else break;
            }
            if(max<c) max=c;
        }
        return max;
    }
}
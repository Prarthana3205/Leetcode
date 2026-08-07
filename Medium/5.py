# 5. Longest Palindromic Substring
# https://leetcode.com/problems/longest-palindromic-substring

# Approach: Expand Around Center

class Solution:
    def expand(s,left,right):
        while(left>=0 and right<len(s) and s[left]==s[right]):
            left-=1
            right+=1
        return s[left+1:right]

    def longestPalindrome(self, s: str) -> str:
        res=""
        for i in range(len(s)):
            # odd length palindrome
            res=max(res,Solution.expand(s,i,i),key=len)

            #even length palindrom
            res=max(res,Solution.expand(s,i,i+1),key=len)
        return res




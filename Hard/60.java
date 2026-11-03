// 60. Permutation Sequence
// https://leetcode.com/problems/permutation-sequence/description/

import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        int[] fact=new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++)
        {
            nums.add(i); // 0 based indexing
            fact[i]=i*fact[i-1]; // 1 based indexing
        }

        k--; // 0 based indexing conversion
        StringBuilder ans=new StringBuilder();
        for(int i=n;i>=1;i--)
        {
            // (k-1)/(n-1)! gives the index of the number in the current group
            int block=k/fact[n-1]; 
            ans.append(nums.get(block));
            nums.remove(block); // index based removal from nums array
            k=k%fact[n-1]; // finding the number within the group
            n--;
        }
        return ans.toString();
    }
}
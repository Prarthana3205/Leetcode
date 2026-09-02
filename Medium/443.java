// 443. String Compression
// https://leetcode.com/problems/string-compression/

class Solution {
    public int compress(char[] chars) {
        String res="";
        int n=chars.length;
        if(n==1)
            return 1;
        int i=0,j=0;
        while(i<n && j<n)
        {
            int count=0;
            while(j<n && chars[i]==chars[j])
            {
                count+=1;
                j++;
            }
            res=(count==1)?res+chars[i]:res+chars[i]+String.valueOf(count);
            i=j;
        }
        for(int k=0;k<res.length();k++)
            chars[k]=res.charAt(k); // A necessary step as mentioned in the question
        return res.length();
    }
}
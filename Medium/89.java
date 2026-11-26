/*
89. Gray Code
https://leetcode.com/problems/gray-code/

0 append to original sequence , 1 append to reverse of original sequence this will give you gray code
in general we do not need to append 0 in the beginning as it is already there in the original sequence
for appending 1 in the beginning we add the mask that is 1<<i to the reverse of the original sequence
*/

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        res.add(0);
        for(int i=0;i<n;i++)
        {
            int mask=1<<i;
            for(int j=res.size()-1;j>=0;j--)
                res.add(res.get(j)+mask);
        }
        return res;
    }
}
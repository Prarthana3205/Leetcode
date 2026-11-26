// 1441. Build An Array With Stack Operations
// https://leetcode.com/problems/build-an-array-with-stack-operations/description/

class Solution {
    public List<String> buildArray(int[] target, int n) {
        int ind=0;
        List<String> res=new ArrayList<>();
        for(int i=1;i<=n && ind<target.length;i++)
        {
            res.add("Push");
            if(i==target[ind])
                ind++;
            else
                res.add("Pop"); // Push Pop Push Pop instead of Push Push Pop Pop
        }
        return res;
    }
}
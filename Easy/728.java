// 728. Self Dividing Numbers
// https://leetcode.com/problems/self-dividing-numbers/description/

import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res=new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            int num=i;
            while(num>0)
            {
                int r=num%10;
                if(r==0 || i%r!=0)
                    break;
                num/=10;
            }
            if(num==0)
                res.add(i);
        }
        return res;
    }
}
// 18. 4Sum
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Very similar to 3 sum (just an extra loop)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;

                int left=j+1;
                int right=nums.length-1;
                while(left<right)
                {
                    // Storing in long to avoid integer overflow
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right]; //typecasting is important 
                    if(sum<target)
                        left++;
                    else if(sum>target)
                        right--;
                    else
                    {
                        List<Integer> row=new ArrayList<>();
                        row.add(nums[i]);
                        row.add(nums[j]);
                        row.add(nums[left++]);
                        row.add(nums[right--]);
                        result.add(row);

                        while(left<right && nums[left]==nums[left-1])
                            left++;
                        while(left<right && nums[right]==nums[right+1])
                            right--;
                    }
                }
            }
        }
        return result;
    }
}
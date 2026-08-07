// 15. 3Sum;
// https://leetcode.com/problems/3sum/description/

// Sorting and 2 pointer approach

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // Note the return type
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue; // to avoid duplicate triplets

            int left=i+1,right=nums.length-1;
            while(left<right)
            {
                if(nums[i]+nums[left]+nums[right]<0) left++;
                else if(nums[i]+nums[left]+nums[right]>0) right--;
                else
                {
                    List<Integer> row=new ArrayList<>();
                    row.add(nums[i]);
                    row.add(nums[left++]);
                    row.add(nums[right--]);
                    result.add(row);

                    // Again to avoid duplicate triples
                    while(left<right && nums[left]==nums[left-1])
                        left++;
                    while(left<right && nums[right]==nums[right+1])
                        right--;
                }
            }
        }
        return result;  
    }
}
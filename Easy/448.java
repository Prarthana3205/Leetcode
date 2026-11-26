// 448. Find All Numbers Disappeared in an Array
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

// Optimal solution with O(n) time and O(1) space complexity
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int ind=Math.abs(nums[i])-1;
            nums[ind]=Math.abs(nums[ind])*-1;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                res.add(i+1);
        }
        return res;        
    }
}

/*
// This approach has extra space complexity of O(n) therefore not yet the optimal solution
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(i+1))
                res.add(i+1);
        }
        return res;
    }
}
*/
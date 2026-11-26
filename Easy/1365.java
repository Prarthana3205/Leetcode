// 1365. How Many Numbers Are Smaller Than the Current Number
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

// Optimal solution with O(nlogn) time complexity and O(n) space complexity
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted=nums.clone();
        int n=nums.length;

        int[] res=new int[n];
        Arrays.sort(sorted);

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.putIfAbsent(sorted[i],i); // Storing first occurence of the number
        
        for(int i=0;i<n;i++)
            res[i]=map.get(nums[i]);

        return res;
    }
}

/*
// Brute Force Approach with O(n^2) time complexity and O(1) space complexity
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && nums[i]>nums[j])
                    res[i]++;
            }
        }
        return res;
    }
}
*/
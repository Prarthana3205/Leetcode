// 645. Set Mismatch
// https://leetcode.com/problems/set-mismatch/

// A better approach as it is O(n) time and O(1) space complexity
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int E=(n*(n+1))/2; //Expected sum;
        int A=0,Esquare=0,Asquare=0;
        for(int i=0;i<n;i++)
        {
            A+=nums[i]; // Actual sum
            Esquare+=(i+1)*(i+1); // Expected sum square
            Asquare+=nums[i]*nums[i];
        }
        int eq1=E-A; // Expected sum-Actual sum= missing-duplicate
        // Therefore M-D is 1 equation

        // E^2-A^2=(E-A)(E+A)
        int eq2=(Esquare-Asquare)/eq1;

        // Solving both equations you get the answer
        int missing=(eq1+eq2)/2;
        int duplicate=missing-eq1;
        int[] res={duplicate,missing};
        return res;
    }
}

/*
// O(nlogn) time and O(1) space complexity
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] res=new int[2];
        int total=(n*(n+1))/2;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                res[0]=nums[i];
                continue;
            } 
            total-=nums[i];
        }
        total-=nums[n-1];
        res[1]=total;
        return res;        
    }
}
*/
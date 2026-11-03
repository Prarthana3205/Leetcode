// 2080. Range Frequency Queries
// https://leetcode.com/problems/range-frequency-queries/description/

import java.util.*;
class RangeFreqQuery {
    int[] arr;
    HashMap<Integer,List<Integer>> freq;

    public RangeFreqQuery(int[] arr) {
        this.arr=arr;
        freq=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            freq.putIfAbsent(arr[i],new ArrayList<>());
            freq.get(arr[i]).add(i);
        }
    }
    
    int lowerbound(List<Integer> indices,int target)
    {
        // Finding the first indice that is greater than or equal to left
        int low=0;
        int high=indices.size();
        int mid;
        while(low<high)
        {
            mid=low+(high-low)/2;
            if(indices.get(mid)<target)
                low=mid+1; // I want to find the index that is >=target, so I eliminate the half + mid element
            else
                high=mid;
        }
        return low;
    }

    // Want to find the element strictly greater than the target (so that we return the correct difference)
    int upperbound(List<Integer> indices,int target)
    {
        int low=0;
        int high=indices.size();
        int mid;
        while(low<high)
        {
            mid=low+(high-low)/2;
            if(indices.get(mid)<=target)
                low=mid+1; // =target is also included as we want an element strictly greater than target
            else
                high=mid;
        }
        return low;
    }

    public int query(int left, int right, int value) {
        if(!freq.containsKey(value))
            return 0;

        List<Integer> indices=freq.get(value);
        int start=lowerbound(indices,left);
        int end=upperbound(indices,right);
        return end-start;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */

/* 
// TLE (16/20 test cases passed)
class RangeFreqQuery {
    int[] arr;
    public RangeFreqQuery(int[] arr) {
        this.arr=arr;
    }
    
    public int query(int left, int right, int value) {
        int count=0;
        for(int i=left;i<=right;i++)
            if(arr[i]==value)
                count++;
        return count;
    }
}

*
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
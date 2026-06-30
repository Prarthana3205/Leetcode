// 215. Kth Largest Element in an array
// https://leetcode.com/problems/kth-largest-element-in-an-array

// refer 347
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->a-b //Min Heap
        );

        for(int num:nums)
        {
            pq.offer(num);
            if(pq.size()>k)
                pq.poll();
        }   

        return pq.poll();     
    }
}
// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements

import java.util.HashMap;
import java.util.PriorityQueue;

// Time Complexity: O(nlogk) 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int num:nums)
            freq.put(num,freq.getOrDefault(num,0)+1); // Store number and its frequency into a HashMap

        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->freq.get(a)-freq.get(b) // Condition on how the elements are ordered in the queue
        ); // (a,b)-> a-b will give minHeap b-a will give maxHeap

        for(int num:freq.keySet())
        {
            pq.offer(num);
            if(pq.size()>k)
                pq.poll(); // Removes smallest element(based on freq) from the queue
        }

        int[] res=new int[k];
        for(int i=0;i<k;i++)
            res[i]=pq.poll();

        return res;
    }
}
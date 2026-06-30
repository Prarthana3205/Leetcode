// 378. Kth Smallest element in a sorted matrix
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int total=rows*cols;

        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->b-a // Max Heap because we need to find Kth smallest 
        );

        for(int i=0;i<total;i++)
        {
            int r=i/cols; // Matrix traversal similar to 74
            int c=i%cols;
            pq.offer(matrix[r][c]);
            if(pq.size()>k)
                pq.poll();
        }

        return pq.poll();
    }
}
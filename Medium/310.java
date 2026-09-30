/*
310. Minimum Height Trees
https://leetcode.com/problems/minimum-height-trees/

To obtain trees with minimum heights we need to select middle nodes as the root
There can be only 1 or 2 middle nodes
Building the graph is similar to clone graph problem (207,210)

Approach: Keep trimming leaf nodes (Topological/leaf trimming)
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(n==1)
        {
            result.add(0);
            return result;
        }

        // Building the graph
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        int[] degree=new int[n];
        for(int[] edge:edges)
        {
            int a=edge[0];
            int b=edge[1];

            // undirected graph therefore adding to both edges
            graph.get(a).add(b);
            degree[b]++;
            graph.get(b).add(a);
            degree[a]++;
        }

        // Leaf nodes all in a queue
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
            if(degree[i]==1)
                queue.add(i);
        
        while(n>2)
        {
            int size=queue.size();
            for(int i=0;i<size;i++) // this loop is to remove all leaf nodes at a time therefore necessary
            {
                int node=queue.poll();
                for(int neighbour:graph.get(node))
                {
                    if(--degree[neighbour]==1)
                        queue.add(neighbour);
                }
            }
            n-=size;
        }

        while(!queue.isEmpty())
            result.add(queue.poll());
        return result;   
    }
}
// 847. Shortest Path Visiting All Nodes
// https://leetcode.com/problems/shortest-path-visiting-all-nodes/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        int finalMask=(1<<n)-1;
        boolean[][] visited=new boolean[n][1<<n];
        Queue<int[]> queue=new LinkedList<>();

        int steps=0; // Initial BFS
        for(int i=0;i<n;i++)
        {
            int mask=1<<i;
            visited[i][mask]=true;
            queue.offer(new int[]{i,mask});
        }

        // We are starting from every node present in the graph
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int j=0;j<size;j++)
            {
                int[] curr=queue.poll();
                int node=curr[0];
                int mask=curr[1];

                if(mask==finalMask)
                    return steps;
                for(int nei:graph[node])
                {
                    int newMask=mask|(1<<nei);

                    if(!visited[nei][newMask])
                    {
                        visited[nei][newMask]=true;
                        queue.offer(new int[]{nei,newMask});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
// 1584. Minimum Cost to Connect all points
// https://leetcode.com/problems/min-cost-to-connect-all-points

// We use Prim's Algorithm with 0 as the starting node

import java.util.PriorityQueue;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int cost=0;
        int used=0;

        boolean[] visited=new boolean[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});

        while(used<n)
        {
            int[] curr=pq.poll();
            int wt=curr[0];
            int node=curr[1];

            if(visited[node])
                continue;
            
            visited[node]=true;
            cost+=wt;
            used++;

            for(int next=0;next<n;next++)
            {
                if(!visited[next])
                {
                    int dist= Math.abs(points[node][0]-points[next][0])
                    +Math.abs(points[node][1]-points[next][1]);

                    pq.offer(new int[]{dist,next});
                }
            }
        }
        return cost;        
    }
}
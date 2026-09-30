// 210. Course Schedule II
// https://leetcode.com/problems/course-schedule-ii

// smilar to 207 question

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Graph initialisation
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        
        // Making the graph
        int[] indegree=new int[numCourses];
        for(int[] node:prerequisites)
        {
            int course=node[0];
            int preq=node[1];

            graph.get(preq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0)
                queue.add(i);
        
        int count=0;
        int[] result=new int[numCourses];
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            result[count++]=node;
            for(int neighbours:graph.get(node))
            {
                if(--indegree[neighbours]==0)
                    queue.add(neighbours);
            }
        }
        return (count==numCourses)?result:new int[0];
    }
}
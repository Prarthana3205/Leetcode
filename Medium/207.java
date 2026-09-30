// 207. Course Schedule
// https://leetcode.com/problems/course-schedule

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // graph initialization
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        
        int[] indegree=new int[numCourses];

        // making the graph
        for(int[] node:prerequisites)
        {
            int course=node[0];
            int preq=node[1];

            graph.get(preq).add(course); // preq->course
            indegree[course]++;
        }

        // Adding elements with indegree 0 to a queue
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0)
                queue.add(i);
        
        // removing element with 0 indegree
        // eventually checking whether cycle is present or not , if present return false
        int count=0;
        while(!queue.isEmpty()) 
        {
            count++;
            int node=queue.poll();
            for(int neighbour:graph.get(node))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                    queue.add(neighbour);
            }
        }
        return (count==numCourses);
    }
}
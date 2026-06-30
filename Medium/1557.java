// 1557.  Minimum Number of Vertices to Reach All Nodes
// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int indegree[]=new int[n];
        List<Integer> res=new ArrayList<>();
        for(List<Integer> curr: edges)
        {
            int in=curr.get(1);
            indegree[in]++;
        }

        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
                res.add(i);
        }
        return res;        
    }
}
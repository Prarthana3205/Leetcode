import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> res=new ArrayList<>();

        int V=graph.size();
        boolean visited[]=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();

        int src=0;
        visited[src]=true;
        queue.add(src);
        res.add(src);

        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            res.add(curr);

            for(int node:graph.get(curr))
            {
                if(!visited[node])
                    visited[node]=true;
                queue.add(node);
            }
        }
        return res;
    }
}
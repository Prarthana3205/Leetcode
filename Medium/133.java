// 133. Clone Graph
// https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    // HashMap is maintained so that we do not duplicate the clone nodes that have already been cloned.
    HashMap<Node, Node> map = new HashMap<>(); // HashMap is maintained so that we do not duplicate the clone nodes.

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor : node.neighbors)
            clone.neighbors.add(cloneGraph(neighbor));

        return clone;
    }
}
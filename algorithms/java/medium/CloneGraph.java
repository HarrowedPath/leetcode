package medium;

import datastructures.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {

    /**
     * BFS - Iterative
     * <p>
     * Time Complexity: O(V + E)
     * <p>
     * Space Complexity: O(V). Both Queue and HashMap will take O(V) space
     * <p>
     * V = Number of nodes. E = Number of edges in the graph.
     */

    public GraphNode BFSiterative(GraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<GraphNode, GraphNode> visited = new HashMap<>();
        GraphNode copyOfGraph = new GraphNode(node.val);
        visited.put(node, copyOfGraph);
        Queue<GraphNode> graphNodeQueue = new LinkedList<>();
        graphNodeQueue.offer(node);

        while (!graphNodeQueue.isEmpty()) {
            GraphNode current = graphNodeQueue.poll();

            List<GraphNode> copyOfNeighbors = visited.get(current).neighbors;
            for (GraphNode graphNode : current.neighbors) {
                if (!visited.containsKey(graphNode)) {
                    visited.put(graphNode, new GraphNode(graphNode.val));
                    graphNodeQueue.add(graphNode);
                }
                copyOfNeighbors.add(visited.get(graphNode));
            }
        }
        return copyOfGraph;
    }
}

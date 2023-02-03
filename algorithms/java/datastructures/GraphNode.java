package datastructures;

import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode(int val) {
        this.val = val;
    }

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public GraphNode() {
    }
}

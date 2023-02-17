package easy;

import datastructures.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreePreorderTraversal {

    public static void main(String[] args) {
        var ns3rd = new ArrayList<Node>();
        ns3rd.add(new Node(5, new ArrayList<>()));
        ns3rd.add(new Node(6, new ArrayList<>()));

        var ns2nd = new ArrayList<Node>();
        ns2nd.add(new Node(3, ns3rd));
        ns2nd.add(new Node(2, new ArrayList<>()));
        ns2nd.add(new Node(4, new ArrayList<>()));

        var output = new NaryTreePreorderTraversal().preorder(new Node(1, ns2nd));
        assert output.equals(new ArrayList<>(Arrays.asList(1, 3, 5, 6, 2, 4)));
    }

    public List<Integer> preorder(Node root) {
        var res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        traverse(root, res);
        return res;
    }

    void traverse(Node root, List<Integer> res) {
        res.add(root.val);
        for (Node n : root.children) {
            traverse(n, res);
        }
    }
}

package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        TreeNode firstNode = new TreeNode(9);
        TreeNode secondeNode = new TreeNode(20);
        rootNode.left = firstNode;
        rootNode.right = secondeNode;
        TreeNode fiveNode = new TreeNode(15);
        TreeNode sixNode = new TreeNode(7);
        secondeNode.left = fiveNode;
        secondeNode.right = sixNode;
        boolean expectedOutput = true;

        assert expectedOutput == new BalancedBinaryTree().BFSiterative(rootNode);
    }

    public boolean BFSiterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> treeNodesStack = new ArrayDeque<>();
        treeNodesStack.push(root);

        while (!treeNodesStack.isEmpty()) {
            TreeNode node = treeNodesStack.pop();
            if ((node.left == null || map.containsKey(node.left)) && (node.right == null || map.containsKey(node.right))) {
                int left = map.getOrDefault(node.left, 0);
                int right = map.getOrDefault(node.right, 0);
                if (Math.abs(left - right) > 1) {
                    return false;
                }
                map.put(node, Math.max(left, right) + 1);
            } else {
                if (node.left != null && !map.containsKey(node.left)) {
                    treeNodesStack.push(node);
                    treeNodesStack.push(node.left);
                } else {
                    treeNodesStack.push(node);
                    treeNodesStack.push(node.right);
                }
            }
        }
        return true;
    }
}

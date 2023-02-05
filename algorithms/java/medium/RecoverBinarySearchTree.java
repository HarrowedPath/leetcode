package medium;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        int value1 = rootNode.val;
        TreeNode firstNode = new TreeNode(3);
        rootNode.left = firstNode;
        int value2 = firstNode.val;
        TreeNode fourNode = new TreeNode(2);
        firstNode.right = fourNode;
        new RecoverBinarySearchTree().DFSIterative(rootNode);
        assert value2 == rootNode.val;
        assert value1 == firstNode.val;
    }

    public void DFSIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> treeNodeStack = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode prev = null, node1 = null, node2 = null;
        while (current != null || !treeNodeStack.isEmpty()) {
            while (current != null) {
                treeNodeStack.push(current);
                current = current.left;
            }
            current = treeNodeStack.pop();
            if (prev != null && current.val < prev.val && node1 == null) {
                node1 = prev;
            }
            if (prev != null && current.val < prev.val && node1 != null) {
                node2 = current;
            }
            prev = current;
            current = current.right;
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

}

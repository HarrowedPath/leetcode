package easy;

import datastructures.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode fiveNode = new TreeNode(3);
        rootNode.right = secondNode;
        secondNode.left = fiveNode;

        List<Integer> expectedOutput = Arrays.asList(1, 3, 2);
        assert expectedOutput.equals(new BinaryTreeInorderTraversal().DFSIterative(rootNode));
    }

    public List<Integer> DFSIterative(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }
}

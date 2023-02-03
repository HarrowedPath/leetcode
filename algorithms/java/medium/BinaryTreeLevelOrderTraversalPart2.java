package medium;

import datastructures.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalPart2 {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        TreeNode firstNode = new TreeNode(9);
        TreeNode secondNode = new TreeNode(20);
        TreeNode fiveNode = new TreeNode(15);
        TreeNode sixNode = new TreeNode(7);

        rootNode.left = firstNode;
        rootNode.right = secondNode;
        secondNode.left = fiveNode;
        secondNode.right = sixNode;

        List<List<Integer>> expectedOutput = new ArrayList<>();
        List<Integer> third = List.of(3);
        List<Integer> second = Arrays.asList(9, 20);
        List<Integer> first = Arrays.asList(15, 7);

        expectedOutput.add(first);
        expectedOutput.add(second);
        expectedOutput.add(third);

        assert expectedOutput.equals(new BinaryTreeLevelOrderTraversalPart2().BFSIteration(rootNode));
    }

    public List<List<Integer>> BFSIteration(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultList = new ArrayList<>();

        Deque<TreeNode> treeNodes = new ArrayDeque<>();

        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            int iter = treeNodes.size();
            List<Integer> treeNodeList = new ArrayList<>();
            while (iter-- > 0) {
                TreeNode temp = treeNodes.poll();
                if (temp.left != null) {
                    treeNodes.offer(temp.left);
                }
                if (temp.right != null) {
                    treeNodes.offer(temp.right);
                }
                treeNodeList.add(temp.val);
            }
            resultList.add(0, treeNodeList);
        }
        return resultList;
    }
}

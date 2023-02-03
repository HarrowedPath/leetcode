package medium;

import datastructures.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        TreeNode firstNode = new TreeNode(9);
        TreeNode secondNode = new TreeNode(20);
        rootNode.left = firstNode;
        rootNode.right = secondNode;
        TreeNode fiveNode = new TreeNode(15);
        TreeNode sixNode = new TreeNode(7);
        secondNode.left = fiveNode;
        secondNode.right = sixNode;

        List<List<Integer>> expectedOutputList = new ArrayList<>();

        List<Integer> first = List.of(3);
        List<Integer> second = Arrays.asList(20, 9);
        List<Integer> third = Arrays.asList(15, 7);
        expectedOutputList.add(first);
        expectedOutputList.add(second);
        expectedOutputList.add(third);

        assert expectedOutputList.equals(new BinaryTreeZigzagLevelOrderTraversal().zigZagLevelOrder(rootNode));
    }

    public List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultLists = new ArrayList<>();

        Queue<TreeNode> treeNodes = new ArrayDeque<>();

        treeNodes.add(root);

        boolean leftToRight = true;

        while (!treeNodes.isEmpty()) {
            int itr = treeNodes.size();
            List<Integer> nodeList = new ArrayList<>();
            while (itr-- > 0) {
                TreeNode temp = treeNodes.poll();
                if (temp.left != null) {
                    treeNodes.offer(temp.left);
                }
                if (temp.right != null) {
                    treeNodes.offer(temp.right);
                }
                if (leftToRight) {
                    nodeList.add(temp.val);
                } else {
                    nodeList.add(0, temp.val);
                }
            }
            leftToRight = !leftToRight;
            resultLists.add(nodeList);
        }
        return resultLists;
    }
}

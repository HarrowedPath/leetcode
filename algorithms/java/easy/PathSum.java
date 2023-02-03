package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class PathSum {
    public static void main(String[] args) {
        //making a tree
        TreeNode rootNode = new TreeNode(5);
        TreeNode firstNode = new TreeNode(4);
        TreeNode secondNode = new TreeNode(8);
        rootNode.left = firstNode;
        rootNode.right = secondNode;
        TreeNode thirdNode = new TreeNode(11);
        firstNode.left = thirdNode;
        TreeNode fiveNode = new TreeNode(13);
        TreeNode sixNode = new TreeNode(4);
        secondNode.left = fiveNode;
        secondNode.right = sixNode;
        TreeNode sevenNode = new TreeNode(7);
        TreeNode eightNode = new TreeNode(2);
        thirdNode.left = sevenNode;
        thirdNode.right = eightNode;
        TreeNode tenNode = new TreeNode(1);
        sixNode.right = tenNode;

        boolean expectedOutput = true;
        assert expectedOutput == new PathSum().BFSIterative(rootNode, 22);
    }

    public boolean BFSIterative(TreeNode root, int targetSum) {
        if (root == null && targetSum == 0) {
            return true;
        }

        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        Queue<Integer> sum = new ArrayDeque<>();
        treeNodes.add(root);
        sum.add(root.val);
        while (!treeNodes.isEmpty()) {
            int iter = treeNodes.size();
            while (iter-- > 0) {
                TreeNode treeNode = treeNodes.poll();
                int currSum = sum.poll();
                if (currSum == targetSum && treeNode.right == null && treeNode.left == null) {
                    return true;
                }

                if (treeNode.left != null) {
                    treeNodes.offer(treeNode.left);
                    sum.offer(treeNode.left.val + currSum);
                }
                if (treeNode.right != null) {
                    treeNodes.offer(treeNode.right);
                    sum.offer(treeNode.right.val + currSum);
                }
            }
        }
        return false;
    }
}

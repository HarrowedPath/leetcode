package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
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

        int output = 3;

        assert output == new MaximumDepthOfBinaryTree().BFSIteration(rootNode);
    }

    public int BFSIteration(TreeNode root) {
        int height = 0;
        if (root == null) {
            return height;
        }


        Queue<TreeNode> treeNodes = new ArrayDeque<>();

        treeNodes.add(root);


        while (!treeNodes.isEmpty()) {
            int itr = treeNodes.size();
            height++;

            while (itr-- > 0) {
                TreeNode temp = treeNodes.poll();
                if (temp.left != null) {
                    treeNodes.offer(temp.left);
                }
                if (temp.right != null) {
                    treeNodes.offer(temp.right);
                }
            }
        }

        return height;
    }
}

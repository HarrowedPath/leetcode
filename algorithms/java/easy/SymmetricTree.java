package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode firstNode = new TreeNode(2);
        TreeNode secondNode = new TreeNode(2);
        root.left = firstNode;
        root.right = secondNode;
        TreeNode fourNode = new TreeNode(3);
        firstNode.right = fourNode;
        TreeNode sixNode = new TreeNode(3);
        secondNode.right = sixNode;

        boolean output = false;

        assert output == new  SymmetricTree().iterative(root);
        assert output == new  SymmetricTree().recursive(root);
    }


    public boolean iterative(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null ^ root.right != null) {
            return false;
        }

        if (root.left.val != root.right.val) {
            return false;
        }

        Queue<TreeNode> leftQueue = new ArrayDeque<>();
        Queue<TreeNode> rightQueue = new ArrayDeque<>();

        leftQueue.offer(root.left);
        rightQueue.offer(root.right);


        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode temp1 = leftQueue.poll();
            TreeNode temp2 = rightQueue.poll();


            if (temp1.left != null ^ temp2.right != null) {
                return false;
            }
            if (temp1.right != null ^ temp2.left != null) {
                return false;
            }

            if (temp1.left != null && temp2.right != null) {
                if (temp1.left.val == temp2.right.val) {
                    leftQueue.offer(temp1.left);
                    rightQueue.offer(temp2.right);
                } else {
                    return false;
                }
            }

            if (temp1.right != null && temp2.left != null) {
                if (temp1.right.val == temp2.left.val) {
                    leftQueue.offer(temp1.right);
                    rightQueue.offer(temp2.left);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean recursive(TreeNode root) {
        return root==null || recursiveBody(root.left, root.right);
    }

    private boolean recursiveBody(TreeNode firstNode, TreeNode SecondNode) {
        if (firstNode == null || SecondNode == null)
            return firstNode == SecondNode;
        if (firstNode.val != SecondNode.val)
            return false;
        return recursiveBody(firstNode.left, SecondNode.right) && recursiveBody(firstNode.right, SecondNode.left);
    }
}

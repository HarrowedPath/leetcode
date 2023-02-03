package medium;

import datastructures.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(6);

        //TreeBuild
        root.left = b;
        root.right = c;
        c.left = d;
        c.right = e;

        boolean output = new ValidateBinarySearchTree().isValidBST(root);

        assert !output;
    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    boolean checkBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}

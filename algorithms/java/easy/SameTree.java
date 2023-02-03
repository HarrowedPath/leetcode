package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {
    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        TreeNode firstNode = new TreeNode(2);
        TreeNode secondNode = new TreeNode(3);
        treeRoot.left = firstNode;
        treeRoot.right = secondNode;

        boolean output = true;

        assert output == new SameTree().iterative(treeRoot, treeRoot);
        assert output == new SameTree().recursive(treeRoot, treeRoot);
    }

    private boolean nullCheck(TreeNode p, TreeNode q) {
        if (p == null && q == null) return false;
        if (q == null || p == null) return true;
        return p.val != q.val;
    }

    public boolean iterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (nullCheck(p, q)) {
            return false;
        }

        Queue<TreeNode> tq1 = new ArrayDeque<>();
        Queue<TreeNode> tq2 = new ArrayDeque<>();

        tq1.offer(p);
        tq2.offer(q);

        while (!tq1.isEmpty() && !tq2.isEmpty()) {
            TreeNode temp1 = tq1.poll();
            TreeNode temp2 = tq2.poll();

            if (temp1.val != temp2.val) {
                return false;
            }

            if (nullCheck(temp1.left, temp2.left)) {
                return false;
            }
            if (temp1.left != null) {
                tq1.offer(temp1.left);
                tq2.offer(temp2.left);
            }

            if (nullCheck(temp1.right, temp2.right)) {
                return false;
            }
            if (temp1.right != null) {
                tq1.offer(temp1.right);
                tq2.offer(temp2.right);
            }
        }
        return true;
    }

    public boolean recursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return recursive(p.right, q.right) &&
                recursive(p.left, q.left);
    }
}

package medium;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode.sql {
 *     int val;
 *     TreeNode.sql left;
 *     TreeNode.sql right;
 *     TreeNode.sql() {}
 *     TreeNode.sql(int val) { this.val = val; }
 *     TreeNode.sql(int val, TreeNode.sql left, TreeNode.sql right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        //TreeBuild
        root.left = b;
        root.right = c;
        c.left = d;
        c.right = e;

        var list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<>(List.of(3)));
        list.add(new ArrayList<>(List.of(9,20)));
        list.add(new ArrayList<>(List.of(15,7)));
        var output = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        assert output.equals(list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        var res = new ArrayList<List<Integer>>();
        levelHelper(root, res, 0);
        return res;
    }

    public void levelHelper(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) return;
        if (height == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        levelHelper(root.left, res, height+1);
        levelHelper(root.right,res, height+1);
    }
}

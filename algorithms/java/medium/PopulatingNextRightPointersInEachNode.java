package medium;

import datastructures.TreePointNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    //null trick
    public TreePointNode BFSiterationV1(TreePointNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreePointNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            TreePointNode curr = q.poll();

            if (curr == null && q.isEmpty()) {
                break;
            }

            if (curr == null) {
                q.add(null);
                continue;
            }

            curr.next = q.peek();

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return root;
    }

    //most common and intuitive bruteforce
    public TreePointNode BFSiterationV2(TreePointNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreePointNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreePointNode node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}


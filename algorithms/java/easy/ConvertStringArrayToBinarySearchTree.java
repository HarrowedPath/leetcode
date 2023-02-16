package easy;

import datastructures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ConvertStringArrayToBinarySearchTree {
    public TreeNode TreeNodeRecursive(int[] nums) {
        return recursiveHelpMethod(nums, 0, nums.length - 1);
    }

    private TreeNode recursiveHelpMethod(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursiveHelpMethod(nums, l, mid - 1);
        root.right = recursiveHelpMethod(nums, mid + 1, r);
        return root;
    }

    public TreeNode iterativeDFS(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode rootNode = new TreeNode(0);
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> leftIndexStack = new LinkedList<>();
        Deque<Integer> rightIndexStack = new LinkedList<>();

        nodeStack.push(rootNode);
        leftIndexStack.push(0);
        rightIndexStack.push(nums.length - 1);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int left = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid = left + (right - left) / 2;
            currentNode.val = nums[mid];
            if (left < mid) {
                currentNode.left = new TreeNode(0);
                nodeStack.push(currentNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid - 1);
            }
            if (right > mid) {
                currentNode.right = new TreeNode(0);
                nodeStack.push(currentNode.right);
                leftIndexStack.push(mid + 1);
                rightIndexStack.push(right);
            }
        }
        return rootNode;
    }
}

package datastructures;

public class TreePointNode {
    public int val;
    public TreePointNode right;
    public TreePointNode left;
    public TreePointNode next;

    public TreePointNode(int val) {
        this.val = val;
    }

    public TreePointNode(int val, TreePointNode right, TreePointNode left, TreePointNode next) {
        this.val = val;
        this.right = right;
        this.left = left;
        this.next = next;
    }

    public TreePointNode() {
    }
}

package medium;

import datastructures.ListNode;


public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode headNode = new ListNode(4, null);
        ListNode firstNode = new ListNode(5, null);
        headNode.next = firstNode;
        ListNode secondNode = new ListNode(1, null);
        firstNode.next = secondNode;
        ListNode thirdNode = new ListNode(9, null);
        secondNode.next = thirdNode;
        new DeleteNodeInALinkedList().deleteNode(firstNode);
        while (headNode != null) {
            System.out.printf("%d ", headNode.val);
            headNode = headNode.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

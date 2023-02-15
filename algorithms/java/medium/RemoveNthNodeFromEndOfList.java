package medium;

import datastructures.ListNode;

@SuppressWarnings("Duplicates")
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode rootNode = new ListNode(1, null);
        ListNode firstNode = new ListNode(2, null);
        ListNode secondNode = new ListNode(3, null);
        ListNode thirdNode = new ListNode(4, null);
        ListNode fourNode = new ListNode(5, null);
        rootNode.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourNode;
        new RemoveNthNodeFromEndOfList().calculatingSize(rootNode, 2);
        new RemoveNthNodeFromEndOfList().justTwoPointersClearSolution(rootNode, 2);
    }

    public ListNode calculatingSize(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode ptr = head;
        int len = 0;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }

        int i = len - n;
        ptr = head;
        ListNode ptr2 = head;
        boolean start = false;
        while (i != 0) {
            if (start) {
                ptr2 = ptr2.next;
            }
            start = true;
            ptr = ptr.next;
            i--;
        }

        if (ptr == head) {
            ptr2 = ptr2.next;
            head = ptr2;
        } else {
            ptr2.next = ptr.next;
        }

        return head;
    }

    public ListNode justTwoPointersClearSolution(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

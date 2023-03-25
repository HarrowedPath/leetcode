package easy;

import datastructures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode rootNode = new ListNode(3);
        var firstNode = new ListNode(2);
        var secondNode = new ListNode(0);
        var thirdNode = new ListNode(-4);
        rootNode.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = firstNode;
        boolean expectedOutput = true;
        assert expectedOutput == new LinkedListCycle().hasCycle(rootNode);
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

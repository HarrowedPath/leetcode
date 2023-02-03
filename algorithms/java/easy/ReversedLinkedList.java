package easy;

import datastructures.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class ReversedLinkedList {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReversedLinkedList.class);

    public static void main(String[] args) {
        var list = new ListNode(5, null);
        for (int i = 4; i >= 1; i--) {
            var node = new ListNode(i);
            node.next = list;
            list = node;
        }
        var output = new ReversedLinkedList().iterative(list);
        while (output != null) {
            LOGGER.info("{} ", output.val);
            output = output.next;
        }
    }

    public ListNode iterative(ListNode head) {
        if (head == null) {
            return null;
        }

        var reversed = new ListNode(head.val);
        ListNode newHead;

        while (head.next != null) {
            newHead = new ListNode(head.next.val);
            newHead.next = reversed;
            reversed = newHead;
            head = head.next;
        }
        return reversed;
    }

    public ListNode recursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        var reversed = recursive(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }
}

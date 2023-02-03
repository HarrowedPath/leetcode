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

public class MergeTwoSortedLists {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeTwoSortedLists.class);

    public static void main(String[] args) {
        var firstListNode1 = new ListNode(4, null);
        var firstListNode2 = new ListNode(2, firstListNode1);
        var firstListNode3 = new ListNode(1, firstListNode2);

        var secondListNode1 = new ListNode(4, null);
        var secondListNode2 = new ListNode(3, secondListNode1);
        var secondListNode3 = new ListNode(1, secondListNode2);

        var output = new MergeTwoSortedLists().mergeTwoLists(firstListNode3, secondListNode3);
        while (output != null) {
            LOGGER.info("{} ", output.val);
            output = output.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var head = new ListNode();
        ListNode p = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        } else {
            p.next = list2;
        }
        return head.next;
    }
}


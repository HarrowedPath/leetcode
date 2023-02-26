package medium;

import datastructures.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1Head = new ListNode(2);
        ListNode l1first = new ListNode(4);
        ListNode l1second = new ListNode(3);
        l1Head.next = l1first;
        l1first.next = l1second;
        ListNode l2Head = new ListNode(5);
        ListNode l2first = new ListNode(6);
        ListNode l2second = new ListNode(4);
        l2Head.next = l2first;
        l2first.next = l2second;

        new AddTwoNumbers().addTwoNumbers(l1Head, l2Head);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode head = new ListNode();
        ListNode ptr = head;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            ptr.next = new ListNode(sum % 10);
            sum = 0;
            ptr = ptr.next;
        }
        return head.next;
    }
}

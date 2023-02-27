package medium;

import datastructures.ListNode;

public class AddTwoNumbers {

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

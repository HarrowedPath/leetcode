package medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListCycleII {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListCycleII.class);

    public static void main(String[] args) {
        var listNode1 = new ListNode(-4, null);
        var listNode2 = new ListNode(0, listNode1);
        var listNode3 = new ListNode(2, listNode2);
        listNode1.next = listNode3;
        var listNode4 = new ListNode(3, listNode3);

        var output = new LinkedListCycleII().detectCycle(listNode4);
        for (int i = 0; i < 3; i++) {
            LOGGER.info("{} ", output.val);
            output = output.next;
        }
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if (hare == turtle) {
                turtle = head;
                while (hare != turtle) {
                    hare = hare.next;
                    turtle = turtle.next;
                }
                return turtle;
            }
        }
        return null;
    }
}

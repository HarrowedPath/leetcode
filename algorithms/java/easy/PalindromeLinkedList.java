package easy;

import datastructures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode headNode = new ListNode(1, null);
        ListNode firstNode = new ListNode(2, null);
        ListNode secondNode = new ListNode(2, null);
        ListNode thirdNode = new ListNode(1, null);
        headNode.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        boolean expectedOutput = true;
        assert expectedOutput == new PalindromeLinkedList().arrayForce(headNode);
        assert expectedOutput == new PalindromeLinkedList().listForce(headNode);
        assert expectedOutput == new PalindromeLinkedList().stringBuilderWorst(headNode);
    }

    public boolean stringBuilderWorst(ListNode head) {
        StringBuilder resultString = new StringBuilder();
        while (head != null) {
            resultString.append(head.val);
            head = head.next;
        }
        return resultString.toString().equals(resultString.reverse().toString());
    }

    public boolean arrayForce(ListNode head) {
        int[] values = new int[(int) Math.pow(10, 5)];
        int i = 0;
        while (head != null) {
            values[i] = head.val;
            head = head.next;
            i++;
        }
        int j = i - 1;
        i = 0;
        while (i < j) {
            if (values[i] != values[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean listForce(ListNode head) {
        List<Integer> valuesList = new ArrayList<>();
        while (head != null) {
            valuesList.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = valuesList.size() - 1;
        while (i < j) {
            if (!valuesList.get(i).equals(valuesList.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

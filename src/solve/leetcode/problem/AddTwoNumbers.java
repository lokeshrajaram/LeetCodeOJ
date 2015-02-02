package solve.leetcode.problem;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it
 * as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *
 * Created by Lokee on 2/1/15.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode current = null;

        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum %= 10;

            if (result == null) {
                result = new ListNode(sum);
                current = result;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum %= 10;

            if (result == null) {
                result = new ListNode(sum);
                current = result;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum %= 10;

            if (result == null) {
                result = new ListNode(sum);
                current = result;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
            l2 = l2.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return result;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

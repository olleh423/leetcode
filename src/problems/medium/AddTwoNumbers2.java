package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class AddTwoNumbers2 {

    public static void main(String[] args) {

        AddTwoNumbers2 obj = new AddTwoNumbers2();
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while(l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while(l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {

            int v1 = s1.isEmpty() ? 0 : s1.pop().val;
            int v2 = s2.isEmpty() ? 0 : s2.pop().val;

            int value = v1 + v2 + carry;
            carry = value >= 10 ? 1 : 0;
            value = value % 10;

            ListNode node = new ListNode(value);
            if(head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        if(carry == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-01-2021
 */
public class PlusOneLinkedList {

    public static void main(String[] args) {

        PlusOneLinkedList obj = new PlusOneLinkedList();
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode plusOne(ListNode head) {

        if(head == null) return head;

        int carry = addOne(head);
        if(carry == 1) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public int addOne(ListNode head) {

        if(head == null)
            return 1;

        int value = head.val + addOne(head.next);
        head.val = value % 10;
        return value / 10;
    }
}

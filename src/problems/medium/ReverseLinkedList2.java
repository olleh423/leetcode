package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ReverseLinkedList2 {

    public static void main(String[] args) {

        ReverseLinkedList2 obj = new ReverseLinkedList2();
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null || head.next == null || m == n)
            return head;

        ListNode curr = new ListNode(-1);
        ListNode prev = new ListNode(-1);
        curr.next = head;
        prev.next = head;

        int i = 0;
        while(i++ < n) {
            curr = curr.next;
        }
        i = 1;
        while(i++ < m) {
            prev = prev.next;
        }

        i = n - m + 1;
        ListNode post = curr.next;
        curr = prev.next;

        while(i-- > 0) {
            ListNode temp = curr.next;
            curr.next = post;
            post = curr;
            curr = temp;
        }
        prev.next = post;
        return m > 1 ? head : post;
    }
}

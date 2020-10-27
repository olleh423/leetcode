package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ReverseLinkedList obj = new ReverseLinkedList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode reverseList(ListNode head) {

        if(head == null)
            return head;

        ListNode temp = head, prev = null;

        while(temp != null) {

            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}

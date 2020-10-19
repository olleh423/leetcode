package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class LinkedListCycle2 {

    public static void main(String[] args) {

        LinkedListCycle2 obj = new LinkedListCycle2();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode detectCycle(ListNode head) {

        if(head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        do {
            if(fast.next == null || fast.next.next == null)
                return null;

            fast = fast.next.next;
            slow = slow.next;
        }
        while(slow != fast);

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

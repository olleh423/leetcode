package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {

        SwapNodesInPairs obj = new SwapNodesInPairs();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode prev = null, temp = head;

        while(temp != null && temp.next != null) {

            ListNode next = temp.next;
            temp.next = temp.next.next;
            next.next = temp;

            if(prev != null)
                prev.next = next;
            else
                head = next;

            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}

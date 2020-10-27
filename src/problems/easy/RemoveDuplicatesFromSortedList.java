package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null)
            return head;

        ListNode temp = head;

        while(temp.next != null) {

            if(temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}

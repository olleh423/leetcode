package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class PartitionList {

    public static void main(String[] args) {

        PartitionList obj = new PartitionList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode partition(ListNode mainHead, int x) {

        if(mainHead == null)
            return null;

        ListNode head1 = null, head2 = null, temp1 = null, temp2 = null;
        ListNode running = mainHead;

        while(running != null) {

            if(running.val < x) {
                if(head1 == null) {
                    head1 = temp1 = running;
                } else {
                    temp1.next = running;
                    temp1 = temp1.next;
                }
            }
            else {
                if(head2 == null) {
                    head2 = temp2 = running;
                } else {
                    temp2.next = running;
                    temp2 = temp2.next;
                }
            }

            running = running.next;
        }

        if(head1 == null) return mainHead;
        if(temp2 != null) temp2.next = null;

        temp1.next = head2;
        return head1;
    }
}

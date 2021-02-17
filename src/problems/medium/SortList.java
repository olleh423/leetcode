package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 17-02-2021
 */
public class SortList {

    public static void main(String[] args) {

        SortList obj = new SortList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(1);
        //head.next.next.next = new ListNode(3);
        //head.next.next.next.next = new ListNode(0);

        obj.showList(head);
        head = obj.sortList(head);
        obj.showList(head);
    }

    private void showList(ListNode head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        System.out.print(head.val + " -> ");
        showList(head.next);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return this.val+"";
        }
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode findMid(ListNode head) {

        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }

        for(int i=1 ; i<len/2 ; i++) {
            head = head.next;
        }
        return head;
    }

    private ListNode merge(ListNode one, ListNode two) {

        ListNode head = null, temp = null;
        while(one != null && two != null) {

            if(one.val < two.val) {
                if(head == null) {
                    head = temp = one;
                } else {
                    temp.next = one;
                    temp = temp.next;
                }
                one = one.next;
            }
            else {
                if(head == null) {
                    head = temp = two;
                } else {
                    temp.next = two;
                    temp = temp.next;
                }
                two = two.next;
            }
        }

        if(one == null && two == null)
            return head;

        if(one == null) temp.next = two;
        else temp.next = one;

        return head;
    }
}

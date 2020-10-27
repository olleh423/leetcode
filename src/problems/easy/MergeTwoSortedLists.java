package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

        MergeTwoSortedLists obj = new MergeTwoSortedLists();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists(ListNode one, ListNode two) {

        if(one == null && two == null) return null;
        if(one == null) return two;
        if(two == null) return one;

        ListNode newHead = null, temp = null;
        while(one != null && two != null) {

            if(one.val <= two.val) {
                if(newHead == null) {
                    newHead = temp = one;
                }
                else {
                    temp.next = one;
                    temp = temp.next;
                }
                one = one.next;
            }
            else {
                if(newHead == null) {
                    newHead = temp = two;
                }
                else {
                    temp.next = two;
                    temp = temp.next;
                }
                two = two.next;
            }
        }

        if(one == null) temp.next = two;
        else temp.next = one;

        return newHead;
    }
}

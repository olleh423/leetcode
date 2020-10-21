package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {

        NextGreaterNodeInLinkedList obj = new NextGreaterNodeInLinkedList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    private int count = 0;

    private ListNode reverse(ListNode head) {

        if(head == null)
            return null;

        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            count++;
        }
        return prev;
    }

    public int[] nextLargerNodes(ListNode head) {

        if(head == null)
            return null;

        ListNode rev = reverse(head);
        int[] result = new int[count];
        Stack<Integer> stack = new Stack<>();

        int i = result.length - 1;
        while(rev != null) {

            if(stack.isEmpty()) {
                result[i--] = 0;
                stack.push(rev.val);
                rev = rev.next;
            }
            else {
                if(stack.peek() > rev.val) {
                    result[i--] = stack.peek();
                    stack.push(rev.val);
                    rev = rev.next;
                } else {
                    stack.pop();
                }
            }
        }
        return result;
    }
}

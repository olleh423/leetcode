package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null)
            return null;

        ListNode fast = head, slow = head, prev = null;

        for(int i=1 ; i<n ; i++)
            fast = fast.next;

        while(fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(prev != null)
            prev.next = slow.next;
        else if(prev == null && fast.next == null)
            head = head.next;

        return head;
    }
}

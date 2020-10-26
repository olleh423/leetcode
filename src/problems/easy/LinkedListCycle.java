package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class LinkedListCycle {

    public static void main(String[] args) {

        LinkedListCycle obj = new LinkedListCycle();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public boolean hasCycle(ListNode head) {

        if(head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(true) {

            slow = slow.next;

            if(fast.next != null && fast.next.next != null)
                fast = fast.next.next;
            else
                break;

            if(slow == fast)
                return true;
        }

        return false;
    }
}

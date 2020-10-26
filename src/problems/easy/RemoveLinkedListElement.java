package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class RemoveLinkedListElement {

    public static void main(String[] args) {

        RemoveLinkedListElement obj = new RemoveLinkedListElement();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return null;

        ListNode newHead = null;
        ListNode prev = null;
        while(head != null) {

            if(head.val == val) {
                if(prev != null) {
                    head = prev;
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            } else {
                if(newHead == null) newHead = head;
                prev = head;
                head = head.next;
            }
        }

        return newHead;
    }
}

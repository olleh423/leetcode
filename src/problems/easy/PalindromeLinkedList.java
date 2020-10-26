package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {

        PalindromeLinkedList obj = new PalindromeLinkedList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        ListNode first = head;
        ListNode second = head;

        while(true) {
            if(second.next != null && second.next.next != null) {
                second = second.next.next;
                first = first.next;
            }
            else
                break;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = first.next;

        secondHalf = reverse(secondHalf);
        ListNode secondHalfHead = secondHalf;

        boolean result = true;
        while(firstHalf != null && secondHalf != null) {
            if(firstHalf.val != secondHalf.val) {
                result = false;
                break;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }

        firstHalf = head;
        while(firstHalf.next != null) {
            firstHalf = firstHalf.next;
        }
        firstHalf.next = reverse(secondHalfHead);

        return result;
    }

    private ListNode reverse(ListNode head) {

        if(head == null) return null;

        ListNode prev = null;
        while(head != null) {

            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

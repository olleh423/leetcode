package problems.medium;

/*
 * Auther : Vijay Sharma
 */
public class RotateList {

    public static void main(String[] args) {

        RotateList obj = new RotateList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null)
            return null;

        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }

        if(k > length)
            k = k % length;

        k = length - k;
        if(k == 0 || k == length)
            return head;

        int count = 1;
        ListNode current = head;
        while(count < k && current.next != null) {
            current = current.next;
            count++;
        }

        ListNode kthNode = current;
        temp.next = head;
        head = kthNode.next;
        kthNode.next = null;
        return head;
    }
}

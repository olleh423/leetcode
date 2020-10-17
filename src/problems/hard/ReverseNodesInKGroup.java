package problems.hard;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    private static class ReversedList {
        ListNode front;
        ListNode rear;
        ReversedList(ListNode front, ListNode rear) {
            this.front = front;
            this.rear = rear;
        }
    }

    private ReversedList reverse(ListNode head) {

        ListNode prev = null, rear = head;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return new ReversedList(prev, rear);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1 || k == 0)
            return head;

        ListNode temp = head;
        ListNode newHead = null, newEnd = null, partHead = head;

        int i = 1;
        while(true) {

            if(head == null)
                break;

            if(i % k == 0) {

                ListNode next = head.next;
                head.next = null;

                ReversedList result = reverse(partHead);
                if(newHead == null) {
                    newHead = result.front;
                    newEnd = result.rear;
                } else {
                    newEnd.next = result.front;
                    newEnd = result.rear;
                }
                head = partHead = next;

            } else {

                head = head.next;
            }

            i++;
        }

        if(newEnd == null)
            return temp;

        if(partHead != null)
            newEnd.next = partHead;

        return newHead;
    }
}

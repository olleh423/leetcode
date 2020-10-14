package problems;

public class OddEvenLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(5);

        OddEvenLinkedList obj = new OddEvenLinkedList();
        obj.printList(obj.oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode oddHead = head;
        ListNode evenStart = head.next;
        ListNode evenHead = head.next;

        while(evenHead != null){
            oddHead.next = evenHead.next;
            if(oddHead.next != null){
                oddHead = oddHead.next;
            }

            evenHead.next = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = evenStart;
        return head;
    }

    private void printList(ListNode head) {
        if(head == null) {
            System.out.println("NULL");
            return;
        }
        System.out.print(head.val + " -> ");
        printList(head.next);
    }
}

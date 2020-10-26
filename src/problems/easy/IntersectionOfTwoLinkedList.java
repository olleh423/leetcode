package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class IntersectionOfTwoLinkedList {

    public static void main(String[] args) {

        IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        int lengthA = length(headA);
        int lengthB = length(headB);

        if(lengthA > lengthB) {

            while(lengthA > lengthB) {
                headA = headA.next;
                lengthA--;
            }
        }
        else if(lengthB > lengthA) {
            while(lengthB > lengthA) {
                headB = headB.next;
                lengthB--;
            }
        }

        while(headA != null || headB != null) {

            if(headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int length(ListNode head) {

        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

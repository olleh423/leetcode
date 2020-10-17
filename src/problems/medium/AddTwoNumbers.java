package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        AddTwoNumbers obj = new AddTwoNumbers();
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode one, ListNode two) {

        if(one == null && two == null) return null;
        if(one == null) return two;
        if(two == null) return one;

        ListNode newHead = null, temp = null;
        int carry = 0;

        while(one != null || two != null) {

            int sum = carry + (one == null ? 0 : one.val) + (two == null ? 0 : two.val);
            if(sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(sum);
            if(newHead == null) {
                newHead = temp = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }

            one = one == null ? one : one.next;
            two = two == null ? two : two.next;
        }

        if(carry == 1) temp.next = new ListNode(carry);

        return newHead;
    }
}

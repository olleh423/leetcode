package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ReorderList {

    public static void main(String[] args) {

        ReorderList obj = new ReorderList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public void reorderList(ListNode head) {

        if(head == null)
            return ;
        if(head.next == null || head.next.next == null)
            return;

        List<ListNode> list = new ArrayList<>();
        decompose(head, list);

        head = list.get(0);
        ListNode temp = head;
        boolean flag = true;
        int i=1, j=list.size() - 1;
        while(i <= j) {

            if(flag) temp.next = list.get(j--);
            else temp.next = list.get(i++);

            flag = !flag;
            temp = temp.next;
        }

        if(temp != null)
            temp.next = null;
    }

    private void decompose(ListNode head, List<ListNode> list) {
        if(head == null)
            return;
        list.add(head);
        decompose(head.next, list);
    }
}

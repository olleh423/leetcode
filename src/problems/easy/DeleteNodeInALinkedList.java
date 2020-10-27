package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DeleteNodeInALinkedList {

    public static void main(String[] args) {

        DeleteNodeInALinkedList obj = new DeleteNodeInALinkedList();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {

        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
    }

    private static class Node {
        int val;
        Node next, random;
        Node(int val) { this.val = val; }
    }

    public Node copyRandomList(Node head) {

        if(head == null)
            return null;

        Node temp = head;
        while(temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        Node newHead = null, newHeadRun = null;
        temp = head;
        while(temp != null) {

            if(newHead == null) {
                newHead = temp.next;
                newHeadRun = temp.next;
                temp.next = temp.next.next;
                temp = temp.next;
            }
            else {
                newHeadRun.next = temp.next;
                temp.next = temp.next.next;
                newHeadRun = newHeadRun.next;
                temp = temp.next;
            }
        }

        newHeadRun.next = null;
        return newHead;
    }
}

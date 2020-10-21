package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class PrintImmutableLinkedListInReverse {

    public static void main(String[] args) {

        PrintImmutableLinkedListInReverse obj = new PrintImmutableLinkedListInReverse();
    }

    private static class ImmutableListNode {
        int val;
        ImmutableListNode getNext() {
            return null;
        }
        void printValue() {

        }
    }

    public void printLinkedListInReverse(ImmutableListNode head) {

        if(head == null) return;

        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}

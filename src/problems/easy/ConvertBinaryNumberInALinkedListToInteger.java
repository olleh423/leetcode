package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {

        ConvertBinaryNumberInALinkedListToInteger obj = new ConvertBinaryNumberInALinkedListToInteger();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    public int getDecimalValue(ListNode head) {

        Result res = new Result();
        convert(head, res);
        return res.v;
    }

    private void convert(ListNode head, Result res) {

        if(head == null)
            return;

        convert(head.next, res);
        res.v += head.val == 0 ? 0 : res.f;
        res.f *= 2;
    }

    private static class Result {
        int f;
        int v;
        Result() { f = 1; v = 0; }
    }
}

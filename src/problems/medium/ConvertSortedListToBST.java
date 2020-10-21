package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ConvertSortedListToBST {

    public static void main(String[] args) {

        ConvertSortedListToBST obj = new ConvertSortedListToBST();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null) return null;
        List<ListNode> list = convertToList(head);
        return convertToBST(list, 0, list.size()-1);
    }

    private List<ListNode> convertToList(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        return list;
    }

    private TreeNode convertToBST(List<ListNode> list, int i, int j) {

        if(i > j) return null;
        if(i == j) return new TreeNode(list.get(i).val);

        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = convertToBST(list, i, mid - 1);
        root.right = convertToBST(list, mid + 1, j);
        return root;
    }
}

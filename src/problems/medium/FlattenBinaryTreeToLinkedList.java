package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 12-02-2021
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public void flatten(TreeNode root) {
        solve(root, null);
    }

    private TreeNode solve(TreeNode root, TreeNode right) {
        if(root == null) return right;
        root.right = solve(root.right, right);
        root.right = solve(root.left, root.right);
        root.left = null;
        return root;
    }
}

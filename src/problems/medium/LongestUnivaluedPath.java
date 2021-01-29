package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 28-01-2021
 */
public class LongestUnivaluedPath {

    public static void main(String[] args) {

        LongestUnivaluedPath obj = new LongestUnivaluedPath();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int longestUnivaluePath(TreeNode root) {

        int[] result = {0};
        solve(root, result);
        return result[0];
    }

    private int solve(TreeNode root, int[] result) {

        if(root == null)
            return 0;

        int leftPath = solve(root.left, result);
        int rightPath = solve(root.right, result);

        int left = 0, right = 0;
        if(root.left != null && root.val == root.left.val) {
            left = leftPath + 1;
        }
        if(root.right != null && root.val == root.right.val) {
            right = rightPath + 1;
        }

        result[0] = Math.max(result[0], left + right);
        return Math.max(left, right);
    }
}

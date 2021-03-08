package problems.medium;/*
 * Author : Vijay Sharma 08-03-2021
 */

public class LongestZigzagPathInABinaryTree {

    public static void main(String[] args) {

    }

    private static class TreeNode {
        TreeNode left, right;
    }

    public int longestZigZag(TreeNode root) {

        int[] result = new int[1];
        solve(root, true, result);
        return result[0]-1;
    }

    public int solve(TreeNode root, boolean isLeft, int[] result) {

        if(root == null)
            return 0;

        int left = solve(root.left, true, result);
        int right = solve(root.right, false, result);

        result[0] = Math.max(result[0], 1 + Math.max(left, right));
        return 1 + (isLeft ? right : left);
    }
}

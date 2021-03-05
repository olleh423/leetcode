package problems.easy;/*
 * Author : Vijay Sharma 05-03-2021
 */

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int minDepth(TreeNode root) {

        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0) return 1 + right;
        if(right == 0) return 1 + left;
        return 1 + Math.min(left, right);
    }
}

package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}

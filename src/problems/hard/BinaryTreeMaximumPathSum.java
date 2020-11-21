package problems.hard;

import java.util.*;

/*
 * Author : Vijay Sharma 21-11-2020
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int maxPathSum(TreeNode root) {

        int[] result = {Integer.MIN_VALUE};
        if(root == null) return 0;

        maxPath(root, result);
        return result[0];
    }

    private int maxPath(TreeNode root, int[] result) {

        if(root == null) return 0;

        int left = maxPath(root.left, result);
        int right = maxPath(root.right, result);

        int sp = Math.max(Math.max(left, right) + root.val, root.val);
        int cRoot = Math.max(sp, left + right + root.val);
        result[0] = Math.max(result[0], cRoot);

        return sp;
    }
}

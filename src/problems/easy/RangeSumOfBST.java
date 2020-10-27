package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RangeSumOfBST {

    public static void main(String[] args) {

        RangeSumOfBST obj = new RangeSumOfBST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        if(root == null)
            return 0;

        int left = 0;
        int right = 0;

        if(root.val >= L)
            left = rangeSumBST(root.left, L, R);
        if(root.val <= R)
            right = rangeSumBST(root.right, L, R);

        if(root.val >= L && root.val <= R)
            return root.val + left + right;
        else
            return left + right;
    }
}

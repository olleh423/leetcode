package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {

        BinarySearchTreeToGreaterSumTree obj = new BinarySearchTreeToGreaterSumTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode bstToGst(TreeNode root) {
        convert(root, 0);
        return root;
    }

    private int convert(TreeNode root, int v) {
        if(root == null) return v;
        int r = convert(root.right, v);
        root.val += r;
        return convert(root.left, root.val);
    }
}

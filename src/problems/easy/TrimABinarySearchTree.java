package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class TrimABinarySearchTree {

    public static void main(String[] args) {

        TrimABinarySearchTree obj = new TrimABinarySearchTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if(root == null)
            return null;

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        if(root.val < L) {
            TreeNode right = root.right;
            root = null;
            return right;
        }

        if(root.val > R) {
            TreeNode left = root.left;
            root = null;
            return left;
        }

        return root;
    }
}

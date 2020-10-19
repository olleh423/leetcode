package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class LowestCommonAncestorBinaryTree {

    public static void main(String[] args) {

        LowestCommonAncestorBinaryTree obj = new LowestCommonAncestorBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {

        if(root == null) return null;
        if(root == n1 || root == n2) return root;

        TreeNode left = lowestCommonAncestor(root.left, n1, n2);
        TreeNode right = lowestCommonAncestor(root.right, n1, n2);

        if(left != null && right != null) return root;
        if(left == null && right == null) return null;

        return left != null ? left : right;
    }
}

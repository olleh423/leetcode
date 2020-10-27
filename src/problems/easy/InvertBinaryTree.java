package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class InvertBinaryTree {

    public static void main(String[] args) {

        InvertBinaryTree obj = new InvertBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return root;

        TreeNode temp = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}

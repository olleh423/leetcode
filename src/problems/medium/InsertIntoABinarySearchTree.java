package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class InsertIntoABinarySearchTree {

    public static void main(String[] args) {

        InsertIntoABinarySearchTree obj = new InsertIntoABinarySearchTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = new TreeNode(val);

        if(root == null)
            return node;

        TreeNode mainRoot = root;

        while(true) {

            if(root.val < val) {
                if(root.right == null) {
                    root.right = node;
                    break;
                } else {
                    root = root.right;
                }
            } else {
                if(root.left == null) {
                    root.left = node;
                    break;
                } else {
                    root = root.left;
                }
            }
        }

        return mainRoot;
    }
}

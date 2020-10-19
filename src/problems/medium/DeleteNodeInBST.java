package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class DeleteNodeInBST {

    public static void main(String[] args) {

        DeleteNodeInBST obj = new DeleteNodeInBST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null)
            return root;

        if(root.val == key) {

            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;

            root.val = getLeftMostValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        else if(root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);

        return root;
    }

    private int getLeftMostValue(TreeNode root) {

        if(root.left == null)
            return root.val;

        return getLeftMostValue(root.left);
    }
}

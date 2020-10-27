package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SearchInABinarySearchTree {

    public static void main(String[] args) {

        SearchInABinarySearchTree obj = new SearchInABinarySearchTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null)
            return null;

        if(root.val == val)
            return root;

        TreeNode node = null;
        if(root.val > val)
            node = searchBST(root.left, val);

        if(node != null)
            return node;

        return searchBST(root.right, val);
    }
}

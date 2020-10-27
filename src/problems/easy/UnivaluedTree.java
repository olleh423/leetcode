package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class UnivaluedTree {

    public static void main(String[] args) {

        UnivaluedTree obj = new UnivaluedTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isUnivalTree(TreeNode root) {

        if(root == null)
            return true;

        return isUnivalued(root, root.val);
    }

    private boolean isUnivalued(TreeNode root, int value) {

        if(root == null)
            return true;

        if(root.val != value)
            return false;

        return isUnivalued(root.left, value) && isUnivalued(root.right, value);
    }
}

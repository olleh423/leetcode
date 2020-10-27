package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SymmetricTree {

    public static void main(String[] args) {

        SymmetricTree obj = new SymmetricTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode one, TreeNode two) {

        if(one == null && two == null) return true;
        if(one == null || two == null) return false;

        if(one.val != two.val) return false;

        return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }
}

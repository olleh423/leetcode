package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SameTree {

    public static void main(String[] args) {

        SameTree obj = new SameTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null)return true;
        if(p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

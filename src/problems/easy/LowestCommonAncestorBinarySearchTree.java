package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class LowestCommonAncestorBinarySearchTree {

    public static void main(String[] args) {

        LowestCommonAncestorBinarySearchTree obj = new LowestCommonAncestorBinarySearchTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return
                root;
    }
}

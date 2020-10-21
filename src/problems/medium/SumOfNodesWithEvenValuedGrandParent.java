package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class SumOfNodesWithEvenValuedGrandParent {

    public static void main(String[] args) {

        SumOfNodesWithEvenValuedGrandParent obj = new SumOfNodesWithEvenValuedGrandParent();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int sumEvenGrandparent(TreeNode root) {

        if(root == null) return 0;
        return sum(root.left, root, false) + sum(root.right, root, false);
    }

    private int sum(TreeNode root, TreeNode parent, boolean isEven) {

        if(root == null) return 0;
        int total = sum(root.left, root, parent.val % 2 == 0) + sum(root.right, root, parent.val % 2 == 0);
        return isEven ? total + root.val : total;
    }
}

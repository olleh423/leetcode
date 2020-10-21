package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {

        CountGoodNodesInBinaryTree obj = new CountGoodNodesInBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int goodNodes(TreeNode root) {

        if(root == null) return 0;
        int MAX = root.val;
        return 1 + count(root.left, MAX) + count(root.right, MAX);
    }

    private int count(TreeNode root, int MAX) {

        if(root == null) return 0;

        int count = 0;
        if(MAX <= root.val)
            count += 1;

        count += count(root.left, Math.max(MAX, root.val));
        count += count(root.right, Math.max(MAX, root.val));
        return count;
    }
}

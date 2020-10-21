package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-10-2020
 */
public class ConstructBinaryTreeFromPreorderInorder {

    public static void main(String[] args) {

        ConstructBinaryTreeFromPreorderInorder obj = new ConstructBinaryTreeFromPreorderInorder();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || inorder == null) return null;

        int[] preIndex = {0};
        return buildTree(preorder, inorder, 0, inorder.length-1, preIndex);
    }

    private TreeNode buildTree(int[] PRE, int[] IN, int left, int right, int[] preIndex) {

        if(left > right) return null;

        TreeNode root = new TreeNode(PRE[preIndex[0]]);
        preIndex[0]++;

        if(left == right) return root;

        int rootIndex = indexOf(IN, left, right, root.val);
        root.left = buildTree(PRE, IN, left, rootIndex - 1, preIndex);
        root.right = buildTree(PRE, IN, rootIndex + 1, right, preIndex);
        return root;
    }

    private int indexOf(int[] IN, int left, int right, int target) {
        while(left <= right) {
            if(IN[left] == target)
                return left;
            left++;
        }
        return -1;
    }
}

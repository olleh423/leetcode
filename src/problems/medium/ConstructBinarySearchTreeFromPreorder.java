package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class ConstructBinarySearchTreeFromPreorder {

    public static void main(String[] args) {

        ConstructBinarySearchTreeFromPreorder obj = new ConstructBinarySearchTreeFromPreorder();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        if(preorder == null)
            return null;

        return generateBST(preorder, 0, preorder.length-1);
    }

    private TreeNode generateBST(int[] PRE, int i, int j) {

        if(i > j) return null;
        if(i == j) return new TreeNode(PRE[i]);

        TreeNode root = new TreeNode(PRE[i]);
        int idx = findFirstGreaterIndex(PRE, PRE[i], i+1, j);
        if(idx != -1) {
            root.left = generateBST(PRE, i+1, idx-1);
            root.right = generateBST(PRE, idx, j);
        }
        else {
            root.left = generateBST(PRE, i+1, j);
        }
        return root;
    }

    private int findFirstGreaterIndex(int[] PRE, int target, int i, int j) {
        while(i <= j) {
            if(PRE[i] > target)
                return i;
            i++;
        }
        return -1;
    }
}

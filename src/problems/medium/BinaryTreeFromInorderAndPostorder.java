package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {

        BinaryTreeFromInorderAndPostorder obj = new BinaryTreeFromInorderAndPostorder();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || postorder == null)
            return null;

        Index pIndex = new Index(postorder.length - 1);
        return buildTree(inorder, postorder, 0, inorder.length - 1, pIndex);
    }

    private static class Index {
        int index;
        Index(int index) {
            this.index = index;
        }
    }

    public TreeNode buildTree(int[] IN, int[] POST, int left, int right, Index pIndex) {

        if(left > right)
            return null;

        TreeNode root = new TreeNode(POST[pIndex.index]);
        (pIndex.index)--;

        if(left == right)
            return root;

        int rootIndex = indexOf(IN, left, right, root.val);

        root.right = buildTree(IN, POST, rootIndex + 1, right, pIndex);
        root.left = buildTree(IN, POST, left, rootIndex - 1, pIndex);

        return root;
    }

    private int indexOf(int[] arr, int left, int right, int target) {

        while(left <= right) {
            if(arr[left] == target)
                return left;
            left++;
        }
        return -1;
    }
}

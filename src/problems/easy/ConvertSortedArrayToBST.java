package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {

        ConvertSortedArrayToBST obj = new ConvertSortedArrayToBST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null) return null;
        return createBST(nums, 0, nums.length-1);
    }

    private TreeNode createBST(int[] nums, int i, int j) {

        if(i == j) return new TreeNode(nums[i]);
        if(i > j) return null;

        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createBST(nums, i, mid - 1);
        node.right = createBST(nums, mid + 1, j);
        return node;
    }
}

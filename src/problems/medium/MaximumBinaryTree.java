package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {

        MaximumBinaryTree obj = new MaximumBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if(nums == null)
            return null;

        return solve(nums, 0, nums.length - 1);
    }

    private TreeNode solve(int[] nums, int i, int j) {

        if(i > j) return null;
        if(i == j) return new TreeNode(nums[i]);

        int mIndex = getMaxIndex(nums, i, j);

        TreeNode root = new TreeNode(nums[mIndex]);
        root.left = solve(nums, i, mIndex-1);
        root.right = solve(nums, mIndex+1, j);

        return root;
    }

    private int getMaxIndex(int[] nums, int i, int j) {

        if(i == j) return i;
        int maxIndex = i;
        while(i <= j) {
            if(nums[maxIndex] < nums[i])
                maxIndex = i;
            i++;
        }
        return maxIndex;
    }
}

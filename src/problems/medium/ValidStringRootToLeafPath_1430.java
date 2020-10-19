package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ValidStringRootToLeafPath_1430 {

    public static void main(String[] args) {

        ValidStringRootToLeafPath_1430 obj = new ValidStringRootToLeafPath_1430();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }

    private boolean isValid(TreeNode root, int[] arr, int i) {

        if(root == null || root.val != arr[i])
            return false;
        if(i == arr.length-1 && root.left == null && root.right == null)
            return true;
        if(i == arr.length-1)
            return false;

        return isValid(root.left, arr, i+1) || isValid(root.right, arr, i+1);
    }
}

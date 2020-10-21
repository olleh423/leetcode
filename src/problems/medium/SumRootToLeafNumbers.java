package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-10-2020
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {

        SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private static class Result {
        int value;
    }

    public void sumNumbers(TreeNode root, int total, Result result) {

        if(root == null) {
            result.value = total;
            return;
        }
        if(root.left == null && root.right == null) {
            result.value += (total + root.val);
            return;
        }

        if(root.left != null)
            sumNumbers(root.left, (total+root.val)*10, result);

        if(root.right != null)
            sumNumbers(root.right, (total+root.val)*10, result);
    }

    public int sumNumbers(TreeNode root) {
        Result result = new Result();
        sumNumbers(root, 0, result);
        return result.value;
    }
}

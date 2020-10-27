package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class BinaryTreeTilt {

    public static void main(String[] args) {

        BinaryTreeTilt obj = new BinaryTreeTilt();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private static class Result {
        int totalSum;
        int totalTilt;
        Result(int totalSum, int totalTilt) {
            this.totalSum = totalSum;
            this.totalTilt = totalTilt;
        }
    }

    private Result solve(TreeNode root) {

        if(root == null)
            return new Result(0, 0);

        Result left = solve(root.left);
        Result right = solve(root.right);

        int tilt = Math.abs(left.totalSum - right.totalSum);

        return new Result(root.val + left.totalSum + right.totalSum, tilt + left.totalTilt + right.totalTilt);
    }

    public int findTilt(TreeNode root) {

        return solve(root).totalTilt;
    }
}

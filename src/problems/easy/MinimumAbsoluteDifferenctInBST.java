package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MinimumAbsoluteDifferenctInBST {

    public static void main(String[] args) {

        MinimumAbsoluteDifferenctInBST obj = new MinimumAbsoluteDifferenctInBST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int getMinimumDifference(TreeNode root) {

        return minAbsDiff(root);
    }

    private int minAbsDiff(TreeNode root) {

        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        push(root, stack);
        int min = Integer.MAX_VALUE;
        int prev = -1;

        while(!stack.isEmpty()) {

            TreeNode n = stack.pop();
            if(prev != -1) {
                int absDiff = Math.abs(prev - n.val);
                min = Math.min(min, absDiff);
            }
            prev = n.val;
            push(n.right, stack);
        }

        return min;
    }

    private void push(TreeNode root, Stack<TreeNode> stack) {

        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class MaximumAverageSubTree {

    public static void main(String[] args) {

        MaximumAverageSubTree obj = new MaximumAverageSubTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private static class Pair {
        double total;
        double totalNodes;
        Pair(double total, double totalNodes) {
            this.total = total;
            this.totalNodes = totalNodes;
        }
    }

    public double maximumAverageSubtree(TreeNode root) {

        if(root == null)
            return 0;

        double[] max = new double[1];
        solve(root, max);
        return max[0];
    }

    private Pair solve(TreeNode root, double[] max) {

        if(root == null)
            return null;

        Pair left = solve(root.left, max);
        Pair right = solve(root.right, max);

        double totalNodes = 1;
        double total = root.val;

        if(left != null) {
            total += left.total;
            totalNodes += left.totalNodes;
        }

        if(right != null) {
            total += right.total;
            totalNodes += right.totalNodes;
        }
        double avg = (double)(total / totalNodes);
        max[0] = Math.max(max[0], avg);
        return new Pair(total, totalNodes);
    }
}

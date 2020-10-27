package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {

        MinimumDistanceBetweenBSTNodes obj = new MinimumDistanceBetweenBSTNodes();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int minDiffInBST(TreeNode root) {

        if(root == null)
            return -1;

        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);

        int diff = Integer.MAX_VALUE;
        for(int i=1 ; i<inOrder.size() ; i++) {
            diff = Math.min(diff, inOrder.get(i) - inOrder.get(i-1));
        }
        return diff;
    }

    private void inOrder(TreeNode root, List<Integer> inOrder) {
        if(root == null)
            return;
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }
}

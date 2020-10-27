package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SumOfRootToLeafBinaryNumbers {

    public static void main(String[] args) {

        SumOfRootToLeafBinaryNumbers obj = new SumOfRootToLeafBinaryNumbers();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private static class Result {
        int res = 0;
    }

    public int sumRootToLeaf(TreeNode root) {

        if(root == null)
            return 0;

        Result res = new Result();
        sum(root, res, new StringBuilder());
        return res.res;
    }

    private void sum(TreeNode root, Result res, StringBuilder sb) {

        if(root == null)
            return;

        sb.append(root.val);
        if(root.left == null && root.right == null)
            res.res += toDecimal(sb);

        if(root.left != null) sum(root.left, res, sb);
        if(root.right != null) sum(root.right, res, sb);

        sb.deleteCharAt(sb.length() - 1);
    }

    private int toDecimal(StringBuilder sb) {

        if(sb.length() == 0)
            return 0;

        int total = 0;
        int factor = 1;
        for(int i=sb.length()-1 ; i>=0 ; i--) {
            if(sb.charAt(i) == '1') {
                total += factor;
            }
            factor *= 2;
        }

        return total;
    }
}

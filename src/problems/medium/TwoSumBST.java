package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class TwoSumBST {

    public static void main(String[] args) {

        TwoSumBST obj = new TwoSumBST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        if(root1 == null || root2 == null)
            return false;

        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        inorder(root1, one);
        inorder(root2, two);

        int i=0, j=two.size()-1;
        while(i < one.size() && j >= 0) {

            int sum = one.get(i) + two.get(j);
            if(sum == target)
                return true;

            if(sum < target) i++;
            else j--;
        }

        return false;
    }

    public void inorder(TreeNode root, List<Integer> result) {

        if(root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}

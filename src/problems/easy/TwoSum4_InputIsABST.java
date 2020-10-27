package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class TwoSum4_InputIsABST {

    public static void main(String[] args) {

        TwoSum4_InputIsABST obj = new TwoSum4_InputIsABST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean findTarget(TreeNode root, int k) {

        if(root == null)
            return false;

        List<Integer> values = new ArrayList<>();
        traverse(root, values);

        int i=0, j=values.size() - 1;
        while(i < j) {
            int sum = values.get(i) + values.get(j);
            if(sum == k)
                return true;
            if(sum < k)
                i++;
            else
                j--;
        }
        return false;
    }

    private void traverse(TreeNode root, List<Integer> values) {
        if(root == null)
            return;
        traverse(root.left, values);
        values.add(root.val);
        traverse(root.right, values);
    }
}

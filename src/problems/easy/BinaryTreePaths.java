package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

        BinaryTreePaths obj = new BinaryTreePaths();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if(root == null)
            return result;

        populatePaths(root, result, "");

        return result;
    }

    private void populatePaths(TreeNode root, List<String> result, String current) {

        if(root.left == null && root.right == null) {
            result.add(current + root.val);
            return;
        }

        current += root.val + "->";

        if(root.left != null)
            populatePaths(root.left, result, current);
        if(root.right != null)
            populatePaths(root.right, result, current);
    }
}

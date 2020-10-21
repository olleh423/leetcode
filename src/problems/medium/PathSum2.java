package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class PathSum2 {

    public static void main(String[] args) {

        PathSum2 obj = new PathSum2();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        getPaths(root, sum, new ArrayList<Integer>(), result);
        return result;
    }

    private void getPaths(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {

        if(root == null)
            return;

        path.add(root.val);
        if(target - root.val == 0 && root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        getPaths(root.left, target - root.val, new ArrayList<Integer>(path), result);
        getPaths(root.right, target - root.val, new ArrayList<Integer>(path), result);
    }
}

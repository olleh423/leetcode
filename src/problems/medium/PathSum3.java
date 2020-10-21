package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class PathSum3 {

    public static void main(String[] args) {

        PathSum3 obj = new PathSum3();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private static class Result {
        int count = 0;
    }
    public int pathSum(TreeNode root, int target) {

        if(root == null)
            return 0;

        Result result = new Result();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        pathSum(root, target, 0, result, map);
        return result.count;
    }

    private void pathSum(TreeNode root, int target, int current, Result result, Map<Integer, Integer> map)     {

        if(root == null)
            return;

        current += root.val;
        int key = current - target;
        if(map.containsKey(key))
            result.count += map.get(key);

        map.put(current, map.getOrDefault(current, 0) + 1);
        pathSum(root.left, target, current, result, map);
        pathSum(root.right, target, current, result, map);
        map.put(current, map.get(current) - 1);
    }
}

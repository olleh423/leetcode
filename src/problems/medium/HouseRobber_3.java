package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 12-02-2021
 */
public class HouseRobber_3 {

    public static void main(String[] args) {

        HouseRobber_3 obj = new HouseRobber_3();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {

        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);

        int includeRoot = root.val;
        if(root.left != null) includeRoot += (rob(root.left.left) + rob(root.left.right));
        if(root.right != null) includeRoot += (rob(root.right.left) + rob(root.right.right));

        int excludeRoot = rob(root.left) + rob(root.right);
        int result = Math.max(includeRoot, excludeRoot);
        map.put(root, result);
        return result;
    }
}

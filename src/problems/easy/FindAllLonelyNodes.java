package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FindAllLonelyNodes {

    public static void main(String[] args) {

        FindAllLonelyNodes obj = new FindAllLonelyNodes();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> getLonelyNodes(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        getLonelyNodes(root, result);
        return result;
    }

    private void getLonelyNodes(TreeNode root, List<Integer> result) {

        if(root == null) return;

        if(root.left != null && root.right == null)
            result.add(root.left.val);
        if(root.right != null && root.left == null)
            result.add(root.right.val);

        getLonelyNodes(root.left, result);
        getLonelyNodes(root.right, result);
    }
}

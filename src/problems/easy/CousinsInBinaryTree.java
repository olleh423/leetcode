package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 30-01-2021
 */
public class CousinsInBinaryTree {

    public static void main(String[] args) {

        CousinsInBinaryTree obj = new CousinsInBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private static class DepthWithParent {
        int depth;
        TreeNode parent;
        DepthWithParent(int depth, TreeNode parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null)
            return false;

        DepthWithParent xDepth = findParent(root, x, null, 0);
        DepthWithParent yDepth = findParent(root, y, null, 0);

        if(xDepth.depth != yDepth.depth)
            return false;

        return xDepth.parent != yDepth.parent;
    }

    private DepthWithParent findParent(TreeNode root, int target, TreeNode parent, int depth) {

        if(root == null)
            return null;

        if(root.val == target)
            return new DepthWithParent(depth, parent);

        DepthWithParent left = findParent(root.left, target, root, depth + 1);
        if(left != null)
            return left;

        return findParent(root.right, target, root, depth + 1);
    }
}

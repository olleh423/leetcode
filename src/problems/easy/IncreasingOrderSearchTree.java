package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class IncreasingOrderSearchTree {

    public static void main(String[] args) {

        IncreasingOrderSearchTree obj = new IncreasingOrderSearchTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode increasingBST(TreeNode root) {

        if(root == null)
            return null;

        List<TreeNode> inOrder = new ArrayList<>();
        inOrder(root, inOrder);

        for(int i=0 ; i<inOrder.size() - 1 ; i++) {
            TreeNode node = inOrder.get(i);
            node.left = null;
            node.right = inOrder.get(i+1);
        }
        inOrder.get(inOrder.size() - 1).left = null;
        inOrder.get(inOrder.size() - 1).right = null;
        return inOrder.get(0);
    }

    private void inOrder(TreeNode root, List<TreeNode> inOrder) {

        if(root == null)
            return;
        inOrder(root.left, inOrder);
        inOrder.add(root);
        inOrder(root.right, inOrder);
    }
}

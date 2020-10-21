package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class BinaryTreeInOrderTraversal {

    public static void main(String[] args) {

        BinaryTreeInOrderTraversal obj = new BinaryTreeInOrderTraversal();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        pushLeft(root, stack);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            pushLeft(node.right, stack);
        }

        return result;
    }

    private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        if(root == null) return;
        stack.push(root);
        pushLeft(root.left, stack);
    }
}

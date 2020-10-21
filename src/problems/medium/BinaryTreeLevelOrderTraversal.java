package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> row = new ArrayList<>();
        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if(node == null) {
                result.add(row);
                row = new ArrayList<>();
                if(!queue.isEmpty())
                    queue.add(null);
            } else {
                row.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }

        return result;
    }
}

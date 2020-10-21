package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {

        BinaryTreeZigzagLevelOrderTraversal obj = new BinaryTreeZigzagLevelOrderTraversal();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;

        while(!queue.isEmpty()) {

            LinkedList<Integer> row = new LinkedList();
            int size = queue.size();

            for(int i=0 ; i<size ; i++) {

                TreeNode node = queue.poll();

                if(flag) row.add(node.val);
                else row.addFirst(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            flag = !flag;
            result.add(row);
        }

        return result;
    }
}

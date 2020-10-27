package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class BinaryTreeLevelOrderTraversal_2 {

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal_2 obj = new BinaryTreeLevelOrderTraversal_2();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> level = new ArrayList<>();
        while(! queue.isEmpty()) {

            TreeNode node = queue.poll();

            if(node != null) {
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            else {
                result.add(level);
                level = new ArrayList<>();
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }

        int i=0, j=result.size() - 1;
        while(i < j) {
            List<Integer> temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++; j--;
        }

        return result;
    }
}

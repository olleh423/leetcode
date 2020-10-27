package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {

        AverageOfLevelsInBinaryTree obj = new AverageOfLevelsInBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if(root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            double size = queue.size();
            double total = 0;
            for(int i=0 ; i<size ; i++) {

                TreeNode node = queue.poll();
                total += node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            result.add((double) total / size);
        }

        return result;
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {

        MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private static class Holder {
        TreeNode node;
        int pos;
        Holder(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if(root == null)
            return 0;

        LinkedList<Holder> queue = new LinkedList<>();
        queue.add(new Holder(root, 0));

        int max = 1;
        while(!queue.isEmpty()) {

            int size = queue.size();
            max = Math.max(max, queue.peekLast().pos - queue.peekFirst().pos + 1);

            for(int i=0 ; i<size ; i++) {
                Holder ch = queue.poll();
                if(ch.node.left != null)
                    queue.add(new Holder(ch.node.left, ch.pos * 2));
                if(ch.node.right != null)
                    queue.add(new Holder(ch.node.right, ch.pos * 2 + 1));
            }
        }
        return max;
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {

        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();
    }

    private static class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {

            Pair pair = queue.poll();
            if(!map.containsKey(pair.index))
                map.put(pair.index, new ArrayList<Integer>());

            map.get(pair.index).add(pair.node.val);
            if(pair.node.left != null)
                queue.add(new Pair(pair.node.left, pair.index-1));
            if(pair.node.right != null)
                queue.add(new Pair(pair.node.right, pair.index+1));

        }

        for(int key : map.keySet())
            result.add(map.get(key));

        return result;
    }
}

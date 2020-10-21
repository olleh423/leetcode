package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class NAryArrayLevelOrderTraversal {

    public static void main(String[] args) {

        NAryArrayLevelOrderTraversal obj = new NAryArrayLevelOrderTraversal();
    }

    private static class Node {
        int val;
        List<Node> children;
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> data = new ArrayList<>();

        if(root == null)
            return data;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> row = new ArrayList<>();
        while(! queue.isEmpty()) {

            Node n = queue.remove();
            if(n != null) {
                row.add(n.val);
                if(n.children != null) {
                    for(Node ch : n.children)
                        queue.add(ch);
                }
            } else {
                if(!queue.isEmpty())
                    queue.add(null);
                data.add(row);
                row = new ArrayList<>();
            }
        }

        return data;
    }
}

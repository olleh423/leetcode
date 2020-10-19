package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class PopulatingNextRightPointerInEachNode {

    public static void main(String[] args) {

        PopulatingNextRightPointerInEachNode obj = new PopulatingNextRightPointerInEachNode();
    }

    private static class Node {
        int val;
        Node left, right, next;
    }

    public Node connect(Node root) {

        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(! queue.isEmpty()) {

            Node node = queue.poll();
            if(node != null) {
                node.next = queue.peek();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            else {
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }

        return root;
    }
}

package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class NaryArrayPreOrderTraversal {

    public static void main(String[] args) {

        NaryArrayPreOrderTraversal obj = new NaryArrayPreOrderTraversal();
    }

    private static class Node {
        int val;
        List<Node> children;
    }

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node root, List<Integer> result) {

        if(root == null) return;
        result.add(root.val);
        for(Node child : root.children)
            preOrder(child, result);
    }
}

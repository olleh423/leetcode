package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class CloneNAryTree {

    public static void main(String[] args) {

        CloneNAryTree obj = new CloneNAryTree();
    }

    private static class Node {
        int val;
        List<Node> children;
        Node(int val) { this.val = val; }
    }

    public Node cloneTree(Node root) {

        if(root == null) return null;

        Node copy = new Node(root.val);
        if(root.children != null) {
            List<Node> children = new ArrayList<>();
            for(int i=0 ; i<root.children.size() ; i++) {
                children.add(cloneTree(root.children.get(i)));
            }
            copy.children = children;
        }
        return copy;
    }
}

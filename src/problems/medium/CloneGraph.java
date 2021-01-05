package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 05-01-2021
 */
public class CloneGraph {

    public static void main(String[] args) {

        CloneGraph obj = new CloneGraph();
    }

    private static class Node {
        int val;
        List<Node> neighbors;
        Node(int val) {
            this.val = val;
        }
    }

    public Node cloneGraph(Node node) {

        if(node == null)
            return null;

        Map<Node, Node> copies = new HashMap<>();
        generateCopies(node, copies);

        for(Node n : copies.keySet()) {
            Node copyNode = copies.get(n);
            for(int i=0 ; i<n.neighbors.size() ; i++) {
                copyNode.neighbors.add(copies.get(n.neighbors.get(i)));
            }
        }
        return copies.get(node);
    }

    private void generateCopies(Node node, Map<Node, Node> copies) {

        if(node == null || copies.containsKey(node))
            return;

        Node copy = new Node(node.val);
        copies.put(node, copy);

        for(int i=0 ; i<node.neighbors.size() ; i++) {
            generateCopies(node.neighbors.get(i), copies);
        }
    }
}

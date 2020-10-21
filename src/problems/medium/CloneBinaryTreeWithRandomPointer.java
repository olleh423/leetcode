package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class CloneBinaryTreeWithRandomPointer {

    public static void main(String[] args) {

        CloneBinaryTreeWithRandomPointer obj = new CloneBinaryTreeWithRandomPointer();
    }

    private static class Node {
        int val;
        Node left, right, random;
    }

    private static class NodeCopy {
        int val;
        NodeCopy left, right, random;
        NodeCopy(int val) { this.val = val; }
    }

    public NodeCopy copyRandomBinaryTree(Node root) {

        if(root == null) return null;

        Map<Node, NodeCopy> map = new HashMap<>();
        NodeCopy tree = xerox(root, map);

        for(Node key : map.keySet()) {
            map.get(key).random = map.get(key.random);
        }

        return tree;
    }

    private NodeCopy xerox(Node root, Map<Node, NodeCopy> map) {

        if(root == null) return null;

        NodeCopy copy = new NodeCopy(root.val);
        copy.left = xerox(root.left, map);
        copy.right = xerox(root.right, map);

        map.put(root, copy);
        return copy;
    }
}

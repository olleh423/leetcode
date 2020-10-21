package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class InorderSuccessorInBST2 {

    public static void main(String[] args) {

        InorderSuccessorInBST2 obj = new InorderSuccessorInBST2();
    }

    private static class Node {
        int val;
        Node left, right, parent;
    }

    public Node inorderSuccessor(Node node) {

        if(node == null)
            return null;

        if(node.right != null) {

            Node temp = node.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        Node temp = node;
        while(temp.parent != null) {
            if(temp.parent.left == temp)
                return temp.parent;
            temp = temp.parent;
        }

        return null;
    }
}

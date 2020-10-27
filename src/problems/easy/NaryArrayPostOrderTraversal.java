package problems.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class NaryArrayPostOrderTraversal {

    public static void main(String[] args) {

        NaryArrayPostOrderTraversal obj = new NaryArrayPostOrderTraversal();
    }

    private static class Node {
        int val;
        List<Node> children;
    }

    public List<Integer> postorder(Node root) {

        return postOrder(root, new ArrayList<>());
    }

    public List<Integer> postOrder(Node root, List<Integer> data) {

        if(root == null)
            return data;

        for(int i=0 ; i<root.children.size() ; i++) {
            postOrder(root.children.get(i), data);
        }

        data.add(root.val);
        return data;
    }
}

package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MaximumDepthOfNaryTree {

    public static void main(String[] args) {

        MaximumDepthOfNaryTree obj = new MaximumDepthOfNaryTree();
    }

    private static class Node {
        int val;
        List<Node> children;
    }

    public int maxDepth(Node root) {

        if(root == null)
            return 0;

        if(root.children.size() == 0)
            return 1;

        int max = 0 ;
        for(Node child : root.children) {
            int h = 1 + maxDepth(child);
            max = max < h ? h : max;
        }

        return max;
    }
}

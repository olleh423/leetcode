package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {

        LeafSimilarTrees obj = new LeafSimilarTrees();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        List<TreeNode> one = new ArrayList<>();
        List<TreeNode> two = new ArrayList<>();

        extractLeaves(root1, one);
        extractLeaves(root2, two);

        if(one.size() != two.size())
            return false;

        for(int i=0 ; i<one.size() ; i++) {
            if(one.get(i).val != two.get(i).val)
                return false;
        }
        return true;
    }

    private void extractLeaves(TreeNode root, List<TreeNode> leaves) {

        if(root == null)
            return;

        if(root.left == null && root.right == null) {
            leaves.add(root);
            return;
        }

        extractLeaves(root.left, leaves);
        extractLeaves(root.right, leaves);
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class BoundryOfBinaryTree {

    public static void main(String[] args) {

        BoundryOfBinaryTree obj = new BoundryOfBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        LinkedHashSet<TreeNode> set = new LinkedHashSet<>();
        set.add(root);

        DFSLeft(root.left, set);
        DFSLeaves(root.left, set);
        DFSLeaves(root.right, set);
        DFSRight(root.right, set);

        for(TreeNode t : set)
            res.add(t.val);

        return res;
    }

    public void DFSLeft(TreeNode root, LinkedHashSet set) {

        if(root == null) return;

        set.add(root);

        if(root.left != null) DFSLeft(root.left, set);
        else DFSLeft(root.right, set);
    }

    public void DFSLeaves(TreeNode root, LinkedHashSet set) {

        if(root == null) return;

        if(root.left == null && root.right == null)
            set.add(root);

        DFSLeaves(root.left, set);
        DFSLeaves(root.right, set);
    }

    public void DFSRight(TreeNode root, LinkedHashSet set) {

        if(root == null) return;
        if(root.left == null && root.right == null) return;

        if(root.right != null) DFSRight(root.right, set);
        else DFSRight(root.left, set);

        set.add(root);
    }
}

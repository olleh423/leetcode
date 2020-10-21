package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class DeleteNodeAndReturnForest {

    public static void main(String[] args) {

        DeleteNodeAndReturnForest obj = new DeleteNodeAndReturnForest();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> forest = new ArrayList<>();
        if(root == null || to_delete == null)
            return forest;

        Set<Integer> toDelete = new HashSet<>();
        for(int v : to_delete) toDelete.add(v);

        TreeNode rootNode = dfs(root, toDelete, forest);
        if(rootNode != null) forest.add(root);

        return forest;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> toDelete, List<TreeNode> forest) {

        if(root == null) return null;

        root.left = dfs(root.left, toDelete, forest);
        root.right = dfs(root.right, toDelete, forest);

        if(toDelete.contains(root.val)) {
            if(root.left != null)
                forest.add(root.left);
            if(root.right != null)
                forest.add(root.right);
            return null;
        }
        return root;
    }
}

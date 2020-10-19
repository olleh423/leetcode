package problems.medium;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class InorderSuccessorOfBST {

    public static void main(String[] args) {

        InorderSuccessorOfBST obj = new InorderSuccessorOfBST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(root == null || p == null)
            return null;

        if(p.right != null)
            return getLeftMostNode(p.right);

        return nextElement(root, p, null);
    }

    private TreeNode nextElement(TreeNode root, TreeNode p, TreeNode succ) {

        if(root == null || root == p)
            return succ;

        if(root.val > p.val)
            return nextElement(root.left, p, root);

        return nextElement(root.right, p, succ);
    }

    private TreeNode getLeftMostNode(TreeNode root) {

        if(root == null || root.left == null)
            return root;

        return getLeftMostNode(root.left);
    }
}

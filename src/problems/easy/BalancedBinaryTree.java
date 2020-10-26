package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {

        BalancedBinaryTree obj = new BalancedBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;

        int L = height(root.left);
        int R = height(root.right);

        if(L-R < -1 || L-R > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}

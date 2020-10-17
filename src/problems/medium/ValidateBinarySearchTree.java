package problems.medium;

/*
 * Author : Vijay Sharma
 */

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        // Driver code
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isValidBST(TreeNode root) {

        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer low, Integer high) {

        if(root == null)
            return true;

        if(low != null && root.val <= low) return false;
        if(high != null && root.val >= high) return false;

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}

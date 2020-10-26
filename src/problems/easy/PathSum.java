package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class PathSum {

    public static void main(String[] args) {

        PathSum obj = new PathSum();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;

        if(root.left == null && root.right == null && sum == root.val)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

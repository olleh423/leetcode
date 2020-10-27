package problems.easy;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int diameter(TreeNode root, int[] result) {

        if(root == null) return 0;

        int L = diameter(root.left, result);
        int R = diameter(root.right, result);
        result[0] = Math.max(result[0], 1 + L + R);
        return Math.max(L, R) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {

        int[] result = {1};
        diameter(root, result);
        return result[0] - 1;
    }
}

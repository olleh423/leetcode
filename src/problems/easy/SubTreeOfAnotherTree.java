package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class SubTreeOfAnotherTree {

    public static void main(String[] args) {

        SubTreeOfAnotherTree obj = new SubTreeOfAnotherTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s == null)
            return false;

        if(s.val == t.val && isIdentical(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isIdentical(TreeNode one, TreeNode two) {

        if(one == null && two == null)
            return true;
        if(one == null || two == null)
            return false;

        if(one.val != two.val)
            return false;

        return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
    }
}

package problems.medium;
import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {

        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0 ; i<size ; i++) {

                TreeNode node = queue.remove();

                if(i == size - 1)
                    result.add(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }

        return result;
    }
}

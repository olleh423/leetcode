package problems.hard;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public String serialize(TreeNode root) {

        if(root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if(node != null) {
                sb.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else {
                sb.append(" ,");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null || data.isEmpty())
            return null;

        String[] arr = data.split(",");
        int i=1;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        queue.add(root);

        while(!queue.isEmpty() && i < arr.length) {

            TreeNode node = queue.poll();
            if(node != null) {

                node.left = " ".equals(arr[i]) ? null : new TreeNode(Integer.valueOf(arr[i]));
                i++;
                node.right = " ".equals(arr[i]) ? null : new TreeNode(Integer.valueOf(arr[i]));
                i++;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }
}

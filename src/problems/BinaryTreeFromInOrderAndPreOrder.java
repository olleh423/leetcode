package problems;

public class BinaryTreeFromInOrderAndPreOrder {

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Driver code
    }

    public TreeNode createBST(int[] inOrder, int[] preOrder) {

        int[] preIndex = {0};
        return createBinaryTree(inOrder, preOrder, 0, inOrder.length - 1, preIndex);
    }

    private TreeNode createBinaryTree(int[] IN, int[] PRE, int left, int right, int[] preIndex) {

        if(left > right) return null;

        TreeNode root = new TreeNode(PRE[preIndex[0]]);
        preIndex[0]++;

        if(left == right) return root;

        int rootIndex = indexOf(IN, left, right, root.val);
        root.left = createBinaryTree(IN, PRE, left, rootIndex - 1, preIndex);
        root.right = createBinaryTree(IN, PRE, rootIndex + 1, right, preIndex);
        return root;
    }

    private int indexOf(int[] IN, int left, int right, int target) {
        int index = 0;
        for(int i=left ; i<=right ; i++) {
            if(IN[i] == target) {
                index = i; break;
            }
        }
        return index;
    }
}

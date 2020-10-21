package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class KthSmallestElementInBST {

    public static void main(String[] args) {

        KthSmallestElementInBST obj = new KthSmallestElementInBST();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int kthSmallest(TreeNode root, int k) {

        int[] kth = {0, -1};
        kthSmallest(root, k, kth);
        return kth[1];
    }

    private void kthSmallest(TreeNode root, int k, int[] kth) {

        if(root == null) return;

        kthSmallest(root.left, k, kth);
        kth[0]++;
        if(kth[0] == k) {
            kth[1] = root.val; return;
        }
        kthSmallest(root.right, k, kth);
    }
}

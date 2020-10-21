package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class AllNodesDistanceKBinaryTree {

    public static void main(String[] args) {

        AllNodesDistanceKBinaryTree obj = new AllNodesDistanceKBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();

        if(root == null || target == null)
            return result;

        atDistanceK(root, target, k, result);
        return result;
    }

    private int atDistanceK(TreeNode root, TreeNode target, int k, List<Integer> result) {

        if(root == null)
            return -1;

        if(root == target) {
            atDistanceKDown(root, k, result);
            return 0;
        }

        int l = atDistanceK(root.left, target, k, result);
        if(l != -1) {
            if(l+1 == k) {
                result.add(root.val);
            } else {
                atDistanceKDown(root.right, k-l-2, result);
            }
            return l+1;
        }
        else {
            int r = atDistanceK(root.right, target, k, result);
            if(r != -1) {
                if(r+1 == k) {
                    result.add(root.val);
                }
                else {
                    atDistanceKDown(root.left, k-r-2, result);
                }
                return r+1;
            }
        }

        return -1;
    }

    private void atDistanceKDown(TreeNode root, int k, List<Integer> result) {

        if(root == null)
            return;

        if(k == 0) {
            result.add(root.val);
            return;
        }

        atDistanceKDown(root.left, k-1, result);
        atDistanceKDown(root.right, k-1, result);
    }
}

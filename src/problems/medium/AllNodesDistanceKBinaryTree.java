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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> result = new ArrayList<>();
        solve(root, target, K, result);
        return result;
    }

    public int solve(TreeNode root, TreeNode target, int K, List<Integer> result) {

        if(root == null) return -1;
        if(root == target) {
            kNodesDown(root, K, result);
            return 1;
        }

        int left = solve(root.left, target, K, result);
        if(left != -1) {
            if(left == K) {
                result.add(root.val);
                return left + 1;
            } else if(left > K) {
                return left;
            }
            kNodesDown(root.right, K-left-1, result);
            return left + 1;
        }

        int right = solve(root.right, target, K, result);
        if(right != -1) {
            if(right == K) {
                result.add(root.val);
                return right + 1;
            } else if(right > K) {
                return right;
            }
            kNodesDown(root.left, K-right-1, result);
            return right + 1;
        }
        return -1;
    }

    private void kNodesDown(TreeNode root, int K, List<Integer> result) {

        if(root == null) return;
        if(K == 0) {
            result.add(root.val);
            return;
        }
        kNodesDown(root.left, K-1, result);
        kNodesDown(root.right, K-1, result);
    }
}

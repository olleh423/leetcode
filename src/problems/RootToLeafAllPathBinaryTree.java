package problems;

import java.util.ArrayList;
import java.util.List;

/*
 * Leetcode 113 : Path Sum 2
 */

public class RootToLeafAllPathBinaryTree {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null || sum == 0)
            return result;
        
        getPaths(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void getPaths(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
        
        if(root == null)
        	return;
        
        path.add(root.val);
        if(target - root.val == 0 && root.left == null && root.right == null) {
        	result.add(path);
        	return;
        }
        
        getPaths(root.left, target - root.val, new ArrayList<Integer>(path), result);
        getPaths(root.right, target - root.val, new ArrayList<Integer>(path), result);
    }
	
	private static TreeNode buildTree() {
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = buildTree();
		int target = 22;
		
		System.out.println(pathSum(root, target));
	}
}

package problems;

import java.util.HashMap;

public class AllSumPathsInBinaryTree {

	private static class Node {
		
		int value;
		Node left, right;
		Node(int value) {
			this.value = value;
		}
	}
	
	/*
	 * Efficient approach takes O(n) time
	 */
	public int getTotalPathOptimized(Node root, int target) {
		
		return getTotalPathOptimized(root, target, 0, new HashMap<Integer, Integer>());
	}
	
	private int getTotalPathOptimized(Node root, int target, int runningSum, HashMap<Integer, Integer> pathCount) {
		
		if(root == null) 
			return 0;
		
		runningSum += root.value;
		int sum = runningSum - target;
		
		int totalPath = pathCount.getOrDefault(sum, 0);
		
		if(runningSum == target)
			totalPath++;
		
		incrementPaths(runningSum, 1, pathCount);
		totalPath += getTotalPathOptimized(root.left, target, runningSum, pathCount);
		totalPath += getTotalPathOptimized(root.right, target, runningSum, pathCount);
		incrementPaths(runningSum, -1, pathCount);
		
		return totalPath;
	}
	
	private void incrementPaths(int key, int value, HashMap<Integer, Integer> pathCount) {
		
		int valueToSave = pathCount.getOrDefault(key, 0) + value;
		
		if(valueToSave == 0)
			pathCount.remove(key);
		else
			pathCount.put(key, valueToSave);
	}
	
	/*
	 * Brute force approach takes O(n^2) in worst case
	 */
	public int getTotalPath(Node root, int target) {
		
		if(root == null)
			return 0;
		
		int total = getPathFromRoot(root, target, 0);
		
		total += getTotalPath(root.left, target);
		total += getTotalPath(root.right, target);
		
		return total;
	}
	
	private int getPathFromRoot(Node root, int target, int runningSum) {
		
		if(root == null)
			return 0;
		
		runningSum += root.value;
		
		int totalPath = 0;
		if(runningSum == target)
			totalPath++;
		
		totalPath += getPathFromRoot(root.left, target, runningSum);
		totalPath += getPathFromRoot(root.right, target, runningSum);
		
		return totalPath;
	}
	
	private Node buildTree() {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(3);
		root.right.left = new Node(2);
		root.right.right = new Node(5);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(1);
		root.left.right.left = new Node(2);
		root.left.right.right = new Node(1);
		root.right.right.left = new Node(7);
		root.right.right.right = new Node(8);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		AllSumPathsInBinaryTree obj = new AllSumPathsInBinaryTree();
		
		Node root = obj.buildTree();
		int target = 6;
		
		System.out.println(obj.getTotalPath(root, target));
		System.out.println(obj.getTotalPathOptimized(root, target));
	}
}

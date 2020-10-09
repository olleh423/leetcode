package problems;

import java.util.Stack;

public class BinaryTreeInterativeTraversal {

	private static class Node {
		int val;
		Node left, right;
		Node(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Iterative InOrder Traversal
	 */
	private static void traverse(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		push(root, stack);
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			System.out.print(n.val + "  ");
			push(n.right, stack);
		}
	}
	
	private static void push(Node root, Stack<Node> stack) {
		
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}

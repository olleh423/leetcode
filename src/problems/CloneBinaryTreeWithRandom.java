package problems;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeWithRandom {

	private static class Node {
		
		int value;
		Node left, right, random;
		
		Node(int value) {
			this.value = value;
		}
		
		@Override
		public int hashCode() {
			return new Integer(this.value).hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(!(obj instanceof Node)) return false;
			
			return this.hashCode() == obj.hashCode();
		}
		
		@Override
		public String toString() {
			return this.value + "";
		}
	}
	
	private Node cloneChildren(Node root, Map<Node, Node> oldToNew) {
		
		if(root == null)
			return null;
		
		Node clone = new Node(root.value);
		
		oldToNew.put(root, clone);
		
		clone.left = cloneChildren(root.left, oldToNew);
		clone.right = cloneChildren(root.right, oldToNew);
		
		return clone;
	}
	
	private void connectRandom(Node root, Node clone, Map<Node, Node> oldToNew) {
		
		if(root == null)
			return;
		
		clone.random = root.random == null ? null : oldToNew.get(root.random);
		
		connectRandom(root.left, clone.left, oldToNew);
		connectRandom(root.right, clone.right, oldToNew);
	}
	
	/*
	 * cloning tree with O(n) space using hashmap
	 */
	public Node clone(Node root) {
		
		Map<Node, Node> oldToNew = new HashMap<>();
		
		Node cloned = cloneChildren(root, oldToNew);
		
		connectRandom(root, cloned, oldToNew);
		
		return cloned;
	}
	
	
	
	
	
	
	/*
	 * Utility methods
	 */
	private void preOrder(Node root) {
		
		if(root == null)
			return;

		System.out.print(root + " - ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	private void inOrder(Node root) {
		
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root + " - ");
		inOrder(root.right);
	}
	
	private void printRandom(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root + " -> " + (root.random == null ? "null" : root.random) + " | ");
		printRandom(root.left);
		printRandom(root.right);
	}
	
	private void traverse(Node root) {
		
		System.out.println("InOrder : ");
		inOrder(root);
		System.out.println("\n\nPreOrder : ");
		preOrder(root);
		System.out.println("\n\nRandom : ");
		printRandom(root);
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		
		root.random = root.right.left.right;
		root.left.random = root.right;
		root.right.random = null;
		root.left.left.random = root.right;
		root.left.right.random = root.right.left;
		root.right.left.random = root.right.right;
		root.right.right.random = root.right.left.right;
		root.right.left.left.random = root.left.left;
		root.right.left.right.random = null;
		
		CloneBinaryTreeWithRandom obj = new CloneBinaryTreeWithRandom();
		
		System.out.println("Actual Tree : \n");
		obj.traverse(root);
		
		Node clone = obj.clone(root);
		
		System.out.println("\n\n\n");
		System.out.println("Cloned Tree : \n");
		obj.traverse(clone);
	}
}

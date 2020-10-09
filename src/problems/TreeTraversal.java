package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	private static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	public static int getHeight(Node root) {
		if(root == null) 
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static int countNumberOfNodes(Node root) {
		
		if(root == null) 
			return 0;
		return 1 + countNumberOfNodes(root.left) + countNumberOfNodes(root.right);
	}
	
	public static void inOrder(Node root) {
		
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}
	
	public static void preOrder(Node root) {
		
		if(root == null) return;
		
		System.out.print(root.data + "  ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		
		if(root == null) return;
		
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.data + "  ");
	}
	
	public static void levelOrderTopDown(Node root) {
		
		if(root == null) return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(! queue.isEmpty()) {
			
			Node node = queue.remove();
			System.out.print(node.data + "  ");
			
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}
	}
	
	
	public static void levelOrder(Node root, boolean order, int height) {
		
		if(root == null)
			return ;
		if(height == 1) 
			System.out.print("  " + root.data);
		
		if(order) {
			levelOrder(root.right, order, height-1);
			levelOrder(root.left, order, height-1);
		} else {
			levelOrder(root.left, order, height-1);
			levelOrder(root.right, order, height-1);
		}
	}
	public static void levelOrderSpiralWithConstantSpace(Node root) {
		
		int height = getHeight(root);
		boolean order = false;
		for(int i=1 ; i<=height ; i++) {
			levelOrder(root, order, i);
			order = !order;
		}
	}
	
	public static void levelOrderTopDownSpiral(Node root) {
		
		if(root == null) return;
		
		Stack<Node> stOne = new Stack<>();
		Stack<Node> stTwo = new Stack<>();
		stOne.push(root);
		
		while(!stOne.isEmpty() || !stTwo.isEmpty()) {
			
			while(!stOne.isEmpty()) {
				Node node = stOne.pop();
				System.out.print(node.data + "  ");
				if(node.left != null) stTwo.push(node.left);
				if(node.right != null) stTwo.push(node.right);
			}

			while(!stTwo.isEmpty()) {
				Node node = stTwo.pop();
				System.out.print(node.data + "  ");
				if(node.right != null) stOne.push(node.right);
				if(node.left != null) stOne.push(node.left);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		
		System.out.print("Number of Nodes : " + countNumberOfNodes(root)); 
		System.out.println("\n");
		
		System.out.print("Preorder : "); 
		preOrder(root);
		System.out.println("\n");

		System.out.print("Postorder : "); 
		postOrder(root);
		System.out.println("\n");
		
		System.out.print("Inorder : "); 
		inOrder(root);
		System.out.println("\n");
		
		System.out.print("Level Order Top Down : "); 
		levelOrderTopDown(root);
		System.out.println("\n");
		
		System.out.print("Level Order Top Down Spiral : "); 
		levelOrderTopDownSpiral(root);
		System.out.println("\n");
		
		System.out.print("Level Order Top Down Spiral in O(1) space : "); 
		levelOrderSpiralWithConstantSpace(root);
		System.out.println("\n");
	}
}

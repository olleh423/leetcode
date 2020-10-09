package problems;

public class BoundaryTraversalBinaryTree {

	private static class Node {
		int value;
		Node left;
		Node right;
		Node(int value) {
			this.value = value;
		}
	}
	
	private void leftBoundary(Node root) {
		
		if(root == null)
			return;
		
		if(root.left != null) {
			
			System.out.print(root.value + " ");
			leftBoundary(root.left);
			
		} else if(root.right != null) {
			
			System.out.print(root.value + " ");
			leftBoundary(root.right);
		}
	}
	
	private void leaves(Node root) {
		
		if(root == null)
			return;
		
		leaves(root.left);
		
		if(root.left == null && root.right == null)
			System.out.print(root.value + " ");
		
		leaves(root.right);
	}
	
	private void rightBoundary(Node root) {
		
		if(root == null)
			return;
		
		if(root.right != null) {
			
			rightBoundary(root.right);
			System.out.print(root.value + " ");
			
		} else if(root.left != null) {
			
			rightBoundary(root.left);
			System.out.print(root.value + " ");
		}
	}

	public void printBoundary(Node root) {
		
		if(root != null) {
			
			System.out.print(root.value + " ");
			
			leftBoundary(root.left);
			
			leaves(root.left);
			leaves(root.right);
			
			rightBoundary(root.right);
		}
	}
	
	private Node getTree() {
		
		Node root = new Node(20);
		
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		BoundaryTraversalBinaryTree obj = new BoundaryTraversalBinaryTree();
		
		obj.printBoundary(obj.getTree());
	}
}

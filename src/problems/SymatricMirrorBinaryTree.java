package problems;

public class SymatricMirrorBinaryTree {

	class Node {
		Node(int data) { this.data = data; }
		int data;
		Node left;
		Node right;
	}
	
	boolean isSymatric(Node root) {
		
		if(root == null) return true;
		
		return isSymatric(root.left, root.right);
	}
	
	boolean isSymatric(Node left, Node right) {
		
		if(left == null && right == null) return true;
		
		if((left != null && right == null) || (left == null && right != null) || (left.data != right.data)) return false;
		
		return isSymatric(left.left, right.right) && isSymatric(left.right, right.left);
	}
	
	int countLeaf(Node root) {
		
		if(root == null) return 0;
		
		if(root.left == null && root.right == null) return 1;
		
		return countLeaf(root.left) + countLeaf(root.right);
	}
	
	Node getRoot() {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(3);
		root.left.right.right = new Node(4);
		root.right.left.left = new Node(4);
		root.right.left.right = new Node(3);
		root.right.right.left = new Node(2);
		root.right.right.right = new Node(1);
		
		return root;
	}
	
	public static void main(String... args) {
		
		SymatricMirrorBinaryTree sym = new SymatricMirrorBinaryTree();
		
		System.out.println(sym.isSymatric(sym.getRoot()));
		
		System.out.println(sym.countLeaf(sym.getRoot()));
	}
}

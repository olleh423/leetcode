package problems;

/*
		Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
		Two nodes are cousins of each other if they are at same level and have different parents.
		
		Example:
		
		     6
		   /   \
		  3     5
		 / \   / \
		7   8 1   3
		
		Say two node be 7 and 1, result is TRUE.
		Say two nodes are 3 and 5, result is FALSE.
		Say two nodes are 7 and 5, result is FALSE.
		
		Note: 'a' and 'b' will always be there in the tree.
 */

public class CousinNodesBinaryTree {

	private static class Node {
		
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	private boolean siblings(Node root, int a, int b) {
		
		if(root == null || root.left == null || root.right == null)
			return false;
		
		if((root.left.value == a && root.right.value == b) || (root.right.value == a && root.left.value == b))
			return true;
		
		return siblings(root.left, a, b) || siblings(root.right, a, b);
	}
	
	private int level(Node root, int a, int level) {
		
		if(root == null)
			return -1;
		
		if(root.value == a)
			return level;
		
		int l = level(root.left, a, level + 1);
		if(l != -1)
			return l;
		
		return level(root.right, a, level + 1);
	}
	
	public boolean cousinNodes(Node root, int a, int b) {
	
		if(root == null)
			return false;
		
		if(!siblings(root, a, b) && level(root, a, 1) == level(root, b, 1))
			return true;
		
		return false;
	}
	
	private Node getTree() {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(8);
		root.right.right = new Node(9);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(6);
		root.right.right.left = new Node(10);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		CousinNodesBinaryTree obj = new CousinNodesBinaryTree();
		
		Node root = obj.getTree();
		int a = 3;
		int b = 10;
		
		System.out.println(a + " and " + b + " are" + (obj.cousinNodes(root, a, b) ? "" : " not")  + " cousins.");
	}
}

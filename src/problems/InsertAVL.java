package problems;

public class InsertAVL {

	private static class Node {
		int key, height;
		Node left, right;
		Node(int key) {
			this.key = key;
			this.height = 1;
		}
	}
	
	private int max(int a, int b) {
		
		return a > b ? a : b;
	}
	
	private int height(Node node) {
		
		if(node == null) 
			return 0;
		return node.height;
	}
	
	private int getBalance(Node node) {
		
		if(node == null)
			return 0;
		
		return height(node.left) - height(node.right);
	}
	
	private void inOrder(Node root) {
		
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.key + "  ");
		inOrder(root.right);
	}
	
	private void preOrder(Node root) {
		
		if(root == null)
			return;

		System.out.print(root.key + "  ");
		inOrder(root.left);
		inOrder(root.right);
	}
	
	private Node rotateRight(Node x) {
		
		Node y = x.left;
		Node T2 = y.right;
		
		y.right = x;
		x.left = T2;
		
		x.height = 1 + max(height(x.left), height(x.right));
		y.height = 1 + max(height(y.left), height(y.right));
		
		return y;
	}
	
	private Node rotateLeft(Node x) {
		
		Node y = x.right;
		Node T2 = y.left;
		
		y.left = x;
		x.right = T2;
		
		x.height = 1 + max(height(x.left), height(x.right));
		y.height = 1 + max(height(y.left), height(y.right));
		
		return y;
	}
    
	public Node insert(Node root, int key) {
		
		if(root == null)
			return new Node(key);
		
		//insert key
		if(key < root.key)
			root.left = insert(root.left, key);
		else if(key > root.key)
			root.right = insert(root.right, key);
		else
			return root;
		
		//update heights of all ancestors
		root.height = 1 + max(height(root.left), height(root.right));
		
		//calculate balance factor
		int balanceFactor = getBalance(root);
		
		//Left-Left case
		if(balanceFactor > 1 && key < root.left.key)
			return rotateRight(root);
		
		//Right-Right case
		if(balanceFactor < -1 && key > root.right.key)
			return rotateLeft(root);
		
		//Left-Right case
		if(balanceFactor > 1 && key > root.left.key) {
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		
		//Right-Left case
		if(balanceFactor < 1 && key < root.right.key) {
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		
		return root;
	}
	
	public static void main(String [] args) {
		
		int[] keys = {3, 5, 9, 1, 2, 4, 8, 7, 6};
		
		InsertAVL avl = new InsertAVL();
		
		Node root = null;
		for(int i=0 ; i<keys.length ; i++) {
			root = avl.insert(root, keys[i]);
		}
		
		System.out.print("PreOrder : ");
		avl.preOrder(root);
		
		System.out.println();
		
		System.out.print("InOrder : ");
		avl.inOrder(root);
	}
}

package problems;

public class KthElementInBST {

	private static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	private static class Count {
		int value;
		Count(int value) {
			this.value = value;
		}
	}
	
	private Node smallest(Node root, int k, Count c) {
		
		if(root == null)
			return null;
		
		Node value = smallest(root.left, k, c);
		c.value += 1;
		
		if(c.value == k)
			return root;
		
		if(value != null)
			return value;
		
		return smallest(root.right, k, c);
	}
	
	private Node largest(Node root, int k, Count c) {
		
		if(root == null)
			return null;
		
		Node value = largest(root.right, k, c);
		c.value += 1;
		
		if(c.value == k)
			return root;
		
		if(value != null)
			return value;
		
		return largest(root.left, k, c);
	}
	
	public int kthSmallest(Node root, int k) {
		
		Node node = smallest(root, k, new Count(0));
		return node != null ? node.data : -1;
	}
	
	public int kthLargest(Node root, int k) {
		
		Node node = largest(root, k, new Count(0));
		return node != null ? node.data : -1;
	}
	
	public void inOrder(Node root) {
		
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	private Node getTree() {
		
		Node root = new Node(8);
		
		root.left = new Node(5);
		root.right = new Node(14);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(11);
		root.right.right = new Node(16);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		KthElementInBST obj = new KthElementInBST();
		
		Node root = obj.getTree();
		int k = 5;
		
		obj.inOrder(root);
		System.out.println();
		
		System.out.println(obj.kthSmallest(root, k));
		System.out.println(obj.kthLargest(root, k));
	}
}

package problems;

public class SaveAllLeafToDLL {

	private static class Node {
		
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	private Node head = null;
	private Node temp = null;
	
	public Node extractLeaves(Node root) {
		
		extract(root);
		return head;
	}
	
	public Node extract(Node root) {
		
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null) {
			
			if(head == null) {
				head = temp = root;
			} else {
				temp.left = root;
				root.right = temp;
				temp = root;
			}
			
			return null;
		}
		
		Node left = extract(root.left);
		if(left == null)
			root.left = null;
		
		Node right = extract(root.right);
		if(right == null)
			root.right = null;
		
		return root;
	}
	
	private Node getTree() {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);
		root.right.right = new Node(9);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		
		return root;
	}
	
	private void inOrder(Node root) {
		
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data + " - ");
		inOrder(root.right);
	}

	private void traverseDLL(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root.data + " - ");
		traverseDLL(root.left);
	}
	
	public static void main(String[] args) {
		
		SaveAllLeafToDLL obj = new SaveAllLeafToDLL();
		
		Node root = obj.getTree();
		
		System.out.println("Before Tree : ");
		obj.inOrder(root);
		
		Node head = obj.extractLeaves(root);
		
		System.out.println("\nAfter Tree : ");
		obj.inOrder(root);
		System.out.println("\nLeaves : ");
		obj.traverseDLL(head);
	}
}

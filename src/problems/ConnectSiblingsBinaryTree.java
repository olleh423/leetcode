package problems;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSiblingsBinaryTree {

	private static class Node {
		
		int data;
		Node left;
		Node right;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public void connectSiblings(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			Node n = queue.remove();
			
			if(n != null) {
				
				n.next = queue.peek();
				
				if(n.left != null)
					queue.add(n.left);
				if(n.right != null)
					queue.add(n.right);
				
			} else {
				
				if(!queue.isEmpty())
					queue.add(null);
			}
		}
		
		System.out.println("Siblings Connected..!");
	}
	
	private Node getTree() {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		ConnectSiblingsBinaryTree obj = new ConnectSiblingsBinaryTree();
		
		Node root = obj.getTree();
		
		obj.connectSiblings(root);
	}
}

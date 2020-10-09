package problems;

/*
 * Print all node in a binary tree at k distance from given node.
 */

public class NodesAtKDistanceBinaryTree {

	private static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	public void nodeDown(Node root, int k) {
		
		if(root == null || k < 0) 
			return;
		
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		
		nodeDown(root.left, k - 1);
		nodeDown(root.right, k - 1);
	}
	
	public int nodesAtKDistance(Node root, int target, int k) {
		
		if(root == null)
			return -1;
		
		if(root.data == target) {
			
			nodeDown(root, k);
			return 0;
		}
		
		int dl = nodesAtKDistance(root.left, target, k);
		if(dl != -1) {
			
			if(dl + 1 == k) {
				System.out.println(root.data);
			} else {
				nodeDown(root.right, k - dl - 2);
			}
			
			return 1 + dl;
		}
		
		int dr = nodesAtKDistance(root.right, target, k);
		if(dr != -1) {
			
			if(dr + 1 == k) {
				System.out.println(root.data);
			} else {
				nodeDown(root.left, k - dr - 2);
			}
			
			return 1 + dr;
		}
		
		return -1;
	}
	
	private Node getTree() {
		
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(14);
		root.left.right.right = new Node(10);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		NodesAtKDistanceBinaryTree obj = new NodesAtKDistanceBinaryTree();
		
		Node root = obj.getTree();
		int target = 8;
		int k = 2;
		
		obj.nodesAtKDistance(root, target, k);
	}
}

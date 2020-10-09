package problems;

public class LeftViewBinaryTree {

	private static class Node {
		
		Node(int data){ this.data = data; }
		int data;
		Node left;
		Node right;
	}
	
	private static class Track {
		int level = 0;
	}
	
	
	private void leftView(Node root, int level, Track track) {
		
		if(root == null)
			return;
		
		if(level > track.level) {
			System.out.print(root.data + " ");
			track.level = level;
		}
		
		leftView(root.left, level + 1, track);
		leftView(root.right, level + 1, track);
	}
	
	public void leftView(Node root) {
		
		leftView(root, 1, new Track());
	}
	
	private void rightView(Node root, int level, Track track) {
		
		if(root == null)
			return;
		
		if(level > track.level) {
			System.out.print(root.data + " ");
			track.level = level;
		}
		
		rightView(root.right, level + 1, track);
		rightView(root.left, level + 1, track);
	}
	
	public void rightView(Node root) {
		
		rightView(root, 1, new Track());
	}
	
	public void bottomView(Node root) {
		
		if(root == null) return ;
		
		if(root.left == null && root.right == null)
			System.out.print(root.data + " ");
		
		bottomView(root.left);
		bottomView(root.right);
	}
	
	private Node getRoot() {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		LeftViewBinaryTree leftView = new LeftViewBinaryTree();
		
		System.out.println("Left View : ");
		leftView.leftView(leftView.getRoot());
		System.out.println("\nRight View : ");
		leftView.rightView(leftView.getRoot());
		System.out.println("\nBottom View : ");
		leftView.bottomView(leftView.getRoot());
	}
}

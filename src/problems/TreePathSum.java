package problems;

public class TreePathSum {

	private static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	private static boolean hasPathWithSum(Node root, int sum) {
		
		if(root == null) return sum == 0;
		return hasPathWithSum(root.left, sum-root.data) || hasPathWithSum(root.right, sum-root.data);
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
		
		System.out.println(hasPathWithSum(root, 10));
	}
}

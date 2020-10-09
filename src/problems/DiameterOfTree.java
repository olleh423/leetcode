package problems;

/*
 * Diameter : distance between most farthest two nodes.
 */

public class DiameterOfTree {
	
	private static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	private static class Pair {
		int height;
		int diameter;
		Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
		@Override
		public String toString() {
			return "Height : " + height + ", Diameter : " + diameter;
		}
	}
	
	public static int height(Node root) {
		
		if(root == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	/*
	 * O(n*h)
	 */
	public static int diameter(Node root) {
	
		if(root == null)
			return 0;
		
		int totalDiameter = 1 + height(root.left) + height(root.right);
		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);
		
		return Math.max(Math.max(leftDiameter, rightDiameter), totalDiameter);
	}
	
	/*
	 * O(n);
	 */
	public static Pair diameterOpt(Node root) {
		
		if(root == null)
			return new Pair(0, 0);
		
		Pair left = diameterOpt(root.left);
		Pair right = diameterOpt(root.right);
		
		int height = 1 + Math.max(left.height, right.height);
		int diameter = Math.max(Math.max(left.diameter, right.diameter), 1 + left.height + right.height);
		
		return new Pair(height, diameter);
	}
	
	private static Node getTree1() {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.right.left.left = new Node(9);
		root.right.right.right = new Node(10);
		root.right.left.left.right = new Node(11);
		
		return root;
	}
	
	private static Node getTree2() {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.left.left.left.left = new Node(12);
		root.left.left.right.right = new Node(13);
		root.left.right.right.left = new Node(14);
		root.left.right.right.right = new Node(15);
		root.left.left.left.left.left = new Node(16);
		root.left.left.left.left.right = new Node(17);
		root.left.right.right.right.left = new Node(18);
		root.left.right.right.right.right = new Node(19);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		Node root = getTree2();
		System.out.println("Height : " + height(root) + ", Diameter : " + diameter(root));
		System.out.println(diameterOpt(root));
	}
}

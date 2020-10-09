package problems;

public class LowestCommonAncestor {
	
	private static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return this.data + "";
		}
	}

	/*
	 * solution 1 
	 */
	public static Node lca(Node root, Node n1, Node n2) {
		
		if(root == null) return null;
		
		if(root == n1 || root == n2) return root;
		
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		
		if(left != null && right != null) return root;
		if(left == null && right == null) return null;
		
		return left != null ? left : right;
	}
	
	/*
	 * solution 2
	 */
	public static Node lowestCommon(Node root, Node one, Node two) {
	
		if(root == null || !hasNode(root, one) || !hasNode(root, two))
			return null;
		
		boolean oneOnLeft = hasNode(root.left, one);
		boolean twoOnLeft = hasNode(root.left, two);
		
		if(oneOnLeft != twoOnLeft)
			return root;
		
		return lowestCommon(oneOnLeft ? root.left : root.right, one, two);
	}
	
	private static boolean hasNode(Node root, Node n) {
		
		if(root == null)
			return false;
		
		if(root == n)
			return true;
		
		return hasNode(root.left, n) || hasNode(root.right, n);
	}
	
	public static void main(String[] args) {
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		
		one.left = two;
		one.right = six;
		two.left = four;
		two.right = three;
		three.left = five;
		three.right = ten;
		six.left = seven;
		six.right = eight;
		eight.left = nine;
		
		System.out.println("Lowest common ancestor is " + lca(one, two, four));
		System.out.println("Lowest common ancestor is " + lowestCommon(one, two, four));
	}
}

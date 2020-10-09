package problems;

public class IsSubtree {
	
	private static class Node {
		int value;
		Node left, right;
		Node(int value) {
			this.value = value;
		}
	}
	
	/*
	 * Using KMP find inorder and postorder string of t2 as a substring of inorder and postorder string of t1.
	 * Runtime O(n)
	 * Space O(n)
	 */
	public boolean isSubTree(Node t1, Node t2) {
		
		String inOrderT1 = getInOrderString(t1, "");
		String inOrderT2 = getInOrderString(t2, "");
		
		String postOrderT1 = getPostOrderString(t1, "");
		String postOrderT2 = getPostOrderString(t2, "");
		
		return hasSubString(inOrderT1, inOrderT2) && hasSubString(postOrderT1, postOrderT2);
	}
	
	private String getInOrderString(Node root, String value) {
		
		if(root == null)
			return value;
		
		value = getInOrderString(root.left, value);
		value += root.value;
		value = getInOrderString(root.right, value);
		
		return value;
	}
	
	private String getPostOrderString(Node root, String value) {
		
		if(root == null)
			return value;
		
		value = getPostOrderString(root.left, value);
		value = getPostOrderString(root.right, value);
		value += root.value;
		
		return value;
	}
	
	/*
	 * finding substring using KMP algorithm
	 */
	private boolean hasSubString(String text, String pattern) {
		
		int[] PI = getPITable(pattern);

		int i=0, j=0;
		while(i < text.length()) {
			
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == PI.length-1) {
					return true;
				} else {
					j++;
				}
				i++;
			} else {
				if(j != 0) {
					j = PI[j-1];
				} else {
					i++;
				}
			}
		}
		
		return false;
	}
	
	private static int[] getPITable(String pattern) {
		
		int[] PI = new int[pattern.length()];
		PI[0] = 0;
		
		int i=1, j=0;
		while(i < pattern.length()) {
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				PI[i] = ++j;
				i++;
			} else {
				if(j != 0) {
					j = PI[j-1];
				} else {
					PI[i] = 0;
					i++;
				}
			}
		}
		
		return PI;
	}
	
	/*
	 * Utility methods to generate trees
	 */
	private Node getBigTree() {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.left.right.right.right = new Node(12);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		root.right.right.right = new Node(7);
		root.right.left.right.right = new Node(14);
		
		return root;
	}
	
	private Node getSmallTree() {
		
		Node root = new Node(5);
		
		root.left = new Node(10);
		root.right = new Node(11);
		root.right.right = new Node(12);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		IsSubtree obj = new IsSubtree();
		
		Node bigTree = obj.getBigTree();
		Node smallTree = obj.getSmallTree();
		
		System.out.println(obj.isSubTree(bigTree, smallTree));
	}
}

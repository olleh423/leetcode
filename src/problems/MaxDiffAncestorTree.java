package problems;

/*
	Given a binary tree, we need to find maximum value we can get by subtracting value of node B from value of node A, 
	where A and B are two nodes of the binary tree and A is an ancestor of B. Expected time complexity is O(n).
	
	For example, consider below binary tree
	
					8
			3				10
		1		6				14
			  4   7			  13
	
	We can have various ancestor-node difference, some of which are given below :
	8 – 3 = 5
	3 – 7 = -4
	8 – 1 = 7
	10 – 13 = -3
*/
public class MaxDiffAncestorTree {

	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	static class Res {
		int value = Integer.MIN_VALUE;
	}
	
	public static int getMaxDiff(Node root, Res res) {
		
		if(root == null)
			return Integer.MAX_VALUE;
		if(root.left == null && root.right == null) 
			return root.data;
		
		int value = Math.min(getMaxDiff(root.left, res), getMaxDiff(root.right, res));
		res.value = Math.max(res.value, root.data - value);
		return Math.min(value, root.data);
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		
		Res res = new Res();
		getMaxDiff(root, res);
		System.out.println(res.value);
	}
}

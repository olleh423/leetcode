package problems;

public class KthElementBSTOrderStatistics {

	private static class Node {
		int value;
		int leftCount;
		Node left, right;
		Node(int value, int leftCount) {
			this.value = value;
			this.leftCount = leftCount;
		}
	}
	
	/*
	 * insert element in binary search tree and maintain rank of each node which holds
	 * the total number of elements on the left part of the root
	 */
	private Node insert(Node root, int value) {
		
		if(root == null)
			return new Node(value, 0);
		
		if(value < root.value) {
			root.left = insert(root.left, value);
			root.leftCount += 1;
		}
		else {
			root.right = insert(root.right, value);
		}
		
		return root;
	}
	
	/*
	 * search kth element using the rank maintained at the time of insertion in bst
	 */
	private int kthElement(Node root, int k) {
		
		if(root == null)
			return -1;
		
		if(root.leftCount + 1 == k) 
			return root.value;
		
		if(root.leftCount + 1 > k)
			return kthElement(root.left, k);
		else
			return kthElement(root.right, k - (root.leftCount + 1));
	}
	
	public static void main(String[] args) {
		
		KthElementBSTOrderStatistics obj = new KthElementBSTOrderStatistics();
		
		Node root = null;
		root = obj.insert(root, 4);
		root = obj.insert(root, 2);
		root = obj.insert(root, 6);
		root = obj.insert(root, 1);
		root = obj.insert(root, 3);
		root = obj.insert(root, 5);
		root = obj.insert(root, 7);
		
		System.out.println(obj.kthElement(root, 1));
		System.out.println(obj.kthElement(root, 2));
		System.out.println(obj.kthElement(root, 3));
		System.out.println(obj.kthElement(root, 4));
		System.out.println(obj.kthElement(root, 5));
		System.out.println(obj.kthElement(root, 6));
		System.out.println(obj.kthElement(root, 7));
		System.out.println(obj.kthElement(root, 8));
	}
}

package problems;

public class BinaryTreeFromInOrderAndPostOrder {

	public static void main(String[] args) {

		int[] inorder = new int[] { 9, 3, 15, 20, 7 }; // {1,2,3,4};
		int[] postorder = new int[] { 9, 15, 7, 20, 3 }; // {3,2,4,1};
		
		Index pIndex = new Index(postorder.length - 1);
		Node treeRoot = buildTree(inorder, postorder, 0, inorder.length - 1, pIndex);
		
		inOrder(treeRoot);
		System.out.println();
		postOrder(treeRoot);
	}
	
	public static Node buildTree(int[] IN, int[] POST, int left, int right, Index pIndex) {
		
		if(left > right)
			return null;
		
		Node root = new Node(POST[pIndex.index]);
		(pIndex.index)--;
		
		if(left == right)
			return root;
		
		int rootIndex = indexOf(IN, left, right, root.val);
		
		root.right = buildTree(IN, POST, rootIndex + 1, right, pIndex);
		root.left = buildTree(IN, POST, left, rootIndex - 1, pIndex);
		
		return root;
	}
	
	private static int indexOf(int[] arr, int left, int right, int target) {
		
		while(left <= right) {
			if(arr[left] == target)
				return left;
			left++;
		}
		return -1;
	}
	
	/*
	 * Tree node
	 */
	private static class Node {
		int val;
		Node left, right;
		Node(int val) {
			this.val = val;
		}
	}
	
	/*
	 * Holds preorder root index
	 */
	private static class Index {
		int index;
		Index(int index) {
			this.index = index;
		}
	}
	
	/*
	 * Utility methods
	 */
	private static void postOrder(Node root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + ", ");
	}
	
	private static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + ", ");
		inOrder(root.right);
	}
}

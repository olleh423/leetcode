package problems;

public class SortedArrayToBalancedBST {
	
	private static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	public Node solve(int[] arr, int left, int right) {
		
		if(left == right)
			return new Node(arr[left]);
		
		if(left > right)
			return null;
		
		int mid = (left + right) / 2;
		
		Node root = new Node(arr[mid]);
		
		root.left = solve(arr, left, mid-1);
		root.right = solve(arr, mid+1, right);
		
		return root;
	}
	
	private void preOrder(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root.data + " -> ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	private void inOrder(Node root) {
		
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data + " -> ");
		inOrder(root.right);
	}
	
	private void postOrder(Node root) {
		
		if(root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " -> ");
	}

	public Node getBalancedBST(int[] arr) {
		
		return solve(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		SortedArrayToBalancedBST obj = new SortedArrayToBalancedBST();
		
		Node root = obj.getBalancedBST(arr);
		
		System.out.print("Preorder : ");
		obj.preOrder(root);
		System.out.print("NULL\n\nInOrder : ");
		obj.inOrder(root);
		System.out.print("NULL\n\nPostOrder : ");
		obj.postOrder(root);
		System.out.println("NULL");
	}
}

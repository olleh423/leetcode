package problems;

public class PreOrderToBST {

	private static class Node {
		int value;
		Node left, right;
		Node(int value) {
			this.value = value;
		}
	}
	
	public Node addToBST(Node root, int value) {
		
		if(root == null)
			return new Node(value);
		
		if(value < root.value)
			root.left = addToBST(root.left, value);
		else
			root.right = addToBST(root.right, value);
		
		return root;
	}
	
	public Node generateBST(int[] preOrder) {
		
		if(preOrder == null || preOrder.length == 0)
			return null;
		
		Node root = null;
		for(int i=0 ; i<preOrder.length ; i++)
			root = addToBST(root, preOrder[i]);
		
		return root;
	}
	
	private void preOrder(Node root) {
		
		if(root == null)
			return;
		
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.value + " ");
	}
	
	public static void main(String[] args) {
		
		int[] preOrder = {4, 2, 1, 3, 8, 6, 5, 7, 9};
		
		PreOrderToBST obj = new PreOrderToBST();
		
		Node root = obj.generateBST(preOrder);
		
		obj.preOrder(root);
	}
}

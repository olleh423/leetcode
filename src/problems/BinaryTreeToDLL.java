package problems;

public class BinaryTreeToDLL {

	private static class DLLNode {
		int data;
		DLLNode next;
		DLLNode prev;
		DLLNode(int data) {
			this.data = data;
		}
	}

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data) {
			this.data = data;
		}
	}
	
	private TreeNode getTree() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.right.left.left = new TreeNode(9);
		
		return root;
	}
	
	private void convert(TreeNode root) {
		
		if(root == null)
			return ;
		
		convert(root.left);
		
		DLLNode dllNode = new DLLNode(root.data);
		if(head == null) {
			head = prev = dllNode;
		} else {
			prev.next = dllNode;
			dllNode.prev = prev;
			prev = dllNode;
		}
		
		convert(root.right);
	}
	
	private DLLNode head;
	private DLLNode prev;
	
	public DLLNode convertToDLL(TreeNode root) {
		
		convert(root);
		return head;
	}
	
	public void traverseTree(TreeNode root) {
		
		if(root == null)
			return ;
		
		traverseTree(root.left);
		System.out.print(root.data + " ");
		traverseTree(root.right);
	}
	
	public void traverseDLL(DLLNode head) {
		
		if(head == null)
			return;
		
		System.out.print(head.data + " ");
		traverseDLL(head.next);
	}
	
	public static void main(String[] args) {
		
		BinaryTreeToDLL obj = new BinaryTreeToDLL();
		
		TreeNode root = obj.getTree();
		DLLNode head = obj.convertToDLL(root);
		
		System.out.print("Tree InOrder\t: ");
		obj.traverseTree(root);
		System.out.print("\n\nDLL values\t: ");
		obj.traverseDLL(head);
	}
}

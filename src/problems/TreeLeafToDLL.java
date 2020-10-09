package problems;

public class TreeLeafToDLL {

	static class Node {
		int value;
		Node left;
		Node right;
		Node(int value) {
			this.value = value;
		}
		Node() {
			
		}
	}
	
	private static Node root, head, prev;
	
	private static Node extractLeafList(Node root) {
		
		if (root == null) 
            return null; 
        if (root.left == null && root.right == null)  
        { 
            if (head == null)  
            { 
                head = root; 
                prev = root; 
            }  
            else 
            { 
                prev.right = root; 
                root.left = prev; 
                prev = root; 
            } 
            return null; 
        }
        
        root.left = extractLeafList(root.left); 
        root.right = extractLeafList(root.right); 
        
        return root; 
	}
	
	private static void traverseLinkedList(Node head) {
		
		if(head == null)
			return;
		
		System.out.print(head.value + " ");
		traverseLinkedList(head.right);
	}
	
	private static void traverseTree(Node root) {
		
		if(root == null)
			return;
		
		traverseTree(root.left);
		System.out.print(root.value + " ");
		traverseTree(root.right);
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		
		extractLeafList(root);
		
		System.out.print("Remaing nodes in tree (inorder) : ");
		traverseTree(root);
		System.out.print("\n\nLeaf nodes as Linked List : ");
		traverseLinkedList(head);
	}
}

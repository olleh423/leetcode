package problems;

public class InOrderSuccessorBST {

	private static class Node {
		
		int value;
		Node left, right, parent;
		
		Node(int value) {
			this.value = value;
		}
	}

	private int getMinimum(Node node) {
		
		if(node.left == null)
			return node.value;
		
		return getMinimum(node.left);
	}
	
	public int nextInorderSuccessor(Node node) {
		
		if(node == null)
			return -1;
		
		if(node.right != null)
			return getMinimum(node.right);
		
		Node parent = node.parent;
		
		while(parent != null && node.value == parent.right.value) {
			node = parent;
			parent = node.parent;
		}
		
		return parent == null ? -1 : parent.value;
	}

	public static void main(String[] args) {
		
		Node ten = new Node(10);
		Node six = new Node(6);
		Node five = new Node(5);
		Node four = new Node(4);
		Node two = new Node(2);
		Node eight = new Node(8);
		Node seven = new Node(7);
		Node nine = new Node(9);
		Node elevan = new Node(11);
		Node thirteen = new Node(13);
		Node sixteen = new Node(16);
		Node eighteen = new Node(18);
		
		//setup left right
		ten.left = six;
		ten.right = sixteen;
		six.left = five;
		six.right = eight;
		five.left = four;
		four.left = two;
		six.right = eight;
		eight.left = seven;
		eight.right = nine;
		sixteen.left = elevan;
		sixteen.right = eighteen;
		elevan.right = thirteen;
		
		//setup parent
		two.parent = four;
		four.parent = five;
		five.parent = six;
		six.parent = ten;
		seven.parent = eight;
		nine.parent = eight;
		eight.parent = six;
		thirteen.parent = elevan;
		elevan.parent = sixteen;
		sixteen.parent = ten;
		eighteen.parent = sixteen;

		InOrderSuccessorBST obj = new InOrderSuccessorBST();
		
		System.out.println(obj.nextInorderSuccessor(ten));
	}
}

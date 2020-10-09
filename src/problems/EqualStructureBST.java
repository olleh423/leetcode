package problems;

public class EqualStructureBST {

	static class Node {
		int val;
		Node left, right;
		Node(int val) {
			this.val = val;
		}
	}
	
	public static int countUtils(Node A, Node B, int min,int max) {
		
		int inserts = -1;
		if(A != null && B == null)
			return inserts;
		
		if(A != null && B != null)
			inserts=0;      
		
		if(A == null && B == null) {
			inserts = 0;
			return inserts;
		}
		
		if(A == null && B != null) {
			
			int mid=min+(max-min)/2;
			A=new Node(mid);
			inserts=1;
		}
		
		int left = countUtils(A.left,B.left,min,A.val);
		int right = countUtils(A.right,B.right,A.val,max);
		
		if(left == -1 || right == -1)
			return -1;
		
		return inserts + countUtils(A.left, B.left, min, A.val) + countUtils(A.right, B.right, A.val, max);
	}
	
	public static int count(Node one, Node two, int value) {
		
		return countUtils(one, two, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		
		Node t1 = new Node(10);
		t1.left = new Node(9);
		t1.right = new Node(20);
		
		Node t2 = new Node(5);
		t2.left = new Node(2);
		t2.left.left = new Node(1);
		t2.right = new Node(7);
		
		System.out.println(count(t1, t2, 0));
	}
}

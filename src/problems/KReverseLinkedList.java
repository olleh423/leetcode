package problems;

/*
 
 	Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 	
	Example:
	
	Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
	Output:  3->2->1->6->5->4->8->7->NULL. 
	
	Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
	Output:  5->4->3->2->1->8->7->6->NULL. 
  
 */

public class KReverseLinkedList {

	private static class Node {
		int val;
		Node next;
		Node(int val) {
			this.val = val;
		}
	}
	
	private static Node kReverseLinkedList(Node head, int k) {
		
		java.util.Stack<Node> stack = new java.util.Stack<>();
		Node start = null, temp = null;
		int i=1;
		
		while(head != null || !stack.isEmpty()) {
			
			if(i % (k+1) != 0) {
				stack.push(head);
				if(head.next != null)
					head = head.next;
			} else {
				
				while(! stack.isEmpty()) {
					if(temp == null) {
						temp = stack.pop();
						start = temp;
					} else {
						temp.next = stack.pop();
						temp = temp.next;
					}
				}
			}
			i++;
		}
		temp.next = null;
		return start;
	}
	
	private static void showList(Node head) {
		
		while(head != null) {
			System.out.print(head.val + " --> ");
			head = head.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		
		int k = 3;
		
		showList(head);
		showList(kReverseLinkedList(head, k));		
	}
}

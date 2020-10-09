package problems;

/*
 * 
 * 
 * Given a singly linked list
		Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 		Given {1,2,3,4,5,6}, reorder it to {1,6,2,5,3,4}.
 * 
 */

public class ReorderLinkedList {

	
	private static class Node {
		int value;
		Node next;
		Node(int value) {
			this.value = value;
		}
	}
	
	public static Node reorder(Node A) {
		
		java.util.Stack<Node> stack = new java.util.Stack<>();
		
		Node temp, head, start;
		temp = head = start = A;
		
		int size = 0;
		
		while(temp != null) {
			stack.push(temp);
			temp = temp.next;
			size++;
		}
		size /= 2;
		
		while(size >= 0) {
			
			Node pop = stack.pop();
			pop.next = head.next;
			head.next = pop;
			head = head.next.next;
			size--;
		}
		
		head.next = null;
		
		return start;
	}
	
	private static void showList(Node head) {
		
		while(head != null) {
			System.out.print(head.value + " -> ");
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
		
		showList(head);
		showList(reorder(head));
	}
}

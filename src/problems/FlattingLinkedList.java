package problems;

/*
 * flatten linked list in sorted order
 */

public class FlattingLinkedList {

	class Node {
		Node(int data) { this.data = data; }
		int data;
		Node next;
		Node down;
		@Override
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	Node merge(Node a, Node b) {
		
		if(a == null) return b;
		if(b == null) return a;
		
		Node result = null;
		
		if(a.data < b.data) {
			result = a;
			result.down = merge(a.down, b);
		} else {
			result = b;
			result.down = merge(a, b.down);
		}
		
		return result;
	}
	
	Node flatLinkedList(Node head) {
		
		if(head == null || head.next == null) return head;
		
		return merge(head, flatLinkedList(head.next));
	}
	
	Node getLinkedList() {
		
		Node head = new Node(5);
		head.next = new Node(10);
		head.next.next = new Node(19);
		head.next.next.next = new Node(28);
		
		head.next.next.next.down = new Node(35);
		head.next.next.next.down.down = new Node(40);
		head.next.next.next.down.down.down = new Node(45);
		
		head.next.next.down = new Node(22);
		head.next.next.down.down = new Node(50);
		
		head.next.down = new Node(20);
		
		head.down = new Node(7);
		head.down.down = new Node(8);
		head.down.down.down = new Node(30);
		
		return head;
	}
	
	void printList(Node head) {
		if(head == null) {
			System.out.print(" NULL");
			return;
		}
		System.out.print(head.data + " -> ");
		printList(head.down);
	}
	
	public static void main(String... args) {
		
		FlattingLinkedList flat = new FlattingLinkedList();
		flat.printList(flat.flatLinkedList(flat.getLinkedList()));
	}	
}

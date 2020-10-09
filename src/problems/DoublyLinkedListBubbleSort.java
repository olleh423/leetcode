package problems;

public class DoublyLinkedListBubbleSort {

	/*
	 * Doubly linked list node structure
	 */
	private static class Node {
		int value;
		Node next, prev;
		Node(int value) {
			this.value = value;
		}
	}
	
	private static Node getDoublyLinkedList() {
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		
		Node head = three;
		
		three.prev = null;
		three.next = one; one.prev = three;
		one.next = five; five.prev = one;
		five.next = two; two.prev = five;
		two.next = six; six.prev = two;
		six.next = four; four.prev = six;
		four.next = null;
		
		return head;
	}
	
	private static void showList(Node head) {
		
		if(head == null)
			return;
		
		if(head.next == null) {
			System.out.println(head.value);
			return;
		}
		
		System.out.print(head.value + " <----> ");
		showList(head.next);
	}
	
	private static void swap(Node one, Node two) {
		
		Node onePrev = one.prev;
		Node twoNext = two.next;
		
		two.prev = onePrev;
		one.next = twoNext;
		one.prev = two;
		two.next = one;
	}
	
	/*
	 * sort doubly linked list using bubble sort
	 */
	public static Node sort(Node head) {
		
		Node newHead = null;
		
		while(head != null) {
			
			Node next = head.next;
			
			while(next != null) {
				
				if(next.value < head.value) {
					
					swap(head, next);
					showList(head);
				}
				
				next = next.next;
			}
			
			if(newHead == null)
				newHead = head;
			
			head = head.next;
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		
		Node head = getDoublyLinkedList();
		
		showList(head);
		
		Node sorted = sort(head);
		
		showList(sorted);
	}
}

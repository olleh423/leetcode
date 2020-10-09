package problems;

import java.util.Stack;

public class LinkedListModifySecondHalf {

	private static class Node {
		int value;
		Node next;
		Node(int value) {
			this.value = value;
		}
	}
	
	
	private static Node reverseFirst(Node head) {
		
		if(head == null)
			return null;
		
		Node prev = null;
		Node current = head;
		
		while(current != null) {
			
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
		return head;
	}
	
	private static void mergeFirstIntoSecond(Node one, Node two) {
		
		if(one == null || two == null)
			return;
		
		while(one != null && two != null) {
			
			two.value += one.value;
			one = one.next;
			two = two.next;
		}
	}
	
	private static void connect(Node one, Node two) {
		
		if(one == null || two == null) 
			return;
		
		Node temp = one;
		while(temp.next != null)
			temp = temp.next;
		
		temp.next = two;
	}
	
	/*
	 * O(n) time with O(1) space
	 */
	public static void convertConstantSpace(Node head) {
		
		if(head == null)
			return;
		
		Node fast = head, slow = head;
		Node one = head;
		Node two = null;
		
		while(true) {
			
			if(fast.next == null) {
				
				two = slow.next;
				slow.next = null;
				one = reverseFirst(one);
				one.value += one.value;
				mergeFirstIntoSecond(one.next, two);
				reverseFirst(one);
				connect(one, two);
				break;
				
			} else if (fast.next.next == null) {

				two = slow.next;
				slow.next = null;
				one = reverseFirst(one);
				mergeFirstIntoSecond(one, two);
				reverseFirst(one);
				connect(one, two);
				break;
				
			} else {
				
				slow = slow.next;
				fast = fast.next.next;
			}
		}
	}
	
	/*
	 * O(n) time with O(n) space
	 */
	public static void convertWithStack(Node head) {
		
		if(head == null)
			return;
		
		Stack<Integer> stack = new Stack<>();
		Node fast = head, slow = head;
		
		while(true) {

			stack.push(slow.value);
			
			if(fast.next == null) {
				break;
			} else if(fast.next.next == null) {
				slow = slow.next;
				break;
			} else {
				fast = fast.next.next;
				slow = slow.next;
			}
		}
		
		while(slow != null) {

			slow.value += stack.pop();
			slow = slow.next;
		}
	}
	
	public static void showList(Node head) {
		
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		
		System.out.print(head.value + " --> ");
		showList(head.next);
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		
		showList(head);
		//convertWithStack(head);
		convertConstantSpace(head);
		showList(head);
	}
}

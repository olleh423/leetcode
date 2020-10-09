package problems;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandom {

	private static class Node {
		
		int value;
		Node next;
		Node random;
		
		Node(int value) {
			this.value = value;
		}
		
		@Override
		public int hashCode() {
			return new Integer(value).hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(! (obj instanceof Node))
				return false;
			
			return this.hashCode() == obj.hashCode();
		}
	}
	
	/*
	 * Time : O(n)
	 * Space : O(n)
	 */
	public Node clone(Node head) {
		
		if(head == null)
			return null;
		
		Map<Node, Node> map = new HashMap<>();
		
		Node current = head;
		while(current != null) {
			
			Node n = new Node(current.value);
			map.put(current, n);
			current = current.next;
		}
		
		current = head;
		while(current != null) {
			
			Node n = map.get(current);
			n.next = map.get(current.next);
			n.random = map.get(current.random);
			
			current = current.next;
		}
		
		Node cloned = map.get(head);
		return cloned;
	}
	
	/*
	 * Time : O(n)
	 * Space : O(1)
	 */
	public Node cloneTwo(Node head) {
		
		if(head == null)
			return null;
		
		Node current = head;
		while(current != null) {
			
			Node n = new Node(current.value);
			n.next = current.next;
			current.next = n;
			current = current.next != null ? current.next.next : null;
		}
		
		current = head;
		while(current != null) {
			
			if(current.next != null && current.random != null) {
				current.next.random = current.random.next;
				current.next = current.next != null ? current.next.next : null;
			}
			
			current = current.next;
		}
		
		Node clonedHead, c1, c2;
		clonedHead = c1 = c2 = head;
		
		while(c1 != null && c2 != null) {
			
			c1.next = c2.next;
			c2.next = c2.next != null ? c2.next.next : null;
			
			c1 = c1.next;
			c2 = c2.next;
		}
		
		return clonedHead;
	}
	
	private Node getLinkedListWithRandom() {
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		eight.next = nine;
		
		one.random = six;
		two.random= five;
		three.random = nine;
		four.random = seven;
		five.random = one;
		six.random = two;
		seven.random = three;
		eight.random = eight;
		nine.random = four;
		
		return one;
	}
	
	public void display(Node head) {
		
		while(head != null) {
			System.out.print(head.value + " -> ");
			head = head.next;
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		
		CloneLinkedListWithRandom obj = new CloneLinkedListWithRandom();
		
		Node original = obj.getLinkedListWithRandom();
		Node cloned = obj.cloneTwo(original);
		
		obj.display(original);
		obj.display(cloned);
	}
}

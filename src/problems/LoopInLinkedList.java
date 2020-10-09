package problems;

public class LoopInLinkedList {

	private static class Node {
		
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	
	public int getSize(Node head) {
		
		Node fast, slow;
		fast = slow = head;
		
		do {
			
			fast = fast.next.next;
			slow = slow.next;
			
		} while(fast != slow);
		
		Node prev = fast;
		slow = head;
		while(fast!= slow) {
			
			slow = slow.next;
			prev = fast;
			fast = fast.next;
		}
		
		prev.next = null;
		
		int size = 0;
		Node temp = head;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		
		return size;
	}
	
	private Node getLinkedList() {
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		eight.next = four;
		
		return one;
	}
	
	public static void main(String[] args) {
		
		LoopInLinkedList obj = new LoopInLinkedList();
		
		Node head = obj.getLinkedList();
		
		System.out.println(obj.getSize(head));
	}
}

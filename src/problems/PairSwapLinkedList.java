package problems;

public class PairSwapLinkedList {

	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	
	public Node swapPairs(Node head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node prev = null, temp = head;
		
		while(temp != null && temp.next != null) {
			
			Node next = temp.next;
			temp.next = temp.next.next;
			next.next = temp;
			
			if(prev != null)
				prev.next = next;
			else 
				head = next;
			
			prev = temp;
			temp = temp.next;
		}
		
		return head;
	}
	
	private void print(Node head) {
		
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		
		System.out.print(head.data + " -> ");
		print(head.next);
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		PairSwapLinkedList obj = new PairSwapLinkedList();
		
		obj.print(head);
		obj.print(obj.swapPairs(head));
	}
}

package problems;

public class ReverseLinkedListKGroups {

	private static class Node {
		int val;
		Node next;
		Node(int val) {
			this.val = val;
		}
	}
	
	private static class ReversedList {
		Node front;
		Node rear;
		ReversedList(Node front, Node rear) {
			this.front = front;
			this.rear = rear;
		}
	}
	
	private ReversedList reverse(Node head) {
		
		Node prev = null, rear = head;
		while(head != null) {
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return new ReversedList(prev, rear);
	}
	
	private Node reverseInGroups(Node head, int k) {
		
		if(head == null || k == 1 || k == 0)
			return head;
		
		Node newHead = null, newEnd = null, temp = head, partHead = head;
		
		int i = 1;
		while(true) {
			
			if(head == null)
				break;
			
			if(i % k == 0) {
				
				Node next = head.next;
				head.next = null;
				
				ReversedList result = reverse(partHead);
				if(newHead == null) {
					newHead = result.front;
					newEnd = result.rear;
				} else {
					newEnd.next = result.front;
					newEnd = result.rear;
				}
				head = partHead = next;
				
			} else {
				
				head = head.next;
			}
			
			i++;
		}
		
		if(newEnd == null)
			return temp;
		
		if(partHead != null)
			newEnd.next = partHead;
		
		return newHead;
	}
	
	private Node getList() {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		//head.next.next.next = new Node(4);
		//head.next.next.next.next = new Node(5);
		return head;
	}
	
	private void showList(Node head) {
		
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		System.out.print(head.val + " -> ");
		showList(head.next);
	}
	
	public static void main(String[] args) {
		
		ReverseLinkedListKGroups obj = new ReverseLinkedListKGroups();
		
		Node head = obj.getList();
		int k = 5;
		
		obj.showList(head);
		obj.showList(obj.reverseInGroups(head, k));
	}
}

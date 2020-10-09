package problems;


public class Sort012LinkedList {

	class Node {
		Node(int data) {this.data = data;}
		int data;
		Node next;
	}
	
	public Node sortLinkedList(Node head) {
		
		Node zStart, z, oStart, o, tStart, t;
		zStart = z = oStart = o = tStart = t = null;
		
		while(head != null) {
			
			int data = head.data;
			
			if(data == 0) {
				
				if(zStart == null) {
					z = head;
					zStart = z;
				}
				else{
					z.next = head; 
					z = z.next;
				}
				
			} else if(data == 1) {
				
				if(oStart == null) {
					o = head;
					oStart = o;
				}
				else{
					o.next = head; 
					o = o.next;
				}
				
			} else {
								
				if(tStart == null) {
					t = head;
					tStart = t;
				}
				else{
					t.next = head; 
					t = t.next;
				}
			}
			
			head = head.next;
		}
		
		System.out.println();
		printList(zStart);
		System.out.println();
		printList(oStart);
		System.out.println();
		printList(tStart);
		
		return null;
	}
	
	
	public Node getUnsortedList(int[] arr) {
		
		Node head, current;
		head = current = null;
		
		for(int a : arr) {
			
			Node n = new Node(a);
			
			if(head == null) head = n;
			
			if(current == null) {
				current = n;
			}
			else {
				current.next = n;
				current = current.next;
			}
		}
		
		return head;
	}
	
	public void printList(Node head) {
		
		if(head == null) {
			System.out.print("NULL");
			return;
		}
		
		System.out.print(head.data + " --> ");
		printList(head.next);
	}
	
	public static void main(String[] args) {
		
		int [] arr = {2, 0, 1, 0, 2, 2, 1, 0, 0, 1};
		
		Sort012LinkedList obj = new Sort012LinkedList();
		
		Node head = obj.getUnsortedList(arr);
		
		obj.printList(head);
		obj.sortLinkedList(head);
	}
}

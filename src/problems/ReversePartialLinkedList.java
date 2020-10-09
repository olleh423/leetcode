package problems;

/*
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * LeetCode 96
 */

public class ReversePartialLinkedList {

	private static class Node {
		int value;
		Node next;
		Node(int value) {
			this.value = value;
		}
	}
	
	public Node reversePart(Node head, int m, int n) {
		
		if(head == null || head.next == null || m == n)
            return head;
        
        Node curr = new Node(-1);
        Node prev = new Node(-1);
        curr.next = head;
        prev.next = head;
        
        int i = 0;
        while(i++ < n) {
            curr = curr.next;
        }
        i = 1;
        while(i++ < m) {
            prev = prev.next;
        }
        
        i = n - m + 1;
        Node post = curr.next;
        curr = prev.next;
        
        while(i-- > 0) {
        	Node temp = curr.next;
            curr.next = post;
            post = curr;
            curr = temp;
        }
        prev.next = post;
        return m > 1 ? head : post;
	}
	
	private void display(Node head) {
		
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		System.out.print(head.value + " --> ");
		display(head.next);
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		int m = 1;
		int n = 4;
		
		ReversePartialLinkedList obj = new ReversePartialLinkedList();
		
		System.out.println("Original List : ");
		obj.display(head);
		System.out.println("Reversed from m to n : ");
		obj.display(obj.reversePart(head, m, n));
	}
}

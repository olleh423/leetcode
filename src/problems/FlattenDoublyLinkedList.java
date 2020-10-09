package problems;

/*
 *  Leetcode : 430. Flatten a Multilevel Doubly Linked List
 */
public class FlattenDoublyLinkedList {

	private static class Node {
		int val;
		Node next;
		Node prev;
		Node child;
		Node(int val) {
			this.val = val;
		}
	}
	
	public Node flatten(Node head) {
        
        if(head == null)
            return null;
        
        Node front = new Node(head.val);
        Node next = head.next;
        
        Node down = flatten(head.child);
        if(down == null) {
            front.next = flatten(next);
        } else {
            front.next = down;
            while(down.next != null) {
                down = down.next;
            }
            down.next = flatten(next);
        }
        
        return front;
    }
	
	private void show(Node head) {
		
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		System.out.print(head.val + " --> ");
		show(head.next);
	}
	
	private Node getLinkedList() {
	
		Node head = new Node(1);
		
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		head.next.child = new Node(5);
		head.next.child.next = new Node(6);
		head.next.child.next.next = new Node(7);
		head.next.child.next.next.next = new Node(8);
		
		head.next.child.next.child = new Node(9);
		head.next.child.next.child.next = new Node(10);
		
		return head;
	}
	
	public static void main(String[] args) {
		
		FlattenDoublyLinkedList obj = new FlattenDoublyLinkedList();
		
		obj.show(obj.flatten(obj.getLinkedList()));
	}
}

package problems;

import java.util.HashMap;
import java.util.Map;

/*
 * enqueue, dequeue, delete, isAvailable operations in O(1) time.
 */

class ExtendedQueue {
	
	static class Node {
		int value;
		Node next;
		Node prev;
		Node(int value) {
			this.value = value;
		}
	}
	
	private Map<Integer, Node> map;
	private Node head, tail;
	
	ExtendedQueue() {
		
		this.map = new HashMap<>();
	}

	public void enqueue(int value) {
		
		Node node = new Node(value);
		
		if(head == null) {
			tail = head = node;
		} else {
			node.prev = tail;
			tail.next = node;
			tail = tail.next;
		}
		
		map.put(value, node);
	}

	public int dequeue() {
		
		if(head == null) 
			return -1;
		
		Node removedNode = map.remove(head.value);
		head = head.next;
		head.prev = null;
		return removedNode.value;
	}

	public boolean isAvailable(int value) {
		
		return map.containsKey(value);
	}

	public int deleteElement(int element) {
		
		if(!map.containsKey(element))
			return -1;
		
		if(map.size() == 1) {
			head = tail = null;
			return map.remove(element).value;
		}
		
		Node removedNode = map.remove(element);
		if(removedNode.prev == null) {
			head = head.next;
			head.prev = null;
		} else {
			removedNode.prev.next = removedNode.next;
		}
		
		return removedNode.value;
	}

	public void display() {
		
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
}

public class ExtendedQueueImpl {
	
	public static void main(String[] args) {
		
		ExtendedQueue eq = new ExtendedQueue();
		
		eq.display(); // display
		eq.enqueue(1);
		eq.enqueue(2);
		eq.display(); // display
		System.out.println("Find 1 : " + eq.isAvailable(1));
		System.out.println("Find 3 : " + eq.isAvailable(3));
		eq.enqueue(3);
		eq.enqueue(4);
		eq.display(); // display
		System.out.println("Find 3 : " + eq.isAvailable(3));
		System.out.println("dequeue : " + eq.dequeue());
		System.out.println("dequeue : " + eq.dequeue());
		eq.display(); // display
		eq.enqueue(5);
		eq.display(); // display
		System.out.println("Find 5 : " + eq.isAvailable(5));
		System.out.println("deleted element 4 : " + eq.deleteElement(4));
		eq.display(); // display
		System.out.println("deleted element 6 : " + eq.deleteElement(6));
		eq.display(); // display
		System.out.println("Find 6 : " + eq.isAvailable(6));
		eq.enqueue(8);
		eq.display(); // display
		System.out.println("deleted element 5 : " + eq.deleteElement(5));
		eq.display(); // display
		System.out.println("Find 8 : " + eq.isAvailable(8));
		System.out.println("Find 9 : " + eq.isAvailable(9));
	}
}

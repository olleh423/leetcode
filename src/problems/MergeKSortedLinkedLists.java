package problems;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLinkedLists {
	
	private static class Node {
		
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	
	public static Node merge(Node one, Node two) {
		
		Node head = null, temp = null;
		while(one != null || two != null) {
			
			if(one == null) {
				temp.next = two;
				return head;
			}
			if(two == null) {
				temp.next = one;
				return head;
			}
			
			if(one.data < two.data) {
				if(temp == null) {
					temp = one;
				} else {
					temp.next = one;
					temp = temp.next;
				}
				one = one.next;
			} else {
				if(temp == null) {
					temp = two;
				} else {
					temp.next = two;
					temp = temp.next;
				}
				two = two.next;
			}
			
			if(head == null) {
				head = temp;
			}
		}
		return head;
	}
	
	public static Node merge(List<Node> nodes) {
		
		Node head = null;
		for(int i=1 ; i<nodes.size() ; i++) {
			head = head == null ? merge(nodes.get(i-1), nodes.get(i)) : merge(head, nodes.get(i));
		}
		
		return head;
	}
	
	private static void showList(Node node) {
		
		while(node != null) {
			System.out.print(node.data + " --> ");
			node = node.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		
		Node one = new Node(1);
		one.next = new Node(10);
		one.next.next = new Node(20);
		
		Node two = new Node(4);
		two.next = new Node(11);
		two.next.next = new Node(13);
		
		Node three = new Node(3);
		three.next = new Node(8);
		three.next.next = new Node(9);
		
		List<Node> nodes = new ArrayList<>();
		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		
		Node sortedList = merge(nodes);
		showList(sortedList);
	}
}

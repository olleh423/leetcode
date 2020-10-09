package problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterStream {

	private static class Node {
		Character ch;
		boolean isRemoved;
		Node next, prev;
		Node() {
			this(null);
		}
		Node(Character ch) {
			this.ch = ch;
			this.isRemoved = false;
		}
	}
	
	private static class Solution {
		
		private int size;
		private Node head, tail;
		private Map<Character, Node> map;
		
		Solution() {
			size = 0;
			head = new Node();
			tail = new Node();
			map = new HashMap<>();
			
			head.next = tail;
			tail.prev = head;
		}
		
		private void insertIntoStream(Character ch) {
			
			Node node = new Node(ch);
			tail.prev.next = node;
			node.prev = tail.prev;
			node.next = tail;
			tail.prev = node;
			
			map.put(ch, node);
			size++;
		}
		
		private void removeFromStream(Character ch) {
			
			Node node = map.get(ch);
			
			if(node.isRemoved) 
				return;
			
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.isRemoved = true;
			size--;
		}
		
		public void insert(Character ch) {
			
			if(map.containsKey(ch)) {
				removeFromStream(ch);
			} else {
				insertIntoStream(ch);
			}
		}

		public Character getFirstNonRepeating() {
			
			if(size == 0) 
				return null;
			
			return head.next.ch;
		}
	}
	
	public static void main(String[] args) {
		
		
		Solution solution = new Solution();
		
		solution.insert('a');
		solution.insert('b');
		solution.insert('c');
		solution.insert('c');
		solution.insert('d');
		System.out.println(solution.getFirstNonRepeating());
		solution.insert('a');
		solution.insert('a');
		System.out.println(solution.getFirstNonRepeating());
		solution.insert('b');
		System.out.println(solution.getFirstNonRepeating());
	}
}

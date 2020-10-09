package problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private static class Node {
		int key, value;
		Node next, prev;
		Node() {}
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int capacity;
	private int size;
	private Map<Integer, Node> map;
	private Node head, tail;
	
	public LRUCache(int capacity) {
		
		this.capacity = capacity;
		this.size = 0;
		map = new HashMap<>();
		
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	private void addToFront(Node node) {
		
		node.next = head.next;
		head.next = node;
		node.next.prev = node;
		node.prev = head;
	}
	
	private void moveToFront(Node node) {
		
		removeFromCache(node);
		addToFront(node);
	}
	
	private void removeFromLast() {
		
		Node node = tail.prev;
		removeFromCache(node);
		map.remove(node.key);
		size--;
	}
	
	private void removeFromCache(Node node) {
		
		Node prev = node.prev;
		Node next = node.next;
		
		prev.next = next;
		next.prev = prev;
	}
	
	//Performs put operation in O(1) time
	public void put(int key, int value) {
		
		Node node = map.getOrDefault(key, null);
		
		if(node == null) {
			
			node = new Node(key, value);
			addToFront(node);
			map.put(key, node);
			size++;
			
			if(size > capacity) {
				removeFromLast();
			}
		}
		else {
			node.value = value;
			moveToFront(node);
		}
	}

	//Performs get operation in O(1) time
	public int get(int key) {
		
		Node node = map.getOrDefault(key, null);
		
		if(node == null)
			return -1;
		
		moveToFront(node);
		return node.value;
	}
	
	//Driver
	public static void main(String[] args) {
		
		int capacity = 4;
		
		LRUCache cache = new LRUCache(capacity);
		
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		System.out.println(cache.get(2));
		cache.put(1, 40);
		cache.put(4, 50);
		System.out.println(cache.get(3));
		System.out.println(cache.get(1));
		System.out.println(cache.get(7));
		cache.put(8, 80);
		cache.put(9, 90);
		cache.put(10, 100);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(8));
		System.out.println(cache.get(9));
	}
}

package problems.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Auther : Vijay Sharma 17-10-2020
 */
public class LRUCache {

    public static void main(String[] args) {

        LRUCache obj = new LRUCache(2);
    }

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

    public int get(int key) {

        Node node = map.getOrDefault(key, null);

        if(node == null)
            return -1;

        moveToFront(node);
        return node.value;
    }

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
}

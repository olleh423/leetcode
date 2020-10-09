package problems;

import java.util.NoSuchElementException;

public class MyQueue<T> {
	
	private static class QueueNode<T> {
		
		private T data;
		private QueueNode<T> next;
		
		QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> front;
	private QueueNode<T> rear;
	
	public void add(T data) {
		
		QueueNode<T> node = new QueueNode<T>(data);
		
		if(front == null && rear == null) {			
			front = rear = node;
		} else {
			rear.next = node;
			rear = rear.next;
		}
	}
	
	public T remove() {
		
		if(front == null)
			throw new NoSuchElementException();
		
		T data = front.data;
		front = front.next;
		
		if(front == null)
			rear = null;
		
		return data;
	}
	
	public T peek() {
		
		if(front == null)
			throw new NoSuchElementException();
		
		return front.data;
	}
	
	public boolean isEmpty() {
		
		return front == null;
	}
}

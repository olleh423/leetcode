package problems;

public class MinHeapImpl {
	
	public static void main(String... args) {
		
		int[] arr = {20, 10, 25, 40, 10, 7, 9, 3, 1};
		
		MinHeap mh = new MinHeap();
		
		for(int n : arr) {
			mh.add(n);
		}
		
		mh.showHeapAsList();
		
		try {
			
			System.out.println("Min 1 is : " + mh.extractMin());
			System.out.println("Min 2 is : " + mh.extractMin());
			mh.showHeapAsList();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		mh.showHeapAsList();
	}
} 

class MinHeap {

	private int[] arr;
	private int capacity;
	private int size;
	
	public MinHeap() {
		
		this(10);
	}
	
	public MinHeap(int initialCapacity) {
		
		this.capacity = initialCapacity;
		this.arr = new int[capacity];
		this.size = 0;
	}
	
	public void add(int value) {
		
		if(size == capacity) 
			increaseCapacity();
		
		arr[size] = value;
		size++;
		heapifyUp(size - 1);
	}
	
	public int extractMin() throws Exception {
		
		if(size == 0)
			throw new Exception("No element to extract");
		
		int min = arr[0];
		arr[0] = arr[size-1];
		size--;
		heapifyDown(0);
		
		return min;
	}
	
	public int size() {
		
		return size;
	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	public void showHeapAsList() {
		
		for(int i=0 ; i<size ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private int getParentIndex(int childIndex) {
		
		return childIndex % 2 == 0 ? (childIndex - 2) / 2 : (childIndex - 1) / 2;
	}
	
	private int getLeftChildIndex(int parentIndex) {
		
		return (2 * parentIndex + 1);
	}
	
	private int getRightChildIndex(int parentIndex) {
		
		return (2 * parentIndex + 2);
	}
	
	private void swap(int indexA, int indexB) {
		
		arr[indexA] = arr[indexA] ^ arr[indexB];
		arr[indexB] = arr[indexA] ^ arr[indexB];
		arr[indexA] = arr[indexA] ^ arr[indexB];
	}
	
	private void heapifyUp(int childIndex) {
		
		int parentIndex = getParentIndex(childIndex);
		
		if(childIndex == 0 || arr[childIndex] >= arr[parentIndex]) return;
		
		swap(childIndex, parentIndex);
		heapifyUp(parentIndex);
	}
	
	private void heapifyDown(int parentIndex) {
		
		int leftChildIndex = getLeftChildIndex(parentIndex);
		int rightChildIndex = getRightChildIndex(parentIndex);
		
		if(leftChildIndex >= size) return;
		
		if(rightChildIndex >= size && arr[leftChildIndex] < arr[parentIndex])
			swap(parentIndex, leftChildIndex);
		
		int minIndex = arr[leftChildIndex] < arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
		
		swap(parentIndex, minIndex);
		heapifyDown(minIndex);
	}
	
	private void increaseCapacity() {
		
		capacity *= 2;
		int[] temp = arr;
		arr = new int[capacity];
		
		for(int i=0 ; i<temp.length ; i++) {
			arr[i] = temp[i];
		}
	}
}

package problems;

public class KLargestElementArray {
	
	private static class MinHeap {
		
		int[] arr;
		int size;
		int capacity;
		
		MinHeap(int capacity) {
			this.size = 0;
			this.capacity = capacity;
			arr = new int[capacity];
		}
		
		void add(int value) {
			
			if(size != capacity) {
				arr[size] = value;
				heapifyUp(size);
				size++;
			} else {
				if(arr[0] < value) {
					arr[0] = value;
					heapifyDown(0);
				}
			}
		}
		
		int getParentIndex(int childIndex) {
			return childIndex % 2 == 0 ? (childIndex - 2) / 2 : (childIndex - 1) / 2;
		}
		
		int getLeftChildIndex(int parentIndex) {
			return (2 * parentIndex + 1);
		}
		
		int getRightChildIndex(int parentIndex) {
			return (2 * parentIndex + 2);
		}
		
		void swap(int indexA, int indexB) {
			
			arr[indexA] = arr[indexA] ^ arr[indexB];
			arr[indexB] = arr[indexA] ^ arr[indexB];
			arr[indexA] = arr[indexA] ^ arr[indexB];
		}
		
		void heapifyUp(int index) {
			if(index == 0)
				return;
			int parentIndex = getParentIndex(index);
			if(arr[parentIndex] > arr[index]) 
				swap(parentIndex, index);
			heapifyUp(parentIndex);
		}
		
		void heapifyDown(int index) {

			int leftChildIndex = getLeftChildIndex(index);
			int rightChildIndex = getRightChildIndex(index);
			
			if(leftChildIndex >= size) return;
			
			if(rightChildIndex >= size ) {
				if(arr[index] > arr[leftChildIndex])
					swap(index, leftChildIndex);
				return;
			}
			
			if(arr[index] < arr[leftChildIndex] && arr[index] < arr[rightChildIndex])
				return;
			
			int minIndex = arr[leftChildIndex] > arr[rightChildIndex] ? rightChildIndex : leftChildIndex;
			swap(index, minIndex);
			heapifyDown(minIndex);
		}
		
		void showHeap() {
			for(int a : arr)
				System.out.println(a);
		}
	}
	
	public static void kLargestElement(int[] arr, int k) {
		
		MinHeap heap = new MinHeap(k);
		for(int a : arr) {
			System.out.print(a + " ");
			heap.add(a);
		}
		System.out.println();
		heap.showHeap();
	}
	
	public static void main(String[] args) {
		
		//int[] arr = {9, 4, 6, 3, 7, 12, 44, 8, 88, 55, 13, 69, 5, 23};
		int[] arr = {5, 8, 6, 1, 6, 9, 4, 7, 9};
		int k = 5;
		
		kLargestElement(arr, k);
	}
}

package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
	
	private static void addNumber(int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		
		if(minHeap.size() == 0 || number < minHeap.peek())
			minHeap.add(number);
		else
			maxHeap.add(number);
	}
	
	private static void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		
		if(minHeap.size() - maxHeap.size() >= 2)
			maxHeap.add(minHeap.poll());
		else if(maxHeap.size() - minHeap.size() >= 2)
			minHeap.add(maxHeap.poll());
	}
	
	private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		
		if(minHeap.size() == maxHeap.size())
			return ((double) minHeap.peek() + maxHeap.peek()) / 2;
		
		return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
	}
	
	public static double[] getMedians(int[] arr) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer one, Integer two) {
				return two.compareTo(one);
			}
		});
		
		double[] medians = new double[arr.length];
		
		for(int i=0 ; i<arr.length ; i++) {
			
			addNumber(arr[i], minHeap, maxHeap);
			rebalance(minHeap, maxHeap);
			medians[i] = getMedian(minHeap, maxHeap);
		}
		
		return medians;
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
		double[] medians = getMedians(arr);
		
		for(double A : medians)
			System.out.println(A);
	}
}

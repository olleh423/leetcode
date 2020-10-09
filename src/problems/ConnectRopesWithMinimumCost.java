package problems;

import java.util.PriorityQueue;

public class ConnectRopesWithMinimumCost {

	public static int connect(int[] ropes) throws Exception {
		
		int totalCost = 0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int n : ropes)
			minHeap.add(n);
		
		while(!minHeap.isEmpty()) {
			
			int min1 = minHeap.poll();
			int min2 = minHeap.poll();
			
			totalCost += (min1 + min2);
			
			if(!minHeap.isEmpty())
				minHeap.add(min1 + min2);
		}
		
		return totalCost;
	}
	
	public static void main(String[] args) throws Exception {
		
		int[] ropes = {4, 2, 1, 3, 5, 7};
		
		int totalMinimizedCost = connect(ropes);
		
		System.out.println("Total minimized cost : " + totalMinimizedCost);
	}
}

package problems;
import java.util.*;

public class KthElementInSortedMatrix {

	private static class Bean {
		int value, i, j;
		Bean(int value, int i, int j) {
			this.value = value;
			this.i = i;
			this.j = j;
		}
	}
	
	public static int kthSmallest(int[][] arr, int k) {
		
		if(arr == null)
			return -1;
		
		PriorityQueue<Bean> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
		
		for(int i=0 ; i<arr.length ; i++)
			minHeap.add(new Bean(arr[i][0], i, 0));
	
		while(k > 1) {
			
			Bean min = minHeap.poll();
			if(min.j+1 < arr[min.i].length)
				minHeap.add(new Bean(arr[min.i][min.j+1], min.i, min.j+1));
			
			k--;
		}
		
		return minHeap.poll().value;
	}
    
    public static void main(String[] args) {
    	
    	int[][] arr = {{1,  5,  10}, {9, 11, 13}, {12, 13, 15}};
    	int k = 5;
    	System.out.println(kthSmallest(arr, k));
    }
}

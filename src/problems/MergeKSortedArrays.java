package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	private static class HeapNode {
		
		int value;
		int i;
		int j;
		
		HeapNode(int value, int i, int j) {
			this.value = value;
			this.i = i;
			this.j = j;
		}
	}
	
	public int[] mergeKSortedArrays(int[][] arr) throws Exception {
		
		PriorityQueue<HeapNode> heap = new PriorityQueue<>(new Comparator<HeapNode>() {
			@Override
			public int compare(HeapNode arg0, HeapNode arg1) {
				return new Integer(arg0.value).compareTo(new Integer(arg1.value));
			}
		});
		
		int total = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			heap.add(new HeapNode(arr[i][0], i, 0));
			total += arr[i].length;
		}
		
		int[] res = new int[total];
		int i=0;
		while(!heap.isEmpty()) {
			
			HeapNode min = heap.poll();
			res[i++] = min.value;
			
			if(min.j < arr[min.i].length - 1)
				heap.add(new HeapNode(arr[min.i][min.j+1], min.i, min.j+1));
		}
		
		return res;
	}

	public static void main(String[] args) throws Exception {
		
		int[][] arr = { {6, 9, 18},
						{5, 7, 8},
						{1, 2, 3, 4, 11},
						{20, 21} };
		
		MergeKSortedArrays obj = new MergeKSortedArrays();
		
		int[] result = obj.mergeKSortedArrays(arr);
		
		for(int a : result)
			System.out.print(a + " ");
	}
}

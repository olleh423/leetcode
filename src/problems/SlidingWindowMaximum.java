package problems;
import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		
		//int[] arr = {1, 3, -1, 2, 1, 3, 6, 5, 7};
		//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int k = 4;
		
		int[] res = slidingWindowMax(arr, k);
		System.out.println(Arrays.toString(res));
	}
	
	private static int[] slidingWindowMax(int[] arr, int k) {
		
		if(arr == null)
			return null;
		
		int[] res = new int[arr.length - k + 1];
		LinkedList<Integer> queue = new LinkedList<>();
		
		int i=0, j=0, count=0;
		while(j < k) {
			
			if(queue.isEmpty())
				queue.add(j++);
			else if(arr[queue.getLast()] < arr[j])
				queue.removeLast();
			else
				queue.add(j++);
		}
		res[count++] = arr[queue.peek()];
		i++;
		
		while(j < arr.length) {
			
			if(queue.isEmpty()) {
				queue.add(j);
				res[count++] = arr[queue.peek()];
				i++; j++;
			}
			else if(queue.peek() < i) {
				queue.removeFirst();
			}
			else if(arr[queue.getLast()] < arr[j]) {
				queue.removeLast();
			}
			else {
				queue.add(j);
				res[count++] = arr[queue.peek()];
				i++; j++;
			}
		}
		
		return res;
	}
}

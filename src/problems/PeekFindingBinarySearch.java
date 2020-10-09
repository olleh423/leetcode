package problems;

public class PeekFindingBinarySearch {

	public static int peekIndex(int[] arr) {
		
		if(arr == null)
			return -1;
		
		if(arr.length == 1)
			return arr[0];
		
		if(arr.length == 2)
			return arr[0] > arr[1] ? 0 : 1;
			
		int low = 0, high = arr.length - 1;
		
		while(low < high) {
			
			int mid = (low + high) / 2;
			
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
				return mid;
			
			if(arr[mid] < arr[mid+1])
				low = mid;
			else
				high = mid;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5};
		int[] arr = {15, 6};// 7, 8, 7, 6, 5, 4, 3, 2, 1};
		//int[] arr = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
		
		int peekIndex = peekIndex(arr);
		System.out.println("Peek index : " + peekIndex + ", Element at peek : " + arr[peekIndex]);
	}
}

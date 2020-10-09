package problems;

public class KLargestElementsQuickSelect {

	public static void main(String[] args) {
	
		int[] arr = {5, 1, 3, 8, 4, 6, 7};
		int k = 3;
		
		for(int i=1 ; i<=arr.length ; i++)
			System.out.println(arr[kthLargest(arr, i)]);
	}
	
	private static int kthLargest(int[] arr, int k) {
		
		return solve(arr, 0, arr.length - 1, arr.length - k);
	}
	
	private static int solve(int[] arr, int i, int j, int d) {
		
		if(i == j)
			return i;
		
		int pivot = partition(arr, i, j);
		if(pivot == d)
			return pivot;
		else if(pivot < d)
			return solve(arr, pivot + 1, j, d);
		else
			return solve(arr, i, pivot - 1, d);
	}
	
	private static int partition(int[] arr, int i, int j) {
		
		int pivot = j;
		int low = i, high = i;
		while(high < j) {
			
			if(arr[high] < arr[pivot]) {
				swap(arr, low, high);
				low++; high++;
			}
			else {
				high++;
			}
		}
		swap(arr, low, pivot);
		return low;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}

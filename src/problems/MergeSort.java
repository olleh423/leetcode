package problems;

public class MergeSort {
	
	private void merge(int[] arr, int left, int mid, int right) {
		
		int n = mid - left + 1;
		int m = right - mid;
		
		int[] A = new int[n];
		int[] B = new int[m];
		
		for(int i=0 ; i<n ; i++)
			A[i] = arr[left + i];
		
		for(int j=0 ; j<m ; j++)
			B[j] = arr[mid + 1 + j];
		
		int i=0, j=0, k=left;
		while(i < n && j < m) {
			if(A[i] < B[j]) {
				arr[k++] = A[i++];
			} else {
				arr[k++] = B[j++];
			}
		}
		
		while(i < n) {
			arr[k++] = A[i++];
		}
		
		while(j < m) {
			arr[k++] = B[j++];
		}
	}
	
	private void sort(int[] arr, int left, int right) {
		
		if(left < right) {
			
			int mid = (left + right) / 2;
			
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public void mergeSort(int[] arr) {

		if(arr == null || arr.length == 0 || arr.length == 1)
			return;
		
		sort(arr, 0, arr.length - 1);
	}
	
	public void print(int[] arr) {
		
		for(int n : arr)
			System.out.print(n + " ");
	}
	
	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		
		int[] arr = {2, 1};
		ms.mergeSort(arr);
		ms.print(arr);
	}
}

package problems;

public class QuickSort {

	int partition(int arr[], int low, int high) {
		
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			
			if (arr[j] <= pivot) {
				
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	private void sort(int arr[], int low, int high) {
		
		if (low < high) {
			
			int pi = partition(arr, low, high);

			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	public void quickSort(int[] arr) {

		sort(arr, 0, arr.length - 1);
	}

	public void print(int[] arr) {

		for (int n : arr)
			System.out.print(n + " ");
	}

	public static void main(String[] arg) {

		int[] arr = { 5, 2, 3, 6, 9, 4, 5, 21, 7, 8 };

		QuickSort qs = new QuickSort();

		qs.quickSort(arr);
		qs.print(arr);
	}
}

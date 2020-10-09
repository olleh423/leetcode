package problems;

public class SagregateArray {

	public void sort(int[] arr) {
		
		int start = 0, end = arr.length-1;
		
		while(start < end) {
			
			if(arr[start] == 0) { 
				start++;
			}
			else {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
			
			if(arr[end] == 1)
				end--;
		}
	}
	
	public static void main(String... args) {
		
		int[] arr = {1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1};
		
		SagregateArray sa = new SagregateArray();
		sa.sort(arr);
		
		for(int n : arr)
			System.out.print(n + " ");
	}
}

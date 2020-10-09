package problems;

public class ArraySubSet {

	
	public static int getMinMaxSumOfSubArray(int[] arr, int n, int d) {
		
		int i=0, j=d, total = 0;
		
		while(j < n) {
			
			int min = arr[i], max=arr[i];
			
			for(int k=i ; k<=j ; k++) {
				
				min = min > arr[k] ? arr[k] : min;
				max = max < arr[k] ? arr[k] : max;
				
				System.out.print(arr[k]);
			}
			System.out.println();
			
			total += min += max;
			
			i++; 
			j++;
		}
		
		return total;
	}
	
	public static int getResult(int[] arr, int n, int d) {
		
		int total = 0;
		
		for(int i=d-1 ; i<n ; i++) {
			
			total += getMinMaxSumOfSubArray(arr, n, i);
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 5, 5};
		int n = 3;
		int d = 2;
		
		int result = getResult(arr, n, d);
		
		//System.out.println(result);
	}
}
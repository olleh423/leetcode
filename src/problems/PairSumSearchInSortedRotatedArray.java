package problems;

public class PairSumSearchInSortedRotatedArray {

	public static void isPairExists(int[] arr, int x) {
		
		int pi = 0;
		int max = arr[0];
		
		for(int i=0 ; i<arr.length ; i++) {
			if(max < arr[i]) {
				max = arr[i];
				pi = i;
			}
		}
		
		int i = pi == arr.length - 1 ? 0 : pi + 1;
		int j = pi;
		
		boolean found = false;
		while(true) {

			if( i == j || i >= arr.length || j > arr.length)
				break;
			
			int total = arr[i] + arr[j];
			
			if(total < x) {
				i = (i == arr.length - 1 && j != 0) ? 0 : i + 1; 
			}
			else if(total > x) {
				j = (j == 0 && i != arr.length - 1) ? arr.length - 1 : j - 1;
			}
			else {
				found = true;
				break;
			}
		}
		
		System.out.println(found ? (arr[i] + " + " + arr[j] + " = " + x) : "No pair found");
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3, 6, 7, 9, 12, 15, 18, 20, 45};
		
		int x = 19;
		
		isPairExists(arr, x);
	}
}

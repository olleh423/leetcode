package problems;

public class ImportantReversePair {

	//Important Reverse Pair(i, j) is where i < j && arr[i] > 2*(arr[j])
	public static int countIRPs(int[] arr) {
		
		int count = 0;		
		for(int i=0 ; i<arr.length ; i++) {			
			for(int j=i+1 ; j<arr.length ; j++) {	
				int value = 2*(arr[j]);
				if(value > 0 && arr[i] > value) count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {-5, -5};
		System.out.println(countIRPs(arr));
	}
}

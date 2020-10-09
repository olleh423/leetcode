package problems;

public class RemoveDuplicates2 {

	public static void main(String[] args) {
		
		int[] arr = {1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};
		
		int n = removeDuplicates(arr);
		
		for(int i=0 ; i<n ; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	public static int removeDuplicates(int[] arr) {
		
		if(arr == null)
			return 0;
		
		int n = arr.length;
		
		if(n <= 2)
			return n;
		
		int left = 2;
		for(int right = 2 ; right < n ; right++) {
			
			if(arr[left - 2] != arr[right])
				arr[left++] = arr[right];
		}
		
		return left;
	}
}

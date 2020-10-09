package problems;

/*
 * 
 */

public class FlipKZeroToMaximizeOnes {

	public static int maxLengthOfOnesAfterKFlip(int[] arr, int k) {
		
		int wl = 0, wr = 0, zero = 0, bestL = 0, bestWindow = 0;
		
		while(wr < arr.length) {
			
			if(zero <= k) {
				
				if(arr[wr] == 0)
					zero++;
				wr++;
			}
			
			if(zero > k) {
				
				if(arr[wl] == 0)
					zero--;
				wl++;
			}
			
			if((wr - wl > bestWindow) && zero <= k) {
				bestWindow = wr - wl;
				bestL = wl;
			}
		}
		
		return bestWindow;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1};
		int k = 2;
		
		System.out.println(maxLengthOfOnesAfterKFlip(arr, k));
	}
}

package problems;

public class MaxLengthSubArrayDivision {

	public static void main(String[] args) {
		
		int N = 7;
		int D = 5;
		int[] arr = {3, 4, 7, 2, 1, 6, 2};
		
		System.out.println(Solution(N, D, arr));
	}
	
	private static int[] getLeftSum(int[] arr, int n) {
		
		int[] left = new int[n+1];
		left[0] = 0;
		for(int i=1 ; i<=n ; i++) {
			left[i] = left[i-1] + arr[i-1];
		}
		return left;
	}
	
	private static int[] getRightSum(int[] arr, int n) {
		
		int[] right = new int[n+1];
		right[n] = 0;
		for(int i=n-1 ; i>=0 ; i--) {
			right[i] = arr[i] + right[i+1];
		}
		return right;
	}
	
	private static int getTotal(int[] arr, int n) {
		int total = 0;
		for(int i=0 ; i<n ; i++)
			total += arr[i];
		return total;
	}
	
	public static int Solution(int N, int D, int[] arr){
        
        if(arr == null || arr.length == 0 || D == 0)
            return -1;

        int left = 0, right = 0;
        int totalSum = getTotal(arr, N);
        int[] leftSum = getLeftSum(arr, N);
        int[] rightSum = getRightSum(arr, N);
        
        for(int i=0 ; i<N ; i++) {

            for(int j=i ; j<N ; j++) {

                int subArraySum = totalSum - (leftSum[i] + rightSum[j+1]);
                if(subArraySum % D == 0) {
                    left = i;
                    right = j;
                }
            }
        }

        return left == -1 && right == -1 ? -1 : right - left + 1;
    }
}

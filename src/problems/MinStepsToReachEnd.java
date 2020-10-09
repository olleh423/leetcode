package problems;

public class MinStepsToReachEnd {

	public static int getMinSteps(int[] arr) {
		
		if(arr.length == 0 || arr[0] == 0) return -1;
		
		int[] dp = new int[arr.length];
		for(int i=1 ; i<arr.length ; i++) {
			
			for(int j=0 ; j<i ; j++) {
				
				if(j + arr[j] >= i) {
					if(1+dp[j] < dp[i] || dp[i] == 0) {
						dp[i] = 1+dp[j];
					}
				}
			}
		}
		for(int a : dp) System.out.print(a + " ");
		System.out.println();
		return dp[dp.length-1];
	}
	
	public static void main(String[] args) {
	
		int[] arr = {2, 3, 1, 1, 4};
		System.out.println("Min steps to reach end " + getMinSteps(arr));
	}
}

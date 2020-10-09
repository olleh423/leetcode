package problems;

/*
 * Solution is to verify that is it possible to reach end from starting index of array.
 * Given array contains maximum number of jumps can be made to move forward. 
 */
public class JumpGameArray {
	
	//Dynamic Programming
	private static boolean isPossibleOptimal(int i, int v, int[] arr, int[] DP) {
		
		if(i == arr.length-1) return true;
		if(v == 0) return false;
		if(DP[i] != -1) return DP[i] == 1;
		
		for(int k=1 ; k<=v ; k++) {
			DP[i] = isPossibleOptimal(i+k, arr[i+k], arr, DP) ? 1 : 0;
			if(DP[i] == 1) return true;
		}
		return false;
	}
	
	//Recursive brute force (backtracking)
	private static boolean isPossible(int i, int v, int[] arr) {
		
		if(i >= arr.length-1) return true;
		if(v == 0) return false;
		for(int k=1 ; k<=v ; k++) {
			if(isPossible(i+k, arr[i+k], arr))
				return true;
		}
		return false;
	}
	
	public static boolean isPossible(int[] arr) {
		
		if(arr.length == 0) return false;		
		return isPossible(0, arr[0], arr);
	}
	
	public static boolean isPossibleOptimal(int[] arr) {
		if(arr.length == 0) return false;
		int[] DP = new int[arr.length];
		for(int i=0 ; i<DP.length ; i++) DP[i] = -1;
		return isPossibleOptimal(0, arr[0], arr, DP);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 0, 2, 1, 0, 4};
		System.out.println(isPossible(arr) ? "Possible" : "Not Possible");
	}
}

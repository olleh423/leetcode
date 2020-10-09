package problems;

public class SubsetSumMinDifference {

	private static class Diff {
		int d = Integer.MAX_VALUE;
	}
	
	private static void minDiffSubsets(int[] arr, int idx, Diff diff, int t1, int t2) {
	
		if(idx == arr.length)
			return;
		
		diff.d = Math.min(diff.d, Math.abs(t1 - t2));
		minDiffSubsets(arr, idx+1, diff, t1+arr[idx], t2-arr[idx]);
		minDiffSubsets(arr, idx+1, diff, t1, t2);
	}
	
	public static int minDiffSubsetsDP(int[] arr) {
		
		if(arr == null)
			return 0;
		
		int total = 0;
		for(int i=0 ; i<arr.length ; i++)
			total += arr[i];
		
		int n = arr.length;
		int target = total / 2;
		boolean[][] table = new boolean[n+1][target+1];
		for(int i=0 ; i<table.length ; i++) {
			for(int j=0 ; j<table[i].length ; j++) {
				if(j == 0)
					table[i][j] = true;
				else if(i == 0)
					table[i][j] = false;
				else
					table[i][j] = j < arr[i-1] ? table[i-1][j] : table[i-1][j - arr[i-1]];
			}
		}
		
		boolean[] last = table[n];
		return 0;
	}

	public static int minDiffSubsets(int[] arr) {
		
		if(arr == null)
			return 0;
		
		int total = 0;
		for(int i=0 ; i<arr.length ; i++)
			total += arr[i];
		
		Diff diff = new Diff();
		minDiffSubsets(arr, 0, diff, 0, total);
		return diff.d;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {36, 7, 46, 40};
		System.out.println(minDiffSubsets(arr));
		System.out.println(minDiffSubsetsDP(new int[] {1, 2, 7}));
	}
}

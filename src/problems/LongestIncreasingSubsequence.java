package problems;

import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSubsequence {
	
	public static void lcs(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return;
		
		int[] len = new int[arr.length];
		int[] res = new int[arr.length];
		
		Arrays.fill(len, 1);
		Arrays.fill(res, -1);
		
		for(int i=1 ; i<arr.length ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(arr[j] < arr[i] && len[j] + 1 >= len[i]) {
					len[i] = len[j] + 1;
					res[i] = j;
				}
			}
		}
		
		int maxIndex = Integer.MIN_VALUE;
		for(int i=0 ; i<res.length ; i++) {
			maxIndex = maxIndex <= res[i] ? i : maxIndex;
		}
		
		Stack<Integer> stack = new Stack<>();
		while(maxIndex != -1) {
			stack.push(arr[maxIndex]);
			maxIndex = res[maxIndex];
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
	}

	public static void main(String[] args) {
		
		//int[] arr = {4, 1, 6, 3, 8, 5, 3, 7};
		int[] arr = {29, 2, 20, 12, 30, 31};
		lcs(arr);
	}
}

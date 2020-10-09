package problems;

import java.util.Arrays;
import java.util.Collections;

/*
 * https://leetcode.com/problems/max-consecutive-ones-iii/submissions/s
 */

public class MaxConsecutiveOnesSlidingWindow {

	private static int solve(int[] arr, int k) {
		
		if(arr == null)
            return 0;
        
        int max = Integer.MIN_VALUE;
        int i=0, j=0;
        while(j < arr.length) {
            
            if(arr[j] == 0) {
                k--;
            }
            
            if(k == 0) {
                max = Math.max(max, j-i-1);
                while(true) {
                	if(arr[i] == 0) {
                		k = 1; i++;	
                		break;
                	}
                	i++;
                }
            }
            j++;
        }
        
        return max;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		
		System.out.println(solve(arr, k));
	}
}

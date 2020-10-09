package problems;

import java.util.Arrays;

public class PythagoreanTriplet {

	/*
	 * Given an array of integers, write a function that returns true 
	 * if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
	 * 
	 * NOTE : size(arr) >= 3
	 * 
	 */
	
	private static int square(int a) {
		
		return (int) Math.pow(a, 2);
	}

	/*
	 * O(n^3)
	 */
	public static boolean hasTriplet(int[] arr) {
		
		for(int i=0 ; i<arr.length ; i++) {
		
			for(int j=0 ; j<arr.length ; j++) {
				
				if(j != i) {
					
					for(int k=0 ; k<arr.length ; k++) {
						
						if(k != i && k != j) {
							
							if(square(arr[i]) == square(arr[j]) + square(arr[k])) {
								System.out.println(arr[i] + "^2 = " + arr[j] + "^2 + " + arr[k] + "^2");
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	/*
	 * O(n^2)
	 */
	public static boolean hasTripletOpt(int[] arr) {
		
		//O(nLogN)
		Arrays.sort(arr);
		
		//O(n^2)
		for(int i=arr.length-1 ; i>1; i--) {
			
			int j=0, k=i-1;
			
			while(j < k) {
				
				int a = square(arr[i]);
				int b = square(arr[j]);
				int c = square(arr[k]);
				
				if(a == b + c) {
					System.out.println(arr[i] + "^2 = " + arr[j] + "^2 + " + arr[k] + "^2");
					return true;
				}
				
				if(a > b + c)
					j++;
				else
					k--;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3, 1, 4, 6, 5, 6};
		
		System.out.println(hasTripletOpt(arr));
	}
}

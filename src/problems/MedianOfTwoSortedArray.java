package problems;

/*
 * Median of two sorted arrays of equal length
 * 
 * arr1 = [1, 2, 3]		arr2 = [4, 5, 6]	median = (3+4)/2 = 3.5
 * arr1 = [1, 3, 5]		arr2 = [2, 4, 6]	median = (3+4)/2 = 3.5
 * arr1 = [5, 6, 9]		arr2 = [1, 2, 8]	median = (6+5)/2 = 5.5
 * 
 */

public class MedianOfTwoSortedArray {

	/*
	 * Median of two sorted arrays with different size
	 */
	public float findMedian(int[] A, int[] B) {
		
		if(A == null || B == null)
			return -1;
		
		if(A.length > B.length)
			return findMedian(B, A);
		
		int start = 0;
		int end = A.length;
		
		int n = A.length;
		int m = B.length;
		
		while(start <= end) {
			
			int cut1 = (start + end) / 2;
			int cut2 = (n + m + 1) / 2 - cut1;
			
			int x1 = cut1 == 0 ? Integer.MIN_VALUE : A[cut1 - 1];
			int x2 = cut1 == n ? Integer.MAX_VALUE : A[cut1];
			
			int y1 = cut2 == 0 ? Integer.MIN_VALUE : B[cut2 - 1];
			int y2 = cut2 == m ? Integer.MAX_VALUE : B[cut2];
			
			if(x1 <= y2 && y1 <= x2) {
				
				if((m + n) % 2 == 0)
					return (float) (Math.max(x1, y1) + Math.min(x2, y2)) / 2;
				else
					return Math.max(x1, y1);
			}
			
			if(x1 > y2)
				end = cut1 - 1;
			else
				start = cut1 + 1;
		}
		
		return -1;
	}
	
	/*
	 * Median of two sorted arrays with same size
	 */
	public float findMedian(int[] A, int[] B, int s1, int e1, int s2, int e2) {
		
		if(A == null || B == null)
			return -1;
		
		if(s1 == e1 && s2 == e2)
			return (float) (A[s1] + B[s2]) / 2;
		
		if(s1 + 1 == e1 && s2 + 1 == e2)
			return (float) (Math.max(A[s1], B[s2]) + Math.min(A[e1], B[e2])) / 2;
		
		int mid1 = (s1 + e1) / 2;
		int mid2 = (s2 + e2) / 2;
		
		if(A[mid1] == B[mid2])
			return (A[mid1] + B[mid2]) / 2;
		
		return A[mid1] < B[mid2] ? findMedian(A, B, mid1, e1, s2, mid2) : findMedian(A, B, s1, mid1, mid2, e2);
	}
	
	public static void main(String[] args) {
		
		int[] A = {1, 12, 15, 26, 38, 50};
		int[] B = {2, 13, 17};
		int n = 5;
		
		int[] C = {1, 2, 3, 4, 5, 6};
		int[] D = {1, 2, 3, 4, 5, 6};
		int m = 6;
		
		MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
		
		//same size
		float median = obj.findMedian(C, D, 0, m-1, 0, m-1);
		System.out.println("Median is : " + median);
		
		// different size
		//float median = obj.findMedian(A, B);
		//System.out.println("Median is : " + median);
	}
}

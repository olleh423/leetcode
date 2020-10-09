package problems;

public class MaxSumRectangleAdvanceKadane {
	
	private static class Result {
		
		int max, left, right, top, bottom;
		
		Result() {
			this(-1, -1, -1, -1, -1);
		}
		
		Result(int max, int left, int top, int right, int bottom) {
			
			this.max = max;
			this.left = left;
			this.top = top;
			this.right = right;
			this.bottom = bottom;
		}
	}

	/*
	 * Advance Kadane's Algorithm
	 */
	private void solveFast(int[][] grid, int row, int col) {
		
		Result finalResult = new Result();
		
		for(int left = 0 ; left < col ; left++) {
			
			int[] arr = new int[row];
			for(int right = left ; right < col ; right++) {
				
				for(int i=0 ; i<row ; i++)
					arr[i] += grid[i][right];
				
				Result result = performKadanes(arr);
				
				if(finalResult.max < result.max) {
					result.left = left;
					result.right = right;
					finalResult = result;
				}
			}
		}
		
		System.out.println("Max sum is : " + finalResult.max);
		System.out.println("Top-Left : [" + finalResult.top + ", " + finalResult.left + "]");
		System.out.println("Bottom-Right : [" + finalResult.bottom + ", " + finalResult.right + "]");
	}
	
	private Result performKadanes(int[] arr) {
		
		Result res = new Result();
		
		int maxSoFar = Integer.MIN_VALUE, currentMax = 0, start = 0, end = 0, s = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			
			currentMax += arr[i];
			if(currentMax > maxSoFar) {
				maxSoFar = currentMax;
				start = s;
				end = i;
			}
			if(currentMax < 0) {
				currentMax = 0;
				s = i+1;
			}
		}
		
		res.max = maxSoFar;
		res.top = start;
		res.bottom = end;
		
		return res;
	}
	
	/*
	 * Brute force
	 */
	private void solve(int[][] arr, int row, int col) {

		int max = Integer.MIN_VALUE;
		int top, left, bottom, right;
		top = left = bottom = right = -1;
		
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				for(int k=i ; k<row ; k++) {
					for(int l=j ; l<col ; l++) {
						int sum = 0;
						for(int a=i ; a<=k ; a++) {
							for(int b=j ; b<=l ; b++)
								sum += arr[a][b];
						}
						if(max < sum) {
							max = sum;
							top = i; left = j ; bottom = k ; right = l;
						}
					}
				}
			}
		}
		
		System.out.println("Max sum is : " + max);
		System.out.println("Top-Left : [" + top + ", " + left + "]");
		System.out.println("Bottom-Right : [" + bottom + ", " + right + "]");
	}
	
	public void maxSumRectangle(int[][] arr, int row, int col) {
		
		solve(arr, row, col);
		System.out.println();
		solveFast(arr, row, col);
	}
	
	public static void main(String[] args) {
		
		int[][] arr = { {1, 2, -1, -4, -20},
						{-8, -3, 4, 2, 1},
						{3, 8, 10, 1, 3},
						{-4, -1, 1, 7, -6}};
		
		int row = 4;
		int col = 5;
		
		MaxSumRectangleAdvanceKadane obj = new MaxSumRectangleAdvanceKadane();
		
		obj.maxSumRectangle(arr, row, col);
	}
}

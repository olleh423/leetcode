package problems;

public class DigonalMatrixTraversal {

	private int[][] arr;
	private int row;
	private int col;
	
	public DigonalMatrixTraversal(int[][] arr, int n) {
		
		this.arr = arr;
		this.row = n;
		this.col = n;
	}
	
	private void printFirstHalf(int x, boolean isUpward) {
		
		if(isUpward) {
			int i = 0, j = x;
			do {
				System.out.print(arr[i][j] + " ");
				i++; j--;
			} while(j >= 0);
		} else {
			int i = x, j = 0;
			do {
				System.out.print(arr[i][j] + " ");
				i--; j++;
			} while(i >= 0);
		}
	}
	
	private void printSecondHalf(int x, boolean isUpward) {
		
		if(isUpward) {
			int i = x, j = col - 1;
			do {
				System.out.print(arr[i][j] + " ");
				i++; j--;
			} while(i < row);
		} else {
			int i = row - 1, j = x;
			do {
				System.out.print(arr[i][j] + " ");
				i--; j++;
			} while(j < col);
		}
	}
	
	public void traverseDiagonal() {
		
		boolean isUpward = true;
		
		for(int j=0 ; j<col ; j++) {
			printFirstHalf(j, isUpward);
			isUpward = !isUpward;
		}
		for(int i=1 ; i<row ; i++) {
			printSecondHalf(i, isUpward);
			isUpward = !isUpward;
		}
	}
	
	public static void main(String[] args) {
		
		int[][] arr = { {1, 2, 3, 4, 1}, 
						{5, 6, 7, 8, 6}, 
						{9, 1, 2, 3, 3}, 
						{4, 5, 6, 7, 8},
						{8, 6, 1, 2, 4} };

		int n = arr.length;
		
		DigonalMatrixTraversal obj = new DigonalMatrixTraversal(arr, n);
		
		obj.traverseDiagonal();
	}
}

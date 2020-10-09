package problems;

public class TransposeOfSquareMatrix {

	public static void transpose(int[][] arr) {
		
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=i ; j<arr.length ; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
	
	private static void show(int[][] arr) {
		
		for(int[] a : arr) {
			for(int b : a)
				System.out.print(b + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[][] arr = { {1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 1, 2, 3},
						{4, 5, 6, 7} };
		
		show(arr);
		transpose(arr);
		show(arr);
	}
}

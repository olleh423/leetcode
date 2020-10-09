package problems;

public class SpiralMatrix {

	public static void printSpiral(int[][] arr, int row, int col) {
		
		int T = 0, B = row-1, L = 0, R = col-1;
		int MOVE = 0;
		
		while(T <= B && L <= R) {
			
			switch(MOVE) {
			
				case 0 : {
					
					for(int i=L; i<=R ; i++) 
						System.out.print(arr[T][i] + " ");
					T++;
					break;
				}
				case 1 : {
					
					for(int i=T; i<=B ; i++) 
						System.out.print(arr[i][R] + " ");
					R--;
					break;
				}
				case 2 : {
					
					for(int i=R; i>=L ; i--) 
						System.out.print(arr[B][i] + " ");
					B--;
					break;
				}
				case 3 : {
					
					for(int i=B; i>=T ; i--) 
						System.out.print(arr[i][L] + " ");
					L++;
					break;
				}
			}
			MOVE = (MOVE + 1)%4;
		}
	}
	
	public static void main(String... args) {
		
		int row = 3, col = 2;
		
		int [][] arr = {{1, 2},
						{3, 4},
						{5, 6}};
		
		for(int[] r : arr) {
			for(int c : r) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
		System.out.println("\nSpriral Traversing Order : \n");
		printSpiral(arr, row, col);
	}
}

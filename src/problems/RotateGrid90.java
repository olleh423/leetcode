package problems;

public class RotateGrid90 {
	
	public void rotate(int[][] M) {
		
		int last = M.length - 1;
		int totalLevels = M.length / 2;
		int level = 0;
		
		while(level < totalLevels) {
			
			for(int i=level ; i<last ; i++) {
				
				swap(M, level, i, i, last);
				swap(M, level, i, last, last-i+level);
				swap(M, level, i, last-i+level, level);
			}
			
			level++;
			last--;
		}
	}
	
	private void swap(int[][] grid, int si, int sj, int di, int dj) {
		
		int temp = grid[si][sj];
		grid[si][sj] = grid[di][dj];
		grid[di][dj] = temp;
	}
	
	private void show(int[][] grid) {
		
		for(int[] a : grid) {
			for(int b : a)
				System.out.print(b + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int[][] M1 = {{1, 2},
				  	  {3, 4}};
	
		int[][] M2 = {{1, 2, 3},
				  	  {4, 5, 6},
				  	  {7, 8, 9}};
		
		int[][] M3 = {{1, 2, 3, 4},
				  	  {5, 6, 7, 8},
				  	  {9, 1, 2, 3},
				  	  {4, 5, 6, 7}};
		
		RotateGrid90 obj = new RotateGrid90();
		
		System.out.println("Actual Grid : \n");
		obj.show(M2);
		obj.rotate(M2);
		System.out.println("\nAfter 180D rotation : \n");
		obj.show(M2);
	}
}

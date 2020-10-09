package problems;

public class RotateGrid180 {

	public void rotate(int[][] M) {
		
		//reverse rows
		for(int i=0 ; i<M.length ; i++) {
			
			int head = 0, tail = M[i].length - 1;
			while(head < tail) {
				
				M[i][head] = M[i][head] ^ M[i][tail];
				M[i][tail] = M[i][head] ^ M[i][tail];
				M[i][head] = M[i][head] ^ M[i][tail];
				
				head++;
				tail--;
			}
		}
		
		//reverse columns
		for(int i=0 ; i<M.length ; i++) {
			
			int head = 0, tail = M[i].length - 1;
			while(head < tail) {
				
				M[head][i] = M[head][i] ^ M[tail][i];
				M[tail][i] = M[head][i] ^ M[tail][i];
				M[head][i] = M[head][i] ^ M[tail][i];
				
				head++;
				tail--;
			}
		}
	}
	
	public void show(int[][] grid) {
		
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
		
		RotateGrid180 obj = new RotateGrid180();
		
		System.out.println("Actual Grid : \n");
		obj.show(M3);
		obj.rotate(M3);
		System.out.println("\nAfter 180D rotation : \n");
		obj.show(M3);
	}
}

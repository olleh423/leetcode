package problems;

import java.util.ArrayList;

public class SpiralMatrixPart2 {
	
	//output as list
	public static ArrayList<ArrayList<Integer>> getSpiral(int n) {
		
		ArrayList<ArrayList<Integer>> spiralList = new ArrayList<>(n);
		int[][] spiral = new int[n][n];
		int top = 0, bottom = n-1, left = 0, right = n-1;
		int move = 0;
		
		int count = 1;
		while(count <= (n*n)) {
			
			if(move == 0) {
				
				for(int i=left ; i<=right ; i++) {
					spiral[top][i] = count;
					count++;
				}
				top++;
				
			} else if(move == 1) {
				
				for(int i=top ; i<=bottom ; i++) {
					spiral[i][right] = count;
					count++;
				}
				right--;
				
			} else if(move == 2) {
				
				for(int i=right ; i>=left ; i--) {
					spiral[bottom][i] = count;
					count++;
				}
				bottom--;
				
			} else {
				
				for(int i=bottom; i>=top ; i--) {
					spiral[i][left] = count;
					count++;
				}
				left++;				
			}
			
			move = (move + 1) % 4;
		}
		
		for(int[] a : spiral) {
			ArrayList<Integer> spList = new ArrayList<Integer>();
			for(int b : a) {
				spList.add(b);
			}
			spiralList.add(spList);
		}
		
		return spiralList;
	}

	public static void main(String[] args) {
		
		int n = 4;
		
		ArrayList<ArrayList<Integer>> spiral = getSpiral(n);
		for(ArrayList<Integer> list : spiral) {
			for(Integer a : list) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}
	}
}

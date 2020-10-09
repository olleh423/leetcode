package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * matrix rotation N x N matrix in place clockwise 
 */

public class SquareMatrixRotation {
	
	
	private static void swap(int si, int sj, int di, int dj, List<List<Integer>> list) {
		
		int temp = list.get(di).get(dj);
		list.get(di).set(dj, list.get(si).get(sj));
		list.get(si).set(sj, temp);
	}
	
	private static void setOperation() {
		
		List<List<Integer>> list = new ArrayList<>();
		
		List<Integer> a = new ArrayList<>();
		a.add(1); a.add(2); a.add(3);
		list.add(a);
		a = new ArrayList<>();
		a.add(4); a.add(5); a.add(6);
		list.add(a);
		a = new ArrayList<>();
		a.add(7); a.add(8); a.add(9);
		list.add(a);
		
		swap(0, 0, 2, 2, list);
		
		for(List<Integer> l : list) {
			for(Integer n : l) {
				System.out.print(n + "  ");
			}
			System.out.println();
		}
	}
	

	private static void printMatrix(int[][] m) {
		
		System.out.println();
		for(int i=0 ; i<m.length ; i++) {
			for(int j=0 ; j<m[i].length ; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println("\n");
		}
		System.out.println();
	}
	
	private static void swap(int si, int sj, int di, int dj, int[][] m) {
		
		m[si][sj] = m[si][sj] ^ m[di][dj];
		m[di][dj] = m[si][sj] ^ m[di][dj];
		m[si][sj] = m[si][sj] ^ m[di][dj];
	}
	
	public static void rotate(int[][] m) {
		
		int size = m.length;
		
		int end = size - 1;
		int totalLevels = size / 2;
		int level = 0;
		
		while(level < totalLevels) {
			
			for(int i=level ; i<end ; i++) {
				
				swap(level, i, i, end, m);
				swap(level, i, end, end-i+level, m);
				swap(level, i, end-i+level, level, m);
			}
			level++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		
		int size = 4;
		int m[][] = new int[size][size];
		
		//create matrix
		int count = 0;
		for(int i=0 ; i<size ; i++) {
			for(int j=0 ; j<size ; j++) {
				m[i][j] = count++;
			}
		}
		
		setOperation();
		
		//System.out.println("Original Matrix : ");
		//printMatrix(m);
		
		//rotate(m);
		
		//System.out.println("Rotated Matrix : ");
		//printMatrix(m);
	}
}

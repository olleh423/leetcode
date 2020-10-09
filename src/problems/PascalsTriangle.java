package problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	/*
	
	[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
    ]
    		
    */
	
	public static void pascalTriangleList(int row) {
		
		List<List<Integer>> data = new ArrayList<>();
		
		for(int i=0 ; i<row ; i++) {
			
			List<Integer> list = new ArrayList<>();
			
			for(int j=0 ; j<=i ; j++) {
				
				if(j == 0 || j == i) {
					list.add(1);
				} else {
					list.add(data.get(i-1).get(j-1) + data.get(i-1).get(j));
				}
			}
			data.add(list);
		}
		
		//show
		for(List<Integer> a : data) {
			for(int b : a) {
				System.out.print(b + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int row = 5;
		
		pascalTriangleList(row);
	}
}



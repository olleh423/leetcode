package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class ZigzagMatrixTraversal {

	public static ArrayList<Integer> zigzagTraverse(ArrayList<ArrayList<Integer>> data) {
    
		ArrayList<Integer> result = new ArrayList<>();
	
		if(data == null || data.size() == 0 || data.get(0).size() == 0)
			return result;
		
		if(data.size() == 1) {
			for(int i=0 ; i<data.size() ; i++) {
				result.add(data.get(0).get(i));
			}
			return result;
		}
		
		if(data.get(0).size() == 1) {
			for(int i=0 ; i<data.size() ; i++) {
				result.add(data.get(i).get(0));
			}
			return result;
		}
	
		int rows = data.size();
		int cols = data.get(0).size();		
		int si = 1, sj = 0, di = 0, dj = 1;
		boolean isUpward = true;
	
		result.add(data.get(0).get(0));
		while(result.size() != (rows * cols) - 1) {
		
			traverse(si, sj, di, dj, isUpward, data, result);
		
			if(si == rows - 1) sj++;
			else si++;
		
			if(dj == cols - 1) di++;
			else dj++;
		
			isUpward = !isUpward;
		}
		result.add(data.get(rows-1).get(cols-1));
		
		return result;
	}
	
	private static void traverse(int si, int sj, int di, int dj, boolean isUpward, ArrayList<ArrayList<Integer>> data, ArrayList<Integer> result) {

		if(isUpward) {
			while(si >= di && sj <= dj) {
				result.add(data.get(si--).get(sj++));
			}
		} else {
			while(di <= si && dj >= sj) {
				result.add(data.get(di++).get(dj--));
			}
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> data = new ArrayList<>();
		
		data.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
		data.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
		data.add(new ArrayList<Integer>(Arrays.asList(5, 7)));
		data.add(new ArrayList<Integer>(Arrays.asList(6, 8)));
		data.add(new ArrayList<Integer>(Arrays.asList(9, 10)));
		
		System.out.println(zigzagTraverse(data));
	}
}

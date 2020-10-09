package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		
		int[][] arr = {{1,4}, {1,3}, {2,9}, {13,15}, {5,12}, {16,17}};
		
		int[][] merged = mergeIntervals(arr);
		for(int[] A : merged)
			System.out.println(Arrays.toString(A));
	}
	
	private static int[][] mergeIntervals(int[][] intervals) {
		
		if(intervals == null) return null;
        
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> results = new ArrayList<>();
        
        int[] arr = {intervals[0][0], intervals[0][1]};
        int i=1;
        
        while(i < intervals.length) {            
            if(intervals[i][0] > arr[1]) {                
                results.add(arr);
                arr = new int[]{intervals[i][0], intervals[i][1]};
            }
            else {                
                arr[1] = Math.max(arr[1], intervals[i][1]);
                i++;
            }
        }
        
        results.add(arr);
        
        int[][] merged = new int[results.size()][results.size()];
        for(int j=0 ; j<results.size() ; j++) {
        	merged[j] = results.get(j);
        }
        
        return merged;
	}
}

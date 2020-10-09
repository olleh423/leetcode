package problems;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<>();
		
		int[] arr = {-1, 0, 1, 2, -1, -4};
		for(int i=0 ; i<arr.length ; i++)
			A.add(arr[i]);
		
		ArrayList<ArrayList<Integer>> result = threeSum(A);
		
		System.out.println(result);
	}

	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        
        if(A == null || A.size() < 3)
            return null;
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            
        Collections.sort(A);
        
        for(int i=A.size() - 1 ; i >= 0 ; i--) {
            
            int target = A.get(i) * (-1);
            int start = 0, end = i-1;
            
            while(start < end) {
                
                int sum = A.get(start) + A.get(end);
                if(sum == target) {
                    
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(A.get(start));
                    triplet.add(A.get(end));
                    triplet.add(A.get(i));
                    result.add(triplet);
                    
                    start++ ; end--;
                }
                else if(sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return result;
    }
}

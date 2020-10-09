package problems;
import java.util.*;

public class LargestTimeForGivenDigits {

	public static void main(String[] args) {
		
		int[] A = {0,2,6,6};
		
		LargestTimeForGivenDigits obj = new LargestTimeForGivenDigits();
		
		obj.largestTime(A);
	}
	
	public void largestTime(int[] A) {
		
		List<List<Integer>> result = new ArrayList<>();
		permute(A, 0, new ArrayList<Integer>(), result);
		System.out.println(result);
	}
	
	private void permute(int[] A, int idx, List<Integer> current, List<List<Integer>> result) {
		
		if(idx == 4) {
			if(current.get(0) <= 2)
				result.add(new ArrayList<>(current));
			return;
		}
		
		for(int i=idx ; i<A.length ; i++) {
			current.add(A[i]);
			permute(A, i+1, current, result);
			current.remove(current.size()-1);
		}
	}
}

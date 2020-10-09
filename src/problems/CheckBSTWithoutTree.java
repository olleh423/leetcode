package problems;

import java.util.Arrays;
import java.util.List;

public class CheckBSTWithoutTree {
	
	private static boolean checkBST(List<Integer> one, List<Integer> two, int oneIndex, int twoIndex, int low, int high) {
		
		int oneNextGreater = one.size();
		for(int i=oneIndex + 1 ; i < one.size() ; i++) {
			if(one.get(oneIndex) < one.get(i) && one.get(i) < high) {
				oneNextGreater = i;
				break;
			}
		}
		
		int oneNextSmaller = one.size();
		for(int i=oneIndex + 1 ; i < one.size() ; i++) {
			if(one.get(oneIndex) > one.get(i) && one.get(i) > low) {
				oneNextSmaller = i;
				break;
			}
		}
		
		int twoNextGreater = two.size();
		for(int i=twoIndex + 1 ; i < two.size() ; i++) {
			if(two.get(twoIndex) < two.get(i) && two.get(i) < high) {
				twoNextGreater = i;
				break;
			}
		}
		
		int twoNextSmaller = two.size();
		for(int i=twoIndex + 1 ; i < two.size() ; i++) {
			if(two.get(twoIndex) > two.get(i) && two.get(i) > low) {
				twoNextSmaller = i;
				break;
			}
		}
		
		if(oneNextGreater == one.size() && twoNextGreater == two.size())
			return true;
		if(oneNextGreater == one.size() || twoNextGreater == two.size() || one.get(oneNextGreater) != two.get(twoNextGreater))
			return false;
		
		if(oneNextSmaller == one.size() && twoNextSmaller == two.size())
			return true;
		if(oneNextSmaller == one.size() || twoNextSmaller == two.size() || one.get(oneNextSmaller) != two.get(twoNextSmaller))
			return false;
		
		boolean greater = checkBST(one, two, oneNextGreater, twoNextGreater, one.get(oneNextGreater), high);
		boolean smaller = checkBST(one, two, oneNextSmaller, twoNextSmaller, low, one.get(oneNextSmaller));
		
		return greater && smaller;
	}

	public static boolean checkBST(List<Integer> arrayOne, List<Integer> arrayTwo) {

		if(arrayOne == null && arrayTwo == null)
			return true;
		if(arrayOne == null || arrayTwo == null || arrayOne.size() != arrayTwo.size() || arrayOne.get(0) != arrayTwo.get(0))
			return false;
		
		return checkBST(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		
		List<Integer> arrayOne = Arrays.asList(10, 8, 94, 12, 81, 5, 2, 5);
		List<Integer> arrayTwo = Arrays.asList(10, 8, 5, 15, 2, 12, 94, 81);
		
		System.out.println(checkBST(arrayOne, arrayTwo));
	}
}

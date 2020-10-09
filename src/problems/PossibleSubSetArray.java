package problems;

public class PossibleSubSetArray {

	private static void showItems(Integer[] arr) {
		
		System.out.print("[ ");
		for(Integer i : arr) {
			if(i != null) {
				System.out.print(i + ", ");
			}
		}
		System.out.println("]");
 	}
	
	private static void printSubSets(int[] arr, Integer[] res, int i) {
		
		if(i == arr.length)
			showItems(res);
		else {
			res[i] = null;
			printSubSets(arr, res, i+1);
			res[i] = arr[i];
			printSubSets(arr, res, i+1);
		}
	}
	
	public static void printSubSets(int[] arr) {
		
		printSubSets(arr, new Integer[arr.length], 0);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3};
		printSubSets(arr);
	}
}

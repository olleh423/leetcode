package problems;

public class NextGreaterElement {
	
	public int[] nextGreaterElement(int[] arr) {
		
		int[] result = new int[arr.length];
		
		
		
		return result;
	}

	public static void main(String[] args) {
		
		int[] arr = {98, 23, 54, 12, 20, 7, 27};
		
		NextGreaterElement nge = new NextGreaterElement();
		
		int[] result = nge.nextGreaterElement(arr);
		
		for(int a : result)
			System.out.print(a + ", ");
	}
}

package problems;

public class ReverseSentance {
	
	public static String reverse(String str) {
		
		String result = "";
		String[] arr = str.split(" ");
		
		for(int i=arr.length-1 ; i>=0 ; i--) {
			result += arr[i] + " ";
		}
		
		return result.trim();
	}
	
	public static void main(String[] args) {
		
		String s = "this is my car";
		
		System.out.println(reverse(s));
	}
}

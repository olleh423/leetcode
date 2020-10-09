package problems;

public class KMPStringMatching {
	
	private static int[] getPITable(String pattern) {
		
		int[] PI = new int[pattern.length()];
		PI[0] = 0;
		
		int i=1, j=0;
		while(i < pattern.length()) {
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				PI[i] = ++j;
				i++;
			} else {
				if(j != 0) {
					j = PI[j-1];
				} else {
					PI[i] = 0;
					i++;
				}
			}
		}
		
		for(int a : PI) 
			System.out.println(a);
		
		return PI;
	}
	
	public static void kmp(String text, String pattern) {
		
		int[] PI = getPITable(pattern);

		boolean found = false;
		int i=0, j=0;
		while(i < text.length()) {
			
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == PI.length-1) {
					found = true;
					System.out.println("Pattern found at index " + (i-j));
					j = 0;
				} else {
					j++;
				}
				i++;
			} else {
				if(j != 0) {
					j = PI[j-1];
				} else {
					i++;
				}
			}
		}
		
		if(!found)
			System.out.println("Pattern not found");
	}
	
	public static void main(String[] args) {
		
		//String text = "abcxababcdabcycdabxabcdabcdabcyabcxababcdabcycdabxabcdabcdabcy";
		//String pat = "abcdabcy";
		String text = "testwafwafawfawfawfawfawfawfawfa";
		String pat = "fawfawfawfawfa";
		
		kmp(text, pat);
	}
}

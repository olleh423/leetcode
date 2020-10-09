package problems;

public class InterleavingStrings {

	// checking C is interleaving string of A and B
	public static boolean isInterleaving(String a, String b, String c) {
		
		int i = a.length()-1, j = b.length()-1;
		
		if(c.length() != (a.length() + b.length())) return false;
		
		for(int k = c.length()-1 ; k >= 0 ; k--) {
			
			if(c.charAt(k) == a.charAt(i)) 
				i--;
			else if(c.charAt(k) == b.charAt(j))
				j--;
			else
				break;
		}
						
		return i == -1 && j == -1;
	}
	
	public static void main(String[] args) {
		
		String a = "ab", b = "cd", c = "acdb";
		System.out.println(isInterleaving(a, b, c));
	}
}

package problems;

public class ExcelColumnNumber {
	
	/*
	 * Given a column title as appears in an Excel sheet, return its corresponding column number and vice versa.
		A -> 1
		B -> 2
		C -> 3
		...
		Z -> 26
		AA -> 27
		AB -> 28 
	 */

	private static int getNumber(String s, int pos) {
		
		if(pos == s.length() - 1) 
			return ((int)s.charAt(pos)) - 64;
		
		int number = s.charAt(pos) - 64;
		return (int) (Math.pow(26, s.length() - (pos + 1)) * number + getNumber(s, pos + 1));
	}
	
	private static String getTitle(int number, int l, String res) {
		
		if(number < 26) return res + String.valueOf((char)(number + 64));
		int pow = (int)Math.pow(26, l - 1);
		int n = (number / pow) + 64;
		if(n == 0) res += "Z";
		return getTitle(number % pow, l - 1, res += ((char)n));
	}
	
	public static int getColumnNumber(String title) {
		
		return getNumber(title, 0);
	}
	
	public static String getColumnTitle(int number) {
		
		return getTitle(number, String.valueOf(number).length(), "");
	}
	
	public static void main(String[] args) {
		
		System.out.println(getColumnNumber("BCD"));
		System.out.println(getColumnTitle(980089));
	}
}

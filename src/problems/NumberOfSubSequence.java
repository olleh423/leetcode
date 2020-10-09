package problems;

public class NumberOfSubSequence {

	/*"QAQ" is a word to denote an expression of crying. Imagine "Q" as eyes with tears and "A" as a mouth.
	Now Diamond has given Bort a string consisting of only uppercase English letters of length n. 
	There is a great number of "QAQ" in the string (Diamond is so cute!).*/
	
	public static int numOfSubSequence(String text, String seq) {
		
		int[][] res = new int[seq.length()][text.length() + 1];
		
		for(int i=1 ; i<res[0].length ; i++) 
			res[0][i] = seq.charAt(0) == text.charAt(i-1) ? res[0][i-1] + 1 : res[0][i-1];
		
		for(int i=1 ; i<res.length ; i++) {
			
			for(int j=0 ; j<res[i].length ; j++) {
				
				if(j == 0) {
					res[i][j] = 0;
				} else {
					res[i][j] = seq.charAt(i) == text.charAt(j-1) ? res[i-1][j-1] + res[i][j-1] : res[i][j-1];
				}
			}
		}
		
		return res[seq.length() - 1][text.length()];
	}
	
	public static void main(String[] args) {
		
		String text = "QAQAQYSYIOIWIN";
		String seq = "QAQ";
		System.out.println(numOfSubSequence(text, seq));
	}
}

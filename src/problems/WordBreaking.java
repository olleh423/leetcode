package problems;

import java.util.HashSet;
import java.util.Set;

public class WordBreaking {
	
	private static Set<String> dictionary;
	
	public WordBreaking() {
		
		dictionary = new HashSet<>();
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("ice");
		dictionary.add("cream");
	}
	
	private boolean isValid(String word, int i, int j) {
		
		return dictionary.contains(word.substring(i, j));
	}
	
	/*
	 * Dynamic programming
	 */
	private boolean solveDynamic(String word, int i, int[] DP) {
		
		if(i == word.length()) 
			return true;
		
		if(DP[i] != -1)
			return DP[i] == 1;
		
		for(int k = i+1 ; k <= word.length() ; k++) {
			
			if(isValid(word, i, k) && solveDynamic(word, k, DP)) {
				DP[i] = 1;
				return true;
			}
		}
		
		DP[i] = 0;
		return false;
	}
	
	/*
	 * brute force
	 */
	private boolean solve(String word, int i) {
		
		if(i == word.length())
			return true;
		
		for(int k = i+1; k <= word.length() ; k++) {
			
			if(isValid(word, i, k) && solve(word, k))
				return true;
		}
		
		return false;
	}
	
	public boolean wordBreak(String word) {
		
		int[] DP = new int[word.length()];
		for(int i=0 ; i<DP.length ; i++) 
			DP[i] = -1;
		
		//boolean result = solve(word, 0);
		boolean result = solveDynamic(word, 0, DP);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String one = "ilikesamsung"; 
	    String two = "iiiiiiii";
	    String three = "";
	    String four = "ilikelikeimangoiiiilikelikeimangoiii";
	    String five = "samsungandmango";
	    String six = "samsungandmangok";
	    
	    WordBreaking wb = new WordBreaking();
	    
	    System.out.println(one + " : " + wb.wordBreak(one));
	    System.out.println(two + " : " + wb.wordBreak(two));
	    System.out.println(three + " : " + wb.wordBreak(three));
	   	System.out.println(four + " : " + wb.wordBreak(four));
	    System.out.println(five + " : " + wb.wordBreak(five));
	    System.out.println(six + " : " + wb.wordBreak(six));
	}
}

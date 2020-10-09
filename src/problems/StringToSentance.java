package problems;

import java.util.Set;
import java.util.HashSet;

public class StringToSentance {
	
	private Set<String> dict;
	
	public StringToSentance() {

		dict = new HashSet<>();
		dict.add("this");
		dict.add("is");
		dict.add("my");
		dict.add("car");
	}
	
	/*
	 * Optimized solution with Dynamic Programming return 0 or 1 (false or true).
	 */
	private int isSentanceDP(String str, int n, int i, int j, int[][] res) {
		
		if(dict.contains(str)) 
			return 1;
		if(n == 1)
			return 0;
		
		if(res[i][i] != -1)
			return res[i][j];
		
		for(int k=0 ; k<n ; k++) {
			if(dict.contains(str.substring(0, k)) && isSentance(str.substring(k, n))) {
				res[i][j] = 1;
				return 1;
			}
		}
		res[i][j] = 0;
		return 0;
	}
	
	/*
	 * Brute force
	 */
	private boolean isSentance(String str, int n) {
		
		if(dict.contains(str)) 
			return true;
		if(n == 1)
			return false;
		
		for(int i=0 ; i<n ; i++) {
			if(dict.contains(str.substring(0, i)) && isSentance(str.substring(i, n)))
				return true;
		}
		return false;
	}
	
	public boolean isSentance(String str) {
		
		//return isSentance(str, str.length());
		
		int[][] res = new int[str.length()+1][str.length()];
		for(int i=0 ; i<res.length ; i++) 
			for(int j=0 ; j<res[i].length ; j++)
				res[i][j] = -1;
		
		return isSentanceDP(str, str.length(), 0, 0, res) == 1;
	}

	public static void main(String[] args) {
		
		String str = "thisismycar";
		
		StringToSentance sts = new StringToSentance();
		
		System.out.println(sts.isSentance(str));
	}
}

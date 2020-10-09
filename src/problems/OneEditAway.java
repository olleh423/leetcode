package problems;

/*
 * 			CRACING THE CODING INTERVIEW 	Page#148
 * 
 * 	There are three types of edits that can be performed on strings: insert a character, remove a character, replace a character
 * 	Given two strings, write a function to check if they are one edit away.
 * 
 * 	EXAMPLE
 * 
 * 	pale	->	ple			=>	true
 * 	pales	->	pale		=>	true
 * 	pale	->	bale		=>	true
 * 	pale	->	bae			=>	false
 * 
 */

public class OneEditAway {
	
	private boolean oneReplace(String s1, String s2) {
		
		boolean oneReplace = false;
		for(int i=0 ; i<s1.length() ; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(oneReplace)
					return false;
				oneReplace = true;
			}
		}
		
		return true;
	}
	
	private boolean oneInsert(String s1, String s2) {
		
		int i = 0, j = 0;
		while(i < s1.length() && j < s2.length()) {
			
			if(s1.charAt(i) != s2.charAt(j)) {
				if(i != j)
					return false;
				i++;
			} else {
				i++ ; j++;
			}
		}
		
		return true;
	}
	
	public boolean checkOneEditAway(String s1, String s2) {
		
		if(s1 == null || s2 == null)
			return false;
		
		if(s1.length() == s2.length())
			return oneReplace(s1, s2);
		else if(s1.length() + 1 == s2.length())
			return oneInsert(s2, s1);
		else if(s1.length() - 1 == s2.length())
			return oneInsert(s1, s2);
		else
			return false;
	}

	public static void main(String[] args) {
		
		String s1 = "apple";
		String s2 = "appe";
		
		OneEditAway obj = new OneEditAway();
		
		System.out.println(obj.checkOneEditAway(s1, s2));
	}
}

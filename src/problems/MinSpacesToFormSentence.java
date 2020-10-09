package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinSpacesToFormSentence {
	
	private static int breakNumbers(Set<String> numbers, String pi, int index) {
		
		if(numbers.contains(pi.substring(index, pi.length())))
			return 0;
		
		int min = Integer.MAX_VALUE;
		for(int i=index ; i<pi.length() ; i++) {
			if(numbers.contains(pi.substring(index, i+1))) {
				int result = breakNumbers(numbers, pi, i+1);
				min = result == Integer.MAX_VALUE ? min : Math.min(min, 1 + result);
			}
		}
		
		return min;
	}
	
	public static int minSpaces(Set<String> numbers, String pi) {
		
		if(pi == null || numbers == null || numbers.size() == 0)
			return -1;
		
		int result = breakNumbers(numbers, pi, 0);
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	public static void main(String[] args) {
		
		Set<String> numbers = new HashSet<>(Arrays.asList("3", "141", "592", "65", "55", "35", "8", "9793", "23846264", "383279"));
        String pi = "3141592653589793238462643383279";
        
        System.out.println(minSpaces(numbers, pi));
	}
}

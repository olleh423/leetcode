package problems;

import java.util.ArrayList;
import java.util.List;

/*
  		Input : "testthis is a testestest", "test"
  		
  		output : "_test_this is a _testestest_";
 */

public class UnderscorifySubstring {
	
	public static String underScorify(String str, String pat) {
		
		if(str == null || pat == null)
			return null;
		
		List<int[]> locations = new ArrayList<>();
		
		int i = 0;
		int index = str.indexOf(pat, i);
		while(index != -1) {
			locations.add(new int[]{index, index + pat.length()});
			i = index + 1;
			index = str.indexOf(pat, i);
		}
		
		if(locations.isEmpty())
			return str;
		
		StringBuilder builder = new StringBuilder(str);
		
		i = locations.size() - 1;
		builder.insert(locations.get(i)[1], '_');
		while(i > 0) {
			if(locations.get(i)[0] > locations.get(i-1)[1]) {
				builder.insert(locations.get(i)[0], '_');
				builder.insert(locations.get(i-1)[1], '_');
			}
			i--;
		}
		builder.insert(locations.get(i)[0], '_');
		
		return builder.toString();
	}

	public static void main(String[] args) {
		
		String str = "aaabaaa"; //"testthis is a testestest";
		String pat = "aa"; //"test";
		
		System.out.println(underScorify(str, pat));
	}
}

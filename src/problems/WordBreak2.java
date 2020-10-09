package problems;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak2 {

	public static void main(String[] args) {
		
		List<String> dict = new ArrayList<>();
		dict.add("this");
		dict.add("thisis");
		dict.add("is");
		dict.add("my");
		dict.add("ismy");
		dict.add("car");
		dict.add("mycar");
		
		String text = "thisismycar";
		
		System.out.println(wordBreak(dict, text));
	}
	
	private static List<String> wordBreak(List<String> dict, String text) {
		
		return solve(text, 0, new HashSet<String>(dict), new HashMap<Integer, List<String>>());
	}
	
	private static List<String> solve(String s, int idx, Set<String> dict, Map<Integer, List<String>> map) {
		
		if(map.containsKey(idx))
			return map.get(idx);
		
		List<String> result = new ArrayList<>();
		
		if(idx == s.length())
			result.add("");
		
		for(int i=idx+1 ; i<=s.length(); i++) {
			String prefix = s.substring(idx, i);
			if(dict.contains(prefix)) {
				List<String> suffixes = solve(s, i, dict, map);
				for(String suffix : suffixes) {
					result.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
				}
			}
		}
		
		map.put(idx, result);
		return result;
	}
}

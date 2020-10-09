package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Leetcode 819
 */

public class MostCommonWords {

	public String mostCommonWord(String paragraph, String[] banned) {
        
        if(paragraph == null || paragraph.length() == 0 || banned == null)
            return null;
        
        Set<String> bannedWords = new HashSet<>();
        for(String ban : banned)
        	bannedWords.add(ban.toLowerCase());
        
        Map<String, Integer> count = new HashMap<>();
        for(String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
        	if(!bannedWords.contains(word))
        		count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        String result = "";
        for(String key : count.keySet()) {
        	if(result.equals("") || count.get(key) > count.get(result))
        		result = key;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		MostCommonWords obj = new MostCommonWords();
		
		String result = obj.mostCommonWord(paragraph, banned);
		System.out.println(result);
	}
}

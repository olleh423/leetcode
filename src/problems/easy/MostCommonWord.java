package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class MostCommonWord {

    public static void main(String[] args) {

        MostCommonWord obj = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(obj.mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        if(paragraph == null || paragraph.length() == 0 || banned == null)
            return null;

        Set<String> bannedWords = new HashSet<>();
        for(String word : banned)
            bannedWords.add(word);

        Map<String, Integer> count = new HashMap<>();

        for(String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
            if(!bannedWords.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        for(String key : count.keySet()) {
            if(result.equals("") || count.get(key) > count.get(result)) {
                result = key;
            }
        }

        return result;
    }
}

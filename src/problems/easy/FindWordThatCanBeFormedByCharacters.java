package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FindWordThatCanBeFormedByCharacters {

    public static void main(String[] args) {

        FindWordThatCanBeFormedByCharacters obj = new FindWordThatCanBeFormedByCharacters();
    }

    public int countCharacters(String[] words, String chars) {

        if(words == null || chars == null) return 0;

        Map<Character, Integer> charMap = getFrequencyMap(chars);
        int res = 0;

        for(String s : words) {
            boolean isValid = true;
            Map<Character, Integer> freq = getFrequencyMap(s);
            for(char key : freq.keySet()) {
                if(freq.get(key) > charMap.getOrDefault(key, 0)) {
                    isValid = false;
                    break;
                }
            }

            res += isValid ? s.length() : 0;
        }

        return res;
    }

    private Map<Character, Integer> getFrequencyMap(String str) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0 ; i<str.length() ; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map;
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class LetterCombinationOfAPhoneNumber {

    public static void main(String[] args) {

        LetterCombinationOfAPhoneNumber obj = new LetterCombinationOfAPhoneNumber();
    }

    public List<String> letterCombinations(String digits) {

        List<String> results = new ArrayList<>();

        if(digits == null || digits.isEmpty())
            return results;

        Map<Integer, List<Character>> mappings = new HashMap<>();

        mappings.put(2, Arrays.asList('a', 'b', 'c'));
        mappings.put(3, Arrays.asList('d', 'e', 'f'));
        mappings.put(4, Arrays.asList('g', 'h', 'i'));
        mappings.put(5, Arrays.asList('j', 'k', 'l'));
        mappings.put(6, Arrays.asList('m', 'n', 'o'));
        mappings.put(7, Arrays.asList('p', 'q', 'r', 's'));
        mappings.put(8, Arrays.asList('t', 'u', 'v'));
        mappings.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        solve(digits, 0, mappings, "", results);

        return results;
    }

    private void solve(String digits, int index, Map<Integer, List<Character>> mappings, String str, List<String> results) {

        if(index == digits.length()) {
            results.add(str);
            return;
        }

        int digit = digits.charAt(index) - '0';
        List<Character> chars = mappings.get(digit);

        for(char ch : chars) {

            solve(digits, index + 1, mappings, str + ch, results);
        }
    }
}

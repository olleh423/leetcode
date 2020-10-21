package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {

        LetterCombinationsOfPhoneNumber obj = new LetterCombinationsOfPhoneNumber();
        String digits = "123";
        System.out.println(obj.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        solve(0, digits, result, new StringBuilder());
        return result;
    }

    public void solve(int idx, String str, List<String> result, StringBuilder sb) {

        if(idx == str.length()) {
            result.add(sb.toString());
            return;
        }

        char ch = str.charAt(idx);
        List<Character> chars = getChars(ch);
        for(int i=0 ; i<chars.size() ; i++) {
            sb.append(chars.get(i));
            solve(idx+1, str, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<Character> getChars(char ch) {

        List<Character> chars = null;

        switch(ch) {

            case '2' : chars = Arrays.asList('a', 'b', 'c'); break;
            case '3' : chars = Arrays.asList('d', 'e', 'f'); break;
            case '4' : chars = Arrays.asList('g', 'h', 'i'); break;
            case '5' : chars = Arrays.asList('j', 'k', 'l'); break;
            case '6' : chars = Arrays.asList('m', 'n', 'o'); break;
            case '7' : chars = Arrays.asList('p', 'q', 'r', 's'); break;
            case '8' : chars = Arrays.asList('t', 'u', 'v'); break;
            case '9' : chars = Arrays.asList('w', 'x', 'y', 'z'); break;
        }
        return chars;
    }
}

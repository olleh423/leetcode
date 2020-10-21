package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class LetterCasePermutation {

    public static void main(String[] args) {

        LetterCasePermutation obj = new LetterCasePermutation();
        String S = "a1b2";
        System.out.println(obj.letterCasePermutation(S));
    }

    public List<String> letterCasePermutation(String S) {

        List<String> results = new ArrayList<>();
        if(S == null) return results;
        permute(S, 0, new StringBuilder(""), results);
        return results;
    }

    private boolean isUpperCase(char ch) {
        int ascii = (int) ch;
        return ch >= 65 && ch <= 90;
    }

    public void permute(String str, int idx, StringBuilder current, List<String> results) {

        if(idx == str.length()) {
            results.add(current.toString());
            return;
        }

        char ch = str.charAt(idx);
        if(! Character.isDigit(ch)) {
            current.append(ch);
            permute(str, idx + 1, current, results);
            current.deleteCharAt(idx);

            if(isUpperCase(ch)) {
                char lower = (char)(((int) ch) + 32);
                current.append(lower);
                permute(str, idx + 1, current, results);
            }
            else {
                char lower = (char)(((int) ch) - 32);
                current.append(lower);
                permute(str, idx + 1, current, results);
            }
            current.deleteCharAt(idx);
        }
        else {
            current.append(ch);
            permute(str, idx + 1, current, results);
            current.deleteCharAt(idx);
        }
    }
}

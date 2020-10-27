package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class GoatLatin {

    public static void main(String[] args) {

        GoatLatin obj = new GoatLatin();

        String str = "I speak Goat Latin";
        System.out.println(obj.toGoatLatin(str));
    }

    public String toGoatLatin(String str) {

        if(str == null || str.isEmpty())
            return "";

        StringBuilder result = new StringBuilder();
        StringBuilder a = new StringBuilder("a");
        for(String s : str.split(" ")) {
            char ch = s.charAt(0);
            if(isVovel(ch)) {
                result.append(s + "ma");
            } else {
                result.append(s.length() == 1 ? s : s.substring(1, s.length()));
                result.append(s.length() == 1 ? "" : ch);
                result.append("ma");
            }
            result.append(a + " ");
            a.append("a");
        }

        return result.toString().trim();
    }

    private static boolean isVovel(char ch) {
        return ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e'
                || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o'
                || ch == 'U' || ch == 'u';
    }
}

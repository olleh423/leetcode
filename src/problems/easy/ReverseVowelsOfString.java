package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ReverseVowelsOfString {

    public static void main(String[] args) {

        ReverseVowelsOfString obj = new ReverseVowelsOfString();
    }

    public String reverseVowels(String s) {

        if(s == null || s.isEmpty())
            return "";

        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while(i < j) {

            if(!vowels.contains(chars[i])) {
                i++;
            } else if(!vowels.contains(chars[j])) {
                j--;
            } else {
                char ch = chars[i];
                chars[i] = chars[j];
                chars[j] = ch;
                i++; j--;
            }
        }

        return new String(chars);
    }
}

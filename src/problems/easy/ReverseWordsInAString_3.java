package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ReverseWordsInAString_3 {

    public static void main(String[] args) {

        ReverseWordsInAString_3 obj = new ReverseWordsInAString_3();
    }

    public String reverseWords(String s) {

        if(s == null)
            return null;

        char[] chars = s.toCharArray();
        int from = 0;
        for(int i=0 ; i<chars.length ; i++) {
            if(chars[i] == ' ') {
                reverse(chars, from , i-1);
                from = i+1;
            }
        }
        reverse(chars, from, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int from, int to) {

        while(from < to) {
            char temp = chars[from];
            chars[from] = chars[to];
            chars[to] = temp;
            from++;
            to--;
        }
    }
}

package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ValidAnagram {

    public static void main(String[] args) {

        ValidAnagram obj = new ValidAnagram();
    }

    public boolean isAnagram(String s, String t) {

        if(s == null && t == null) return true;
        if(s.length() != t.length()) return false;

        int[] chars = new int[26];
        for(int i=0 ; i<s.length() ; i++) {
            int ch = s.charAt(i);
            chars[ch - 'a']++;
        }

        for(int i=0 ; i<t.length() ; i++) {
            int ch = t.charAt(i);
            chars[ch - 'a']--;
        }

        for(int i=0 ; i<chars.length ; i++) {
            if(chars[i] != 0)
                return false;
        }

        return true;
    }
}

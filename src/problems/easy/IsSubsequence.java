package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class IsSubsequence {

    public static void main(String[] args) {

        IsSubsequence obj = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(obj.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {

        int i=0;
        int j=0;

        if(s == null || s.isEmpty()) return true;
        if(t == null || t.isEmpty()) return false;

        while(i < t.length()) {

            if(t.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;

            if(j == s.length()) return true;
        }

        return false;
    }
}

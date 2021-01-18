package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 18-01-2021
 */
public class PermutationInString {

    public static void main(String[] args) {

        PermutationInString obj = new PermutationInString();

        String s = "bdc", t = "abcdefg";
        System.out.println(obj.checkInclusion(s, t));
    }

    public boolean checkInclusion(String s, String t) {

        if(s == null || t == null || s.length() > t.length())
            return false;

        int[] sHash = new int[26];
        int[] tHash = new int[26];

        for(int i=0 ; i<s.length() ; i++) {
            sHash[s.charAt(i) - 'a']++;
            tHash[t.charAt(i) - 'a']++;
        }

        if(isIdentical(sHash, tHash))
            return true;

        int i=1, j=s.length();
        while(j < t.length()) {

            tHash[t.charAt(i-1) - 'a']--;
            tHash[t.charAt(j) - 'a']++;

            if(isIdentical(sHash, tHash))
                return true;

            i++;
            j++;
        }

        return false;
    }

    private boolean isIdentical(int[] sHash, int[] tHash) {

        for(int i=0 ; i<sHash.length ; i++) {
            if(sHash[i] != tHash[i])
                return false;
        }
        return true;
    }
}

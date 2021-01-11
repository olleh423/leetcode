package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 11-01-2021
 */
public class FindAllAnagramsInString {

    public static void main(String[] args) {

        FindAllAnagramsInString obj = new FindAllAnagramsInString();
        String s = "cbacsbca";
        String p = "abc";

        System.out.println(obj.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length())
            return result;

        int n = s.length();
        int m = p.length();

        int[] sHash = new int[26];
        int[] pHash = new int[26];

        for(int i=0 ; i<m ; i++) {
            pHash[p.charAt(i)-'a']++;
            sHash[s.charAt(i)-'a']++;
        }

        int i=0, j=m-1;
        while(j < n) {
            if(isIdentical(pHash, sHash)) {
                result.add(i);
            }
            sHash[s.charAt(i)-'a']--;
            i++;
            j++;
            if(j < n)
                sHash[s.charAt(j)-'a']++;
        }

        return result;
    }

    private boolean isIdentical(int[] hash1, int[] hash2) {
        for(int i=0 ; i<hash1.length ; i++) {
            if (hash1[i] != hash2[i])
                return false;
        }
        return true;
    }
}

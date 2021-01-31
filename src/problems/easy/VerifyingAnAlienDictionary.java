package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 30-01-2021
 */
public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {

        VerifyingAnAlienDictionary obj = new VerifyingAnAlienDictionary();

        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(obj.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {

        if(words == null || order == null)
            return false;

        int[] positions = new int[26];
        for(int i=0 ; i<order.length() ; i++) {
            positions[order.charAt(i) - 'a'] = i;
        }

        for(int i=0 ; i<words.length - 1 ; i++) {

            String s1 = words[i];
            String s2 = words[i+1];

            boolean isSorted = true;
            int idx1 = 0, idx2 = 0;
            while(idx1 < s1.length() || idx2 < s2.length()) {

                int pos1 = idx1 < s1.length() ? positions[s1.charAt(idx1++) - 'a'] : Integer.MIN_VALUE;
                int pos2 = idx2 < s2.length() ? positions[s2.charAt(idx2++) - 'a'] : Integer.MIN_VALUE;

                if(pos1 != pos2) {
                    isSorted = pos2 > pos1;
                    break;
                }
            }

            if(!isSorted)
                return false;
        }

        return true;
    }
}

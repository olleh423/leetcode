package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RansomeNote {

    public static void main(String[] args) {

        RansomeNote obj = new RansomeNote();
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote == null || magazine == null) {
            return false;
        }

        int[] count = new int[26];
        for(int i=0 ; i<magazine.length() ; i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for(int i=0 ; i<ransomNote.length() ; i++) {
            if(count[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            }
            count[ransomNote.charAt(i) - 'a']--;
        }

        return true;
    }
}

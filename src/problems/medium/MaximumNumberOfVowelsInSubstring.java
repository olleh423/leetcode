package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 18-01-2021
 */
public class MaximumNumberOfVowelsInSubstring {

    public static void main(String[] args) {

        MaximumNumberOfVowelsInSubstring obj = new MaximumNumberOfVowelsInSubstring();

        String str = "tryhard";
        int k = 4;

        System.out.println(obj.maxVowels(str, k));
    }

    public int maxVowels(String s, int k) {

        if(s == null || k == 0)
            return 0;

        int vowels = 0;
        for(int i=0 ; i<k ; i++) {
            vowels += isVowel(s.charAt(i)) ? 1 : 0;
        }

        int maxVowels = vowels;
        int i=1, j=k;

        while(j < s.length()) {

            if(isVowel(s.charAt(i-1)))
                vowels--;
            if(isVowel(s.charAt(j)))
                vowels++;

            maxVowels = Math.max(maxVowels, vowels);
            i++;
            j++;
        }

        return maxVowels;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

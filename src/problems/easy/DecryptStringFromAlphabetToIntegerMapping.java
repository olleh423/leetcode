package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DecryptStringFromAlphabetToIntegerMapping {

    public static void main(String[] args) {

        DecryptStringFromAlphabetToIntegerMapping obj = new DecryptStringFromAlphabetToIntegerMapping();
    }

    public String freqAlphabets(String s) {

        StringBuilder builder = new StringBuilder("");

        int i=s.length()-1;
        while(i >= 0) {

            char ch = s.charAt(i);
            if(ch != '#') {
                builder.append((char)(96 + Integer.parseInt(s.substring(i, i+1))));
                i--;
            }
            else {
                String twoDigit = s.substring(i-2, i);
                builder.append((char)(96 + Integer.parseInt(twoDigit)));
                i -= 3;
            }
        }

        return builder.reverse().toString();
    }
}

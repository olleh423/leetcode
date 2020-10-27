package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class DetectCapital {

    public static void main(String[] args) {

        DetectCapital obj = new DetectCapital();
    }

    public boolean detectCapitalUse(String word) {

        if(word == null || word.length() == 0)
            return false;

        if(word.length() == 1)
            return true;

        if(isCapital(word.charAt(0)))  {
            return isCapital(word.charAt(1)) ? verifyCapitals(word, 2) : verifySmalls(word, 2);
        } else {
            return verifySmalls(word, 0);
        }
    }

    private boolean verifySmalls(String str, int index) {

        for(int i=index ; i<str.length() ; i++) {
            int ch = str.charAt(i);
            if(ch < 97 || ch > 122)
                return false;
        }

        return true;
    }

    private boolean verifyCapitals(String str, int index) {
        for(int i=index ; i<str.length() ; i++) {
            int ch = str.charAt(i);
            if(ch < 65 || ch > 90)
                return false;
        }

        return true;
    }

    private boolean isCapital(char ch) {
        return ((int)ch) >= 65 && ((int)ch) <= 90;
    }
}

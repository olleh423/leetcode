package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ReverseString {

    public static void main(String[] args) {

        ReverseString obj = new ReverseString();
    }

    public void reverseString(char[] s) {

        if(s == null) return;
        int i=0, j=s.length-1;
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }
}

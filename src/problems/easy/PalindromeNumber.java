package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        PalindromeNumber obj = new PalindromeNumber();
    }

    public boolean isPalindrome(int x) {

        if(x < 0)
            return false;

        int number = x;
        int palin = 0;
        while(x > 0) {
            int digit = x % 10;
            palin = palin * 10 + digit;
            x /= 10;
        }

        return palin == number;
    }
}

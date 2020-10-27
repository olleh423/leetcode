package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RomanToInteger {

    public static void main(String[] args) {

        RomanToInteger obj = new RomanToInteger();
        String s = "MCMXCIV";
        System.out.println(obj.romanToInt(s));
    }

    public int romanToInt(String s) {

        if(s == null) return 0;

        int total = 0;
        for(int i=0 ; i<s.length()-1 ; i++) {

            int current = getInt(s.charAt(i));
            int next = getInt(s.charAt(i+1));

            if(current < next)
                total -= current;
            else
                total += current;
        }

        total += getInt(s.charAt(s.length()-1));
        return total;
    }

    private int getInt(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 07-01-2021
 */
public class MultiplyStrings {

    public static void main(String[] args) {

        MultiplyStrings obj = new MultiplyStrings();

        String s = "4532";
        String t = "5636";
        System.out.println(obj.multiply(s, t));
    }

    public String multiply(String s, String t) {

        if(s == null || t == null)
            return null;

        if(s.equals("0") || t.equals("0"))
            return "0";

        int n = s.length();
        int m = t.length();
        int[] result = new int[n + m];

        for(int i=m-1 ; i>=0 ; i--) {

            int a = t.charAt(i) - '0';
            for(int j=n-1 ; j>=0 ; j--) {

                int b = s.charAt(j) - '0';
                int multiple = a * b;

                int pos1 = i + j + 1;
                int pos2 = i + j;

                result[pos1] += multiple % 10;
                result[pos2] += multiple / 10;
            }
        }

        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for(int i=result.length-1 ; i>=0 ; i--) {

            int value = result[i] + carry;
            carry = value / 10;
            result[i] = value % 10;

            if(i > 0 || result[i] != 0)
                builder.append(result[i]);
        }

        return builder.reverse().toString();
    }
}

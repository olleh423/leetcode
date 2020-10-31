package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */

/*
Add binary numbers
 */
public class AddBinary {

    public static void main(String[] args) {

        AddBinary obj = new AddBinary();

        String a = "101";
        String b = "101";
        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {

        if(a == null && b == null) return null;
        if(a == null) return b;
        if(b == null) return a;

        int n = a.length() - 1;
        int m = b.length() - 1;
        StringBuilder result = new StringBuilder();
        char carry = '0';
        while(n >= 0 || m >= 0) {

            char ch1 = n < 0 ? '0' : a.charAt(n);
            char ch2 = m < 0 ? '0' : b.charAt(m);

            if(ch1 == '1' && ch2 == '1') {
                if(carry == '1') {
                    result.append('1');
                } else {
                    result.append('0');
                    carry = '1';
                }
            } else if(ch1 == '0' && ch2 == '0') {
                result.append(carry);
                carry = '0';
            } else {
                if(carry == '1') {
                    result.append('0');
                } else {
                    result.append('1');
                    carry = '0';
                }
            }
            n--;
            m--;
        }
        if(carry == '1')
            result.append('1');

        return result.reverse().toString();
    }
}

package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class AddStrings {

    public static void main(String[] args) {

        AddStrings obj = new AddStrings();

        String X = "142";
        String Y = "5255";
        System.out.println(obj.addStrings(X, Y));
    }

    public String addStrings(String X, String Y) {

        if(X == null && Y == null) return null;
        if(X == null) return Y;
        if(Y == null) return X;

        StringBuilder builder = new StringBuilder();

        int carry = 0;
        int i = X.length() - 1;
        int j = Y.length() - 1;

        while(i >= 0 || j >= 0) {

            int one = i < 0 ? 0 : X.charAt(i) - '0';
            int two = j < 0 ? 0 : Y.charAt(j) - '0';

            int sum = one + two + carry;
            carry = sum < 10 ? 0 : 1;
            sum = sum % 10;

            builder.append(sum);
            i--;
            j--;
        }

        if(carry == 1) builder.append(carry);
        return builder.reverse().toString();
    }
}

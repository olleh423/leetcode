package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class SplitAStringInBalancedString {

    public static void main(String[] args) {

        SplitAStringInBalancedString obj = new SplitAStringInBalancedString();
    }

    public int balancedStringSplit(String s) {

        int total = 0;
        int count = s.charAt(0) == 'R' ? 1 : -1;
        for(int i=1 ; i<s.length() ; i++) {
            char ch = s.charAt(i);
            count += (ch == 'R' ? 1 : -1);
            if(count == 0)
                total++;
        }

        return total;
    }
}

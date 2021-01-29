package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 22-01-2021
 */
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {

        MinimumRemoveToMakeValidParentheses obj = new MinimumRemoveToMakeValidParentheses();

        String s = "Lee(t(c)o)de)";
        System.out.println(obj.minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {

        if(s == null)
            return s;

        StringBuilder builder = new StringBuilder();

        int open = 0, closed = 0;
        for(int i=0 ; i<s.length() ; i++) {
            char current = s.charAt(i);
            if(current - '(' != 0 && current - ')' != 0) {
                builder.append(current);
            }
            else if(current - '(' == 0) {
                open++;
                builder.append(current);
            }
            else if(open > 0) {
                open--;
                builder.append(current);
            }
        }

        s = builder.toString();
        builder = new StringBuilder();
        open = 0;
        closed = 0;

        for(int i=s.length() - 1 ; i>=0 ; i--) {

            char current = s.charAt(i);
            if(current - '(' != 0 && current - ')' != 0) {
                builder.append(current);
            }
            else if(current - ')' == 0) {
                closed++;
                builder.append(current);
            }
            else if(closed > 0) {
                closed--;
                builder.append(current);
            }
        }

        return builder.reverse().toString();
    }
}

package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RemoveOuterMostParentheses {

    public static void main(String[] args) {

        RemoveOuterMostParentheses obj = new RemoveOuterMostParentheses();
    }

    public String removeOuterParentheses(String str) {

        if(str == null) return null;

        int count = 0;
        int left = 0;
        StringBuilder result = new StringBuilder("");
        for(int i=0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);
            count += ch == '(' ? 1 : -1;
            if(count == 0) {
                result.append(str.substring(left+1, i));
                left = i+1;
            }
        }
        return result.toString();
    }
}

package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ValidParentheses {

    public static void main(String[] args) {

        ValidParentheses obj = new ValidParentheses();
        String str = "()[]{}";
        System.out.println(obj.isValid(str));
    }

    public boolean isValid(String s) {

        if(s == null) return false;

        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<s.length() ; i++) {

            char ch = s.charAt(i);
            if(isOpen(ch)) {
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) return false;

                char prev = stack.pop();
                if(!isValidPair(prev, ch))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpen(char ch) {
        return ch == '[' || ch == '{' || ch == '(';
    }

    private boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}

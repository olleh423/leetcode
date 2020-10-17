package problems.hard;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        String s = ")()())";

        LongestValidParentheses obj = new LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(s));
    }

    public int longestValidParentheses(String str) {

        if(str.isEmpty())
            return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int result = 0;
        for(int i=0 ; i<str.length() ; i++) {

            if(str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(i-stack.peek(), result);
                }
            }
        }

        return result;
    }
}

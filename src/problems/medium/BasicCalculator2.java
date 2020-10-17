package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class BasicCalculator2 {

    public static void main(String[] args) {

        BasicCalculator2 obj = new BasicCalculator2();

        String expression = "3+2*2";
        System.out.println(obj.calculate(expression));
    }

    public int calculate(String str) {

        if(str == null || str.isEmpty())
            return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int n = 0;
        char lastSign = '+';

        for(int i=0 ; i<str.length() ; i++) {

            char ch = str.charAt(i);

            if(Character.isDigit(ch)) {
                if(n != 0) stack.pop();
                n = n * 10 + ch - '0';
                stack.push(n);
            }
            else if(ch != ' ') {
                operate(stack, lastSign);
                n = 0;
                lastSign = ch;
            }
        }

        operate(stack, lastSign);
        int total = 0;
        while(!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }

    private void operate(Stack<Integer> stack, char lastSign) {

        int top = stack.pop();
        if(lastSign == '+') {
            stack.push(top);
        }
        else if(lastSign == '-') {
            stack.push(-top);
        }
        else if(lastSign == '*') {
            stack.push(stack.pop() * top);
        }
        else if(lastSign == '/') {
            stack.push(stack.pop() / top);
        }
    }
}

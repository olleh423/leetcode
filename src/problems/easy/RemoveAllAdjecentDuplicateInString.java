package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class RemoveAllAdjecentDuplicateInString {

    public static void main(String[] args) {

        RemoveAllAdjecentDuplicateInString obj = new RemoveAllAdjecentDuplicateInString();
    }

    public String removeDuplicates(String S) {

        if(S == null)
            return null;

        Stack<Character> stack = new Stack<>();
        int i=0 ;
        while(i < S.length()) {
            char ch = S.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            }
            else if(stack.peek() == ch) {
                stack.pop();
            }
            i++;
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }
}

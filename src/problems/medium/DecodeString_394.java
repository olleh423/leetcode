package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 08-11-2020
 */
public class DecodeString_394 {

    public static void main(String[] args) {

        DecodeString_394 obj = new DecodeString_394();

        System.out.println(obj.decodeString("3[a]2[bc]"));
        System.out.println(obj.decodeString("3[a2[c]]"));
        System.out.println(obj.decodeString("2[abc]3[cd]ef"));
        System.out.println(obj.decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String str) {

        if(str == null) return str;

        Stack<String> strings = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        StringBuilder result = new StringBuilder();
        int n = 0;
        int i = 0;

        while(i < str.length()) {

            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            }
            else if(ch == '[') {
                strings.push(result.toString());
                numbers.push(n);
                result = new StringBuilder();
                n = 0;
            }
            else if(ch == ']') {
                int m = numbers.pop();
                StringBuilder sb = new StringBuilder(strings.pop());
                for(int k=0 ; k<m ; k++)
                    sb.append(result);

                result = new StringBuilder(sb);
            }
            else {
                result.append(ch);
            }
            i++;
        }

        return result.toString();
    }
}

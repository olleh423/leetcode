package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {

        BackspaceStringCompare obj = new BackspaceStringCompare();

        String S = "ab#c";
        String T = "ad#c";
        System.out.println(obj.backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String S, String T) {

        if(S == null && T == null) return true;
        if(S == null || T == null) return false;

        Stack<Character> sStack = new Stack<Character>();
        Stack<Character> tStack = new Stack<Character>();

        for(int i=0 ; i<S.length() ; i++) {
            char ch = S.charAt(i);
            if(ch != '#')
                sStack.push(ch);
            else if(!sStack.isEmpty())
                sStack.pop();
        }

        for(int i=0 ; i<T.length() ; i++) {
            char ch = T.charAt(i);
            if(ch != '#')
                tStack.push(ch);
            else if(!tStack.isEmpty())
                tStack.pop();
        }

        while(!sStack.isEmpty()) {
            char ch = sStack.pop();
            if(tStack.isEmpty() || tStack.pop() != ch)
                return false;
        }

        return sStack.isEmpty() && tStack.isEmpty();
    }
}

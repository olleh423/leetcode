package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ToLowerCase {

    public static void main(String[] args) {

        ToLowerCase obj = new ToLowerCase();
    }

    public String toLowerCase(String str) {

        if(str == null) return str;

        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i<str.length() ; i++) {
            int ch = str.charAt(i);
            builder.append((ch >= 65 && ch <= 90) ? ((char)(ch - 65 + 97)) : ((char)(ch)));
        }
        return builder.toString();
    }
}

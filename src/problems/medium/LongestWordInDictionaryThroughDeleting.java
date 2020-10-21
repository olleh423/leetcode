package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {

        LongestWordInDictionaryThroughDeleting obj = new LongestWordInDictionaryThroughDeleting();

        String s = "abpcplea";
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(obj.findLongestWord(s, d));
    }

    public String findLongestWord(String text, List<String> d) {

        String result = null;
        int length = 0;
        for(String str : d) {

            int i=0, j=0;
            while(i < text.length() && j < str.length()) {
                if(str.charAt(j) == text.charAt(i)) {
                    j++;
                }
                i++;
            }
            if(j == str.length()) {
                if(j > length) {
                    result = str;
                    length = j;
                }
                else if(j == length) {
                    result = str.compareTo(result) < 0 ? str : result;
                }
            }
        }

        return result == null ? "" : result;
    }
}

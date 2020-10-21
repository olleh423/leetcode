package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class FindKLengthSubstringWithNoRepeating {

    public static void main(String[] args) {

        FindKLengthSubstringWithNoRepeating obj = new FindKLengthSubstringWithNoRepeating();
        String S = "havefunonleetcode";
        int K = 5;
        System.out.println(obj.numKLenSubstrNoRepeats(S, K));
    }

    public int numKLenSubstrNoRepeats(String str, int K) {

        if(str == null || K == 0)
            return 0;

        if(K == 1)
            return str.length();

        int[] chars = new int[26];
        Arrays.fill(chars, -1);

        int one = 0, two = 0;
        int count = 0;

        while(two < str.length()) {

            char ch = str.charAt(two);
            if(chars[ch - 'a'] != -1) {
                int lastIndex = chars[ch - 'a'];
                while(one <= lastIndex) {
                    chars[str.charAt(one) - 'a'] = -1;
                    one++;
                }
            }
            else if(two - one == K - 1) {
                chars[str.charAt(one) - 'a'] = -1;
                count++;
                one++;
            }
            else {
                chars[ch - 'a'] = two;
                two++;
            }
        }

        return count;
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class WordBreak {

    public static void main(String[] args) {

        WordBreak obj = new WordBreak();
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println(obj.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<String>(wordDict);
        int[] DP = new int[s.length()];
        Arrays.fill(DP, -1);
        boolean result = wordBreak(0, s, DP, dict);
        System.out.println(Arrays.toString(DP));
        return result;
    }

    private boolean wordBreak(int idx, String str, int[] DP, Set<String> dict) {

        if(idx == str.length())
            return true;

        if(DP[idx] != -1)
            return DP[idx] == 1;

        for(int i=idx ; i<str.length() ; i++) {

            if(dict.contains(str.substring(idx, i+1)) && wordBreak(i+1, str, DP, dict)) {
                DP[i] = 1;
                return true;
            }
        }

        DP[idx] = 0;
        return false;
    }
}

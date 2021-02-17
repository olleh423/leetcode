package problems.hard;

import java.util.*;

/*
 * Author : Vijay Sharma 17-02-2021
 */
public class InterleavingStrings {

    public static void main(String[] args) {

        InterleavingStrings obj = new InterleavingStrings();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(obj.isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1 == null || s2 == null || s3 == null)
            return false;

        if(s1.length() + s2.length() != s3.length())
            return false;

        return solve(0, 0, 0, s1, s2, s3, new HashMap<String, Boolean>());
    }

    private boolean solve(int i, int j, int k, String A, String B, String C, Map<String, Boolean> map) {

        if(k == C.length()) return true;

        String key = i+"#"+j+"#"+k;
        if(map.containsKey(key)) return map.get(key);

        if(i < A.length() && A.charAt(i) == C.charAt(k) && solve(i+1, j, k+1, A, B, C, map)) {
            map.put(key, true);
            return true;
        }

        if(j < B.length() && B.charAt(j) == C.charAt(k) && solve(i, j+1, k+1, A, B, C, map)) {
            map.put(key, true);
            return true;
        }

        map.put(key, false);
        return false;
    }
}

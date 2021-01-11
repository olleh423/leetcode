package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 07-01-2021
 */
public class MaximumLengthOfAConcatenatedString {

    public static void main(String[] args) {

        MaximumLengthOfAConcatenatedString obj = new MaximumLengthOfAConcatenatedString();

        List<String> data = Arrays.asList("un", "iq", "ue");
        int maxLength = obj.maxLength(data);
        System.out.println(maxLength);
    }

    public int maxLength(List<String> data) {

        if(data == null || data.isEmpty())
            return 0;

        return solve(0, "", data, new HashSet<Character>());
    }

    private int solve(int idx, String str, List<String> data, Set<Character> unique) {

        if(idx == data.size())
            return str.length();

        int A = solve(idx + 1, str, data, unique);

        String current = data.get(idx);
        Set<Character> active = new HashSet<>();
        for(int i=0 ; i<current.length() ; i++) {
            char ch = current.charAt(i);
            if(unique.contains(ch) || active.contains(ch))
                return A;
            active.add(ch);
        }
        unique.addAll(active);
        int B = solve(idx + 1, str + current, data, unique);
        unique.removeAll(active);

        return Math.max(A, B);
    }
}

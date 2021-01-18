package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 13-01-2021
 */
public class NumberOfWaysToSplitString {

    public static void main(String[] args) {

        NumberOfWaysToSplitString obj = new NumberOfWaysToSplitString();
        String s = "001001000001000";
        System.out.println(obj.numWays(s));
    }

    public int numWays(String s) {

        if(s == null) return 0;

        int MOD = 1000000007;

        int numOfOnes = 0;
        for(int i=0 ; i<s.length() ; i++) {
            numOfOnes += (s.charAt(i) - '0');
        }

        if(numOfOnes == 0) {
            int n = s.length();
            return (int) (((n-2L) * (n-1L) / 2L) % MOD);
        }

        if(numOfOnes % 3 != 0) return 0;

        int single = numOfOnes / 3;
        long A=1, B=1;

        int count = 0;
        for(int i=0 ; i < s.length() ; i++) {

            if(s.charAt(i) - '0' == 1) {
                count++;
            } else {
                if(count == single)
                    A++;
                if(count == single*2)
                    B++;
            }
        }

        return (int) ((A % MOD) * (B % MOD) % MOD);
    }
}

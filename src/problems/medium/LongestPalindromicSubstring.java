package problems.medium;
/*
 * Auther : Vijay Sharma
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();

        String str = "abcdedcbkbccbktf";
        System.out.println(obj.longestPalindrome(str));
    }

    public String longestPalindrome(String str) {

        if(str == null || str.isEmpty())
            return str;

        boolean[][] DP = new boolean[str.length()][str.length()];
        int maxLength = 0;
        int start = 0;

        for(int i=0 ; i<str.length() ; i++) {
            DP[i][i] = true;
            maxLength = 1;
            start = i;
        }

        for(int i=0 ; i<str.length() - 1 ; i++) {

            if(str.charAt(i) == str.charAt(i+1)) {
                DP[i][i+1] = true;
                maxLength = 2;
                start = i;
            } else {
                DP[i][i+1] = false;
            }
        }

        for(int k=3 ; k <= str.length() ; k++) {

            for(int i=0 ; i <= str.length() - k ; i++) {

                if(str.charAt(i) == str.charAt(i + k - 1) && DP[i + 1][i + k - 2]) {

                    DP[i][i+k-1] = true;
                    maxLength = k;
                    start = i;

                } else {

                    DP[i][i+k-1] = false;
                }
            }
        }

        return str.substring(start, start + maxLength);
    }
}

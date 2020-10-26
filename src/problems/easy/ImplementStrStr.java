package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ImplementStrStr {

    public static void main(String[] args) {

        ImplementStrStr obj = new ImplementStrStr();

        String haystack = "hello";
        String needle = "ll";

        System.out.println(obj.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        if(haystack == null)
            return -1;

        if(needle == null || needle.isEmpty())
            return 0;

        return kmp(haystack, needle);
    }

    private static int[] getPITable(String pattern) {

        int[] PI = new int[pattern.length()];
        PI[0] = 0;

        int i=1, j=0;
        while(i < pattern.length()) {

            if(pattern.charAt(i) == pattern.charAt(j)) {
                PI[i] = ++j;
                i++;
            } else {
                if(j != 0) {
                    j = PI[j-1];
                } else {
                    PI[i] = 0;
                    i++;
                }
            }
        }

        return PI;
    }

    public static int kmp(String text, String pattern) {

        int[] PI = getPITable(pattern);

        boolean found = false;
        int i=0, j=0;
        while(i < text.length()) {

            if(text.charAt(i) == pattern.charAt(j)) {
                if(j == PI.length-1) {
                    return i-j;
                } else {
                    j++;
                }
                i++;
            } else {
                if(j != 0) {
                    j = PI[j-1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }
}

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

    public int strStr_2(String haystack, String needle) {

        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if(needle.isEmpty()) return 0;

        for(int i=0 ; i<haystack.length()-needle.length()+1 ; i++) {

            if(haystack.charAt(i) == needle.charAt(0)) {

                boolean matched = true;
                for(int j=0, k=i ; j<needle.length() ; j++, k++) {

                    if(haystack.charAt(k) != needle.charAt(j)) {
                        matched = false;
                        break;
                    }
                }

                if(matched) return i;
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {

        if(haystack == null)
            return -1;

        if(needle == null || needle.isEmpty())
            return 0;

        return kmp(haystack, needle);
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
}

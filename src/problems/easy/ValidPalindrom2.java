package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ValidPalindrom2 {

    public static void main(String[] args) {

        ValidPalindrom2 obj = new ValidPalindrom2();
        String s = "abca";
        System.out.println(obj.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {

        if(s == null || s.isEmpty())
            return true;

        return validPalindrom(s, 0, s.length()-1, false);
    }

    private boolean validPalindrom(String s, int i, int j, boolean deleted) {

        if(i >= j)
            return true;

        if(s.charAt(i) == s.charAt(j))
            return validPalindrom(s, i+1, j-1, deleted);
        else if(!deleted)
            return validPalindrom(s, i+1, j, true) || validPalindrom(s, i, j-1, true);
        else
            return false;
    }
}

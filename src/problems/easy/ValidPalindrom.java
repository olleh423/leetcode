package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ValidPalindrom {

    public static void main(String[] args) {

        ValidPalindrom obj = new ValidPalindrom();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {

        if(s == null)
            return false;

        if(s.length() == 0 || s.length() == 1)
            return true;

        s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        while(low < high) {

            char chLow = s.charAt(low);
            char chHigh = s.charAt(high);

            if(!isAlphaNumaric(chLow))
                low++;
            else if(!isAlphaNumaric(chHigh))
                high--;
            else {
                if(chLow == chHigh) {
                    low++; high--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAlphaNumaric(char ch) {

        int n = (int) ch;
        return (n >= 48 && n <= 57) || (n >= 97 && n <= 122);
    }
}

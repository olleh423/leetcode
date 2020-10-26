package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class RepeatingSubstringPattern {

    public static void main(String[] args) {

        RepeatingSubstringPattern obj = new RepeatingSubstringPattern();
        String str = "abcabcabcabc";
        System.out.println(obj.repeatedSubstringPattern(str));
    }

    public boolean repeatedSubstringPattern(String str) {

        if(str == null)
            return false;

        int n = str.length();
        for(int i=n/2 ; i > 0 ; i--) {

            if(n % i == 0) {

                int copies = n / i;
                String sub = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int k=0 ; k<copies ; k++)
                    sb.append(sub);

                if(sb.toString().equals(str)) return true;
            }
        }

        return false;
    }
}

package problems.hard;

public class WildCardMatching {

    public static void main(String[] args) {

        String str = "adceb";
        String pattern = "*a*b";

        WildCardMatching obj = new WildCardMatching();
        System.out.println(obj.isMatch(str, pattern));
    }

    public boolean isMatch(String str, String pattern) {

        int[][] T = new int[1+str.length()][1+pattern.length()];
        T[0][0] = 1;

        for(int i=1 ; i<=pattern.length() ; i++) {
            if(pattern.charAt(i-1) == '*')
                T[0][i] = T[0][i-1];
        }

        for(int i=1 ; i<T.length ; i++) {

            for(int j=1 ; j<T[i].length ; j++) {

                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?') {
                    T[i][j] = T[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*') {
                    T[i][j] = T[i][j-1] == 1 || T[i-1][j] == 1 ? 1 : 0;
                } else {
                    T[i][j] = 0;
                }
            }
        }

        return T[str.length()][pattern.length()] == 1;
    }
}

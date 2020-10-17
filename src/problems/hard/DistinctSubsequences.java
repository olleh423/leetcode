package problems.hard;

public class DistinctSubsequences {

    public static void main(String[] args) {

        String S = "rabbbit";
        String T = "rabbit";

        DistinctSubsequences obj = new DistinctSubsequences();
        System.out.println(obj.numDistinct(S, T));
    }

    public int numDistinct(String s, String t) {

        int[][] results = new int[t.length() + 1][s.length() + 1];
        for(int i=1 ; i<results.length ; i++) {
            for(int j=1 ; j<results[i].length ; j++) {

                if(i == 1) {
                    results[i][j] = (s.charAt(j-1) == t.charAt(i-1)) ? 1 + results[i][j-1] : results[i][j-1];
                } else {
                    results[i][j] = (s.charAt(j-1) == t.charAt(i-1)) ? results[i-1][j-1] + results[i][j-1] : results[i][j-1];
                }
            }
        }

        return results[t.length()][s.length()];
    }
}

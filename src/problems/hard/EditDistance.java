package problems.hard;

public class EditDistance {

    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance(word1, word2));
    }

    public int min(int a, int b, int c) {

        return Math.min(Math.min(a, b), c);
    }

    public int minDistance(String word1, String word2) {

        int[][] res = new int[word2.length() + 1][word1.length() + 1];

        for(int i=0 ; i<res.length ; i++) {

            for(int j=0 ; j<res[i].length ; j++) {

                if(i == 0) {
                    res[i][j] = j;
                } else if (j == 0) {
                    res[i][j] = i;
                } else {
                    if(word2.charAt(i-1) == word1.charAt(j-1)) {
                        res[i][j] = res[i-1][j-1];
                    } else {
                        res[i][j] = 1 + min(res[i][j-1], res[i-1][j], res[i-1][j-1]);
                    }
                }
            }
        }

        return res[word2.length()][word1.length()];
    }
}

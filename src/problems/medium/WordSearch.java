package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class WordSearch {

    public static void main(String[] args) {

        WordSearch obj = new WordSearch();
    }

    public boolean exist(char[][] board, String word) {

        if(board == null || word == null)
            return false;

        int n = board.length;
        int m = board[0].length;

        boolean[][] visiting = new boolean[n][m];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(explore(i, j, board, word, 0, visiting))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean explore(int i, int j, char[][] board, String word, int idx, boolean[][] visiting) {

        if(idx == word.length())
            return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length
                || board[i][j] != word.charAt(idx) || visiting[i][j])
            return false;

        visiting[i][j] = true;
        boolean result = explore(i-1, j, board, word, idx+1, visiting)
                || explore(i+1, j, board, word, idx+1, visiting)
                || explore(i, j-1, board, word, idx+1, visiting)
                || explore(i, j+1, board, word, idx+1, visiting);

        visiting[i][j] = false;
        return result;
    }
}

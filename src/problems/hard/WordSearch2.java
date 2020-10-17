package problems.hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearch2 obj = new WordSearch2();
        System.out.println(obj.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        if(board == null || words == null)
            return result;

        for(String word : words) {
            if(exists(word, board))
                result.add(word);
        }

        return result;
    }

    private boolean exists(String word, char[][] board) {

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(explore(0, i, j, word, board, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean explore(int idx, int i, int j, String word, char[][] board, boolean[][] visited) {

        if(idx == word.length())
            return true;

        if(i < 0 || i == board.length || j < 0 || j == board[i].length || visited[i][j] || board[i][j] != word.charAt(idx))
            return false;

        visited[i][j] = true;
        boolean result = explore(idx+1, i+1, j, word, board, visited)
                || explore(idx+1, i-1, j, word, board, visited)
                || explore(idx+1, i, j+1, word, board, visited)
                || explore(idx+1, i, j-1, word, board, visited);
        visited[i][j] = false;

        return result;
    }
}

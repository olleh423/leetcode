package problems;

/*
 * Leetcode 79 : Word search
 */

public class WordSearchGrid {
	
	private static boolean explore(char[][] board, int i, int j, String word, int index, boolean[][] visiting) {
        
        if(index == word.length())
            return true;
        
        if(i < 0 || i == board.length || j < 0 || j == board[i].length || visiting[i][j] || word.charAt(index) != board[i][j])
            return false;
        
        visiting[i][j] = true;
        
        boolean result = explore(board, i+1, j, word, index+1, visiting)
                        || explore(board, i-1, j, word, index+1, visiting)
                        || explore(board, i, j+1, word, index+1, visiting)
                        || explore(board, i, j-1, word, index+1, visiting);
        
        visiting[i][j] = false;
        return result;
    }

	public static boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0 || word == null)
            return false;
        
        boolean[][] visiting = new boolean[board.length][];
        for(int i=0 ; i<visiting.length ; i++)
            visiting[i] = new boolean[board[i].length];
        
        for(int i=0 ; i<board.length ; i++) {
            for(int j=0 ; j<board[i].length ; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(explore(board, i, j, word, 0, visiting))
                        return true;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		
		/*char[][] board = {
		                  {'A','B','C','E'},
		                  {'S','F','C','S'},
		                  {'A','D','E','E'}
		                 };
		String word = "ABCCED";*/
		
		char[][] board = {{'a', 'b'}, {'d', 'c'}};
		String word = "abcd";
		
		System.out.println(exist(board, word));
	}
}

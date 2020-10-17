package problems.medium;
/*
 * Auther : Vijay Sharma
 */
public class SurroundedRegions {

    public static void main(String[] args) {

        SurroundedRegions obj = new SurroundedRegions();
    }

    public void solve(char[][] board) {

        if(board == null || board.length == 0)
            return;

        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        //Top
        for(int i=0 ; i<c ; i++) {
            if(board[0][i] == 'O' && !visited[0][i])
                explore(0, i, visited, board);
        }

        //Bottom
        for(int i=0 ; i<c ; i++) {
            if(board[r-1][i] == 'O' && !visited[r-1][i])
                explore(r-1, i, visited, board);
        }

        //Left
        for(int i=0 ; i<r ; i++) {
            if(board[i][0] == 'O' && !visited[i][0])
                explore(i, 0, visited, board);
        }

        //Right
        for(int i=0 ; i<r ; i++) {
            if(board[i][c-1] == 'O' && !visited[i][c-1])
                explore(i, c-1, visited, board);
        }

        // Mark rest of O's to X's
        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private void explore(int i, int j, boolean[][] visited, char[][] board) {

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != 'O')
            return;

        visited[i][j] = true;

        explore(i + 1, j, visited, board);
        explore(i, j + 1, visited, board);
        explore(i - 1, j, visited, board);
        explore(i, j - 1, visited, board);
    }
}

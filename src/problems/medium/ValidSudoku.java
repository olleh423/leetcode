package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-10-2020
 */
public class ValidSudoku {

    public static void main(String[] args) {

        ValidSudoku obj = new ValidSudoku();
    }

    public boolean isValidSudoku(char[][] board) {

        if(board == null) return false;

        for(int i=0 ; i<9 ; i++) {
            for(int j=0 ; j<9 ; j++) {
                if(board[i][j] != '.' &&
                        !(isUniqueInRow(board, i, j)
                                && isUniqueInCol(board, i, j)
                                && isUniqueInBlock(board, i, j))) {

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isUniqueInRow(char[][] board, int i, int j) {

        for(int k=0 ; k<9 ; k++) {
            if(k != j && board[i][j] == board[i][k])
                return false;
        }
        return true;
    }

    private boolean isUniqueInCol(char[][] board, int i, int j) {

        for(int k=0 ; k<9 ; k++) {
            if(i != k && board[k][j] == board[i][j])
                return false;
        }
        return true;
    }

    private boolean isUniqueInBlock(char[][] board, int x, int y) {

        int bi = 0, bj = 0;
        if(x < 3) bi = 0; else if(x < 6) bi = 3; else bi = 6;
        if(y < 3) bj = 0; else if(y < 6) bj = 3; else bj = 6;

        for(int i=bi ; i<bi+3 ; i++) {
            for(int j=bj ; j<bj+3 ; j++) {
                if((i != x && j != y) && board[i][j] == board[x][y])
                    return false;
            }
        }
        return true;
    }
}

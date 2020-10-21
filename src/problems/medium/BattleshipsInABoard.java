package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class BattleshipsInABoard {

    public static void main(String[] args) {

        BattleshipsInABoard obj = new BattleshipsInABoard();
    }

    public int countBattleships(char[][] board) {

        int total = 0;

        if(board == null || board.length == 0)
            return total;

        for(int i=0 ; i<board.length ; i++) {

            for(int j=0 ; j<board[i].length ; j++) {

                if((board[i][j] == '.') || (i > 0 && board[i-1][j] == 'X') || (j > 0 && board[i][j-1] == 'X')) {
                    continue;
                }
                total++;
            }
        }

        return total;
    }
}

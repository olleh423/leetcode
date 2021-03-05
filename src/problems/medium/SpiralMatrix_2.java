package problems.medium;/*
 * Author : Vijay Sharma 05-03-2021
 */

import java.util.Arrays;

public class SpiralMatrix_2 {

    public static void main(String[] args) {

        SpiralMatrix_2 obj = new SpiralMatrix_2();
        int[][] grid = obj.generateMatrix(5);

        for(int i=0 ; i<grid.length ; i++) {
            for(int j=0 ; j<grid[i].length ; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {

        int[][] grid = new int[n][n];

        int count = 1, MOVE = 0;
        int top = 0, left = 0, right = n-1, bottom = n-1;

        while(count <= (n*n)) {

            switch(MOVE) {

                case 0 : {
                    for(int i=left ; i <= right ; i++) {
                        grid[top][i] = count++;
                    }
                    top++;
                    break;
                }
                case 1 : {
                    for(int i=top ; i <= bottom ; i++) {
                        grid[i][right] = count++;
                    }
                    right--;
                    break;
                }
                case 2 : {
                    for(int i=right ; i >= left ; i--) {
                        grid[bottom][i] = count++;
                    }
                    bottom--;
                    break;
                }
                case 3 : {
                    for(int i=bottom ; i >= top ; i--) {
                        grid[i][left] = count++;
                    }
                    left++;
                    break;
                }
            }

            MOVE = (MOVE + 1) % 4;
        }

        return grid;
    }
}

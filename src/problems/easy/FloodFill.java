package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FloodFill {

    public static void main(String[] args) {

        FloodFill obj = new FloodFill();
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;

        fill(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void fill(int[][] image, int i, int j, int oldColor, int newColor) {

        if(i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != oldColor)
            return;

        image[i][j] = newColor;

        fill(image, i + 1, j, oldColor, newColor);
        fill(image, i - 1, j, oldColor, newColor);
        fill(image, i, j + 1, oldColor, newColor);
        fill(image, i, j - 1, oldColor, newColor);
    }
}

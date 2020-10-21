package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {

        UniqueBinarySearchTrees obj = new UniqueBinarySearchTrees();

        System.out.println(obj.numTrees(4));
    }

    public int numTrees(int n) {

        int[][] res = new int[n+2][n+2];
        for(int i=0 ; i<res.length ; i++)
            for(int j=0 ; j<res[i].length ; j++)
                res[i][j] = -1;

        return uniqueBSTs(1, n, res);
    }

    private int uniqueBSTs(int from, int to, int[][] res) {

        if(from > to) return 1;
        if(res[from][to] != -1) return res[from][to];
        int total = 0;
        for(int i=from ; i <= to ; i++) {
            total += (uniqueBSTs(from, i-1, res)) * (uniqueBSTs(i+1, to, res));
        }
        return res[from][to] = total;
    }
}

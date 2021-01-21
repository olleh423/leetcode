package problems.medium;

import java.util.*;
import java.util.stream.IntStream;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class GraphValidTree {

    public static void main(String[] args) {

        GraphValidTree obj = new GraphValidTree();
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};

        System.out.println(obj.validTree(n, edges));
    }

    public boolean validTree(int n, int[][] edges) {

        //initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int i = 0; i < edges.length; i++) {

            int x = findSet(nums, edges[i][0]);
            int y = findSet(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    private int findSet(int nums[], int i) {

        if(nums[i] == -1) return i;

        return findSet(nums, nums[i]);
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 27-01-2021
 */
public class NumberOfConnectedComponentsInUndirectedGraph {

    public static void main(String[] args) {

        NumberOfConnectedComponentsInUndirectedGraph obj = new NumberOfConnectedComponentsInUndirectedGraph();

        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5;

        System.out.println(obj.countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {

        if(n == 0 || edges == null)
            return 0;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for(int[] edge : edges) {

            int X = findParent(parent, edge[0]);
            int Y = findParent(parent, edge[1]);

            if(X != Y) {
                parent[X] = Y;
            }
        }

        int nuOfConnectedComponents = 0;
        for(int i=0 ; i<parent.length ; i++) {

            if(parent[i] == -1)
                nuOfConnectedComponents++;
        }

        return nuOfConnectedComponents;
    }

    private int findParent(int[] parent, int n) {
        if(parent[n] == -1)
            return n;
        return findParent(parent, parent[n]);
    }
}

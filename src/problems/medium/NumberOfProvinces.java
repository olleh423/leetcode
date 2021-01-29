package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 23-01-2021
 */
public class NumberOfProvinces {

    public static void main(String[] args) {

        NumberOfProvinces obj = new NumberOfProvinces();
        int[][] edges = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(obj.findCircleNum(edges));
    }

    public int findCircleNum(int[][] isConnected) {

        if(isConnected == null)
            return 0;

        int n = isConnected.length;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(i != j) {
                    if(isConnected[i][j] == 1) {
                        int pi = findParent(parent, i);
                        int pj = findParent(parent, j);
                        if(pi != pj) {
                            parent[pi] = pj;
                        }
                    }
                }
            }
        }

        int provinces = 0;
        for(int i=0 ; i<parent.length ; i++) {
            provinces += parent[i] == -1 ? 1 : 0;
        }

        return provinces;
    }

    private int findParent(int[] parent, int node) {
        if(parent[node] == -1)
            return node;
        return findParent(parent, parent[node]);
    }
}

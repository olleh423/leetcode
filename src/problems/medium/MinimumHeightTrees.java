package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 01-02-2021
 */
public class MinimumHeightTrees {

    public static void main(String[] args) {

        MinimumHeightTrees obj = new MinimumHeightTrees();

        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(obj.findMinHeightTrees(n, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        if(n == 0 || edges == null)
            return result;

        if(n == 1) {
            result.add(0);
            return result;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<n ; i++)
            adjList.add(new ArrayList<>());

        int[] D = new int[n];
        for(int[] edge : edges) {
            D[edge[0]]++;
            D[edge[1]]++;
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<D.length ; i++) {
            if(D[i] == 1)
                queue.add(i);
        }

        while(n > 2) {

            int size = queue.size();
            n -= size;

            for(int i=0 ; i<size ; i++) {

                int node = queue.poll();
                for(int adj : adjList.get(node)) {
                    D[adj]--;
                    if(D[adj] == 1)
                        queue.add(adj);
                }
            }
        }

        result.addAll(queue);
        return result;
    }
}

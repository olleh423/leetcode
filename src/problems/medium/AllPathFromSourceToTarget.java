package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 31-01-2021
 */
public class AllPathFromSourceToTarget {

    public static void main(String[] args) {

        AllPathFromSourceToTarget obj = new AllPathFromSourceToTarget();
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(obj.allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();

        if(graph == null)
            return result;

        int src = 0;
        solve(src, graph, new ArrayList<Integer>(), result);

        return result;
    }

    private void solve(int src, int[][] graph, List<Integer> path, List<List<Integer>> result) {

        if(src == graph.length - 1) {
            path.add(src);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(src);
        int[] routes = graph[src];
        for(int node : routes) {
            solve(node, graph, path, result);
        }
        path.remove(path.size() - 1);
    }
}

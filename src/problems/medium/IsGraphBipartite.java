package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 31-01-2021
 */
public class IsGraphBipartite {

    public static void main(String[] args) {

        IsGraphBipartite obj = new IsGraphBipartite();

        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(obj.isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {

        if(graph == null)
            return false;

        Map<Integer, int[]> adjList = new HashMap<>();
        for(int i=0 ; i<graph.length ; i++) {
            adjList.put(i, graph[i]);
        }

        return isBipartite(graph.length, adjList);
    }

    private boolean isBipartite(int nodes, Map<Integer, int[]> adjList) {

        int[] color = new int[nodes];
        Arrays.fill(color, -1);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<nodes ; i++) {

            if(color[i] == -1) {

                color[i] = 0;
                queue.add(i);
                while(!queue.isEmpty()) {

                    int current = queue.poll();
                    if(adjList.containsKey(current)) {

                        for(int adjNode : adjList.get(current)) {

                            if(color[adjNode] == -1) {
                                color[adjNode] = 1 - color[current];
                                queue.add(adjNode);
                            }
                            else if(color[adjNode] == color[current])
                                return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

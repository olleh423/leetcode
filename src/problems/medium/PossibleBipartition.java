package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 31-01-2021
 */
public class PossibleBipartition {

    public static void main(String[] args) {

        PossibleBipartition obj = new PossibleBipartition();

        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(obj.possibleBipartition(n, dislikes));
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {

        if(dislikes == null)
            return false;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] pair : dislikes) {

            if(!adjList.containsKey(pair[0]))
                adjList.put(pair[0], new ArrayList<>());

            if(!adjList.containsKey(pair[1]))
                adjList.put(pair[1], new ArrayList<>());

            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        return colorGraph(N, adjList);
    }

    private boolean colorGraph(int nodes, Map<Integer, List<Integer>> adjList) {

        int[] color = new int[nodes+1];
        Arrays.fill(color, -1);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1 ; i<=nodes ; i++) {

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

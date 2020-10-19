package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class CourseSchedule2 {

    public static void main(String[] args) {

        CourseSchedule2 obj = new CourseSchedule2();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] result = obj.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    public int[] findOrder(int n, int[][] pre) {

        if(pre == null)
            return null;

        Graph graph = new Graph();
        graph.setVerts(n);
        for(int[] pair : pre)
            graph.addEdge(pair[0], pair[1]);

        List<Integer> result = getOrder(graph);
        if(result.isEmpty())
            return new int[0];

        int[] arr = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++)
            arr[i] = result.get(i);

        return arr;
    }

    private List<Integer> getOrder(Graph graph) {

        List<Integer> result = new ArrayList<Integer>();

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int v : graph.verts) {
            if(!explore(v, graph, result, visiting, visited))
                return new ArrayList<Integer>();
        }
        return result;
    }

    private boolean explore(int v, Graph graph, List<Integer> result, Set<Integer> visiting, Set<Integer> visited) {

        if(visiting.contains(v))
            return false;
        if(visited.contains(v))
            return true;

        visiting.add(v);
        List<Integer> deps = graph.deps.getOrDefault(v, new ArrayList());
        for(int d : deps) {
            if(!explore(d, graph, result, visiting, visited))
                return false;
        }
        visiting.remove(v);
        visited.add(v);
        result.add(v);
        return true;
    }

    private static class Graph {

        public Set<Integer> verts;
        public Map<Integer, List<Integer>> deps;

        Graph() {
            verts = new HashSet<>();
            deps = new HashMap<>();
        }
        public void setVerts(int numOfVerts) {
            for(int i=0 ; i<numOfVerts ; i++)
                verts.add(i);
        }
        public void addEdge(Integer src, Integer dest) {

            if(!deps.containsKey(src))
                deps.put(src, new ArrayList<Integer>());
            if(!deps.containsKey(dest))
                deps.put(dest, new ArrayList<Integer>());

            deps.get(src).add(dest);
        }
    }
}

package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 24-11-2020
 */
public class CourseSchedule {

    public static void main(String[] args) {

        CourseSchedule obj = new CourseSchedule();
        int numCourses = 6;
        int[][] deps = {{1, 0}, {0, 2}, {0, 3}, {0, 4}, {3, 5}, {4, 1}};

        System.out.println(obj.canFinish(numCourses, deps));
    }

    public boolean canFinish(int numCourses, int[][] deps) {

        if(deps == null) return false;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] dep : deps) {
            if(!map.containsKey(dep[0]))
                map.put(dep[0], new ArrayList<Integer>());
            map.get(dep[0]).add(dep[1]);
        }

        boolean[] inStack = new boolean[numCourses];
        boolean[] isExplored = new boolean[numCourses];

        for(int key : map.keySet()) {
            if(!explore(key, inStack, isExplored, map))
                return false;
        }
        return true;
    }

    private boolean explore(int i, boolean[] inStack, boolean[] isExplored, Map<Integer, List<Integer>> map) {

        if(inStack[i]) return false;
        if(isExplored[i]) return true;

        inStack[i] = true;
        for(int n : map.getOrDefault(i, new ArrayList<>())) {
            if(!explore(n, inStack, isExplored, map))
                return false;
        }
        inStack[i] = false;
        isExplored[i] = true;
        return true;
    }
}

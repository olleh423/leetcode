package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FindAnagramMapping {

    public static void main(String[] args) {

        FindAnagramMapping obj = new FindAnagramMapping();

        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};

        System.out.println(Arrays.toString(obj.anagramMappings(A, B)));
    }

    public int[] anagramMappings(int[] A, int[] B) {

        if(A == null || B == null)
            return null;

        int n = A.length;
        int[] P = new int[n];

        Map<Integer, Queue<Integer>> mapA = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            if(!mapA.containsKey(A[i]))
                mapA.put(A[i], new LinkedList<>());
            mapA.get(A[i]).add(i);
        }

        for(int i=0 ; i<n ; i++) {
            P[mapA.get(B[i]).poll()] = i;
        }

        return P;
    }
}

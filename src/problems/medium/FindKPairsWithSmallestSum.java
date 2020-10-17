package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class FindKPairsWithSmallestSum {

    public static void main(String[] args) {

        FindKPairsWithSmallestSum obj = new FindKPairsWithSmallestSum();
    }

    private static class Pair {
        int a, b, total;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            this.total = a + b;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if(A == null || B == null || k == 0) return result;

        int totalPairs = A.length * B.length;
        Pair[] pairs = new Pair[totalPairs];

        int c = 0;
        for(int i=0 ; i<A.length ; i++) {
            for(int j=0 ; j<B.length ; j++)
                pairs[c++] = new Pair(A[i], B[j]);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.total - a.total);
        for(Pair p : pairs) {
            if(k > 0) {
                maxHeap.add(p);
                k--;
            }
            else if(maxHeap.peek().total > p.total) {
                maxHeap.poll();
                maxHeap.add(p);
            }
        }

        while(!maxHeap.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            Pair p = maxHeap.poll();
            row.add(p.a);
            row.add(p.b);
            result.add(row);
        }

        return result;
    }
}

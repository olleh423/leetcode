package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class KthSmallestElementInSortedMatrix {

    public static void main(String[] args) {

        KthSmallestElementInSortedMatrix obj = new KthSmallestElementInSortedMatrix();
    }

    private static class Bean {
        int value;
        int i, j;
        Bean(int value, int i, int j) {
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        if(matrix == null)
            return 0;

        PriorityQueue<Bean> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        for(int i=0 ; i<matrix.length ; i++)
            queue.add(new Bean(matrix[i][0], i, 0));

        while(k > 1) {

            Bean min = queue.poll();
            if(min.j+1 < matrix[min.i].length)
                queue.add(new Bean(matrix[min.i][min.j+1], min.i, min.j+1));
            k--;
        }

        return queue.poll().value;
    }
}

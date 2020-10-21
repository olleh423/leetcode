package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class MinimumCostToConnectSticks {

    public static void main(String[] args) {

        MinimumCostToConnectSticks obj = new MinimumCostToConnectSticks();
        int[] sticks = {1, 8, 3, 5};
        System.out.println(obj.connectSticks(sticks));
    }

    public int connectSticks(int[] sticks) {

        if(sticks == null)
            return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for(int stick : sticks)
            minHeap.add(stick);

        int totalCost = 0;
        while(minHeap.size() > 1) {
            int one = minHeap.poll();
            int two = minHeap.poll();
            totalCost += (one + two);
            minHeap.add(one + two);
        }

        return totalCost;
    }
}

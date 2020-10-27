package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class LastStoneWeight {

    public static void main(String[] args) {

        LastStoneWeight obj = new LastStoneWeight();

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(obj.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {

        if(stones == null || stones.length == 0)
            return 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for(int stone : stones)
            queue.add(stone);

        while(queue.size() > 1) {

            int a = queue.poll();
            int b = queue.poll();
            if(a != b) queue.add(a-b);
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}

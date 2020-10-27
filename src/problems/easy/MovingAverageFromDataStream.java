package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MovingAverageFromDataStream {

    public static void main(String[] args) {

        MovingAverageFromDataStream obj = new MovingAverageFromDataStream();
    }

    class MovingAverage {

        private int size;
        private int total;
        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            this.total = 0;
            this.queue = new LinkedList<>();
        }

        public double next(int val) {
            total += val;
            queue.add(val);
            if(queue.size() > size) {
                total -= queue.poll();
            }

            double n = queue.size();
            return (double)(total / n);
        }
    }
}

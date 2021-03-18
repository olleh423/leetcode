package problems.hard;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    public static void main(String[] args) {

        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(4);
        System.out.println(finder.findMedian());
    }

    private static class MedianFinder {

        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {

            maxHeap = new PriorityQueue<>();
            minHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        private void rebalance() {

            if(minHeap.size() - maxHeap.size() > 1)
                maxHeap.add(minHeap.poll());
            else if(maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.poll());
        }

        public void addNum(int num) {

            if(minHeap.size() == 0 || minHeap.peek() > num)
                minHeap.add(num);
            else
                maxHeap.add(num);

            rebalance();
        }

        public double findMedian() {

            if(maxHeap.size() == minHeap.size())
                return (double)(minHeap.peek() + maxHeap.peek()) / 2;

            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}

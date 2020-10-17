package problems.hard;

import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        SlidingWindowMaximum obj = new SlidingWindowMaximum();

        int[] arr = {1,3,-1,-3,5,3,6,7};
        int windowSize = 3;

        System.out.println(obj.maxSlidingWindow(arr, windowSize));
    }

    public int[] maxSlidingWindow(int[] arr, int k) {

        if(arr == null)
            return null;

        int[] res = new int[arr.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        int i=0, j=0, count=0;
        while(j < k) {

            if(queue.isEmpty())
                queue.add(j++);
            else if(arr[queue.getLast()] < arr[j])
                queue.removeLast();
            else
                queue.add(j++);
        }
        res[count++] = arr[queue.peek()];
        i++;

        while(j < arr.length) {

            if(queue.isEmpty()) {
                queue.add(j);
                res[count++] = arr[queue.peek()];
                i++; j++;
            }
            else if(queue.peek() < i) {
                queue.removeFirst();
            }
            else if(arr[queue.getLast()] < arr[j]) {
                queue.removeLast();
            }
            else {
                queue.add(j);
                res[count++] = arr[queue.peek()];
                i++; j++;
            }
        }

        return res;
    }
}

package problems.hard;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    private static class ListNode {
        int val;
        ListNode next;
    }

    static class HeapNode {
        int data;
        int row;
        HeapNode(int data, int row) {
            this.data = data;
            this.row = row;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        for(int i=0 ; i<lists.length ; i++) {
            if(lists[i] != null)
                minHeap.add(new HeapNode(lists[i].val, i));
        }

        ListNode head = null, result = null;

        while(! minHeap.isEmpty()) {

            HeapNode min = minHeap.poll();

            if(head == null) {
                head = result = lists[min.row];
            } else {
                result.next = lists[min.row];
                result = result.next;
            }

            lists[min.row] = lists[min.row] != null ? lists[min.row].next : null;

            if(lists[min.row] != null)
                minHeap.add(new HeapNode(lists[min.row].val, min.row));
        }

        return head;
    }
}

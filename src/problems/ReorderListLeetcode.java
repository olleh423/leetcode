package problems;
import java.util.*;

/*
 * Leetcode : 143
 */

public class ReorderListLeetcode {

	public static void main(String[] args) {
		
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		
		reorderList(node);
		showList(node);
	}
	
	private static void showList(ListNode node) {
		
		if(node == null) {
			
			System.out.println("NULL");
			return;
		}
		
		System.out.print(node.val + " -> ");
		showList(node.next);
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void reorderList(ListNode head) {
        
        if(head == null)
            return ;
        if(head.next == null || head.next.next == null)
            return;
        
        List<ListNode> list = new ArrayList<>();
        decompose(head, list);
        
        head = list.get(0);
        ListNode temp = head;
        boolean flag = true;
        int i=1, j=list.size() - 1;
        while(i <= j) {
            
            if(flag) temp.next = list.get(j--);
            else temp.next = list.get(i++);
            
            flag = !flag;
            temp = temp.next;
        }
        
        if(temp != null)
            temp.next = null;
    }
    
    private static void decompose(ListNode head, List<ListNode> list) {
        if(head == null)
            return;
        list.add(head);
        decompose(head.next, list);
    }
}

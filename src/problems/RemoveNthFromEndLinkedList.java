package problems;

public class RemoveNthFromEndLinkedList {
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode removeNthFromEnd(ListNode A, int B) {
        
        int count = 0;
        ListNode temp = A;
        
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        
        if(count < B) 
            return A;
            
        temp = A;
        while(count > 0) {
            temp = temp.next;
            count--;
        }
        
        temp.next = temp.next.next;
        return A;
    }
	
	private static void showList(ListNode head) {
		
		while(head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		showList(removeNthFromEnd(head, 2));
	}
}

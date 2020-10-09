package problems;

public class RotateLinkedList {

	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
    public int count(ListNode n, int count) {
        if(n == null) return count;
        return count(n.next, count+1);
    }
    
    public ListNode rotate(ListNode head, int k, int length) {
        
        int count = length - k;
        if(count == 0) return head;
        
        ListNode temp = head;
        while(count > 1) {
        	temp = temp.next;
        	count--;
        }
        ListNode node = temp.next ;
        temp.next = null;
        temp = node;
        while(temp != null && temp.next != null) {
        	temp = temp.next;
        }
        if(temp != null)
        	temp.next = head;
        return node;
    }
    
    public ListNode rotateRight(ListNode A, int B) {
        
        int count = count(A, 0);
        if(count == 0) return null;
        return rotate(A, B, count);
    }
    
    public void showList(ListNode node) {
    	
    	if(node == null) {
    		System.out.println("null");
    		return;
    	}
    	
    	System.out.print(node.val + " --> ");
    	showList(node.next);
    }
    
    public static void main(String[] args) {
    	
    	ListNode head = new ListNode(10);
    	//head.next = new ListNode(20);
    	//head.next.next = new ListNode(30);
    	//head.next.next.next = new ListNode(40);
    	//head.next.next.next.next = new ListNode(50);
    	
    	RotateLinkedList rll = new RotateLinkedList();
    	
    	rll.showList(rll.rotateRight(head, 1));
    }
}


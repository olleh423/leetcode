package problems;

/*
	https://www.interviewbit.com/problems/add-two-numbers-as-lists/
	
	You are given two linked lists representing two non-negative numbers. 
	The digits are stored in reverse order and each of their nodes contain a single digit. 
	Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8

	    342 + 465 = 807
	Make sure there are no trailing zeros in the output list
	So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
*/

public class AddTwoNumbersLinkedLIst {

	private static class Node {
		int value;
		Node next;
		Node(int value) {
			this.value = value;
		}
	}
	
	/*
	 * O(1) space
	 */
	private static Node addTwoNumbers(Node one, Node two, int c) {
		
		if(one == null && two == null)
			return c == 0 ? null : new Node(c);
		
		int value = (one == null ? 0 : one.value) + (two == null ? 0 : two.value) + c;
		
		Node head = new Node(value % 10);
		head.next = addTwoNumbers(one != null ? one.next : one, two != null ? two.next : two, value / 10);
		
		return head;
	}
	
	/*
	 * Implementation using stack with O(n) space
	 */
	private static Node addTwoNumbers(Node one, Node two) {
		
		java.util.Queue<Integer> stOne = new java.util.LinkedList<>();
		java.util.Queue<Integer> stTwo = new java.util.LinkedList<>();
		
		while(one != null || two != null) {
			
			if(one != null) {
				stOne.add(one.value);
				one = one.next;
			}
			if(two != null) {
				stTwo.add(two.value);
				two = two.next;
			}
		}
		
		Node head = null, temp = null;
		int carry = 0;
		
		while(!stOne.isEmpty() || !stTwo.isEmpty()) {
			
			int total = carry + (stOne.isEmpty() ? 0 : stOne.remove()) + (stTwo.isEmpty() ? 0 : stTwo.remove());
			carry = total > 9 ? 1 : 0;
			
			if(head == null) {
				head = new Node(total % 10);
				temp = head;
			} else {
				temp.next = new Node(total % 10);
				temp = temp.next;
			}
		}
		
		if(carry != 0) {
			temp.next = new Node(carry);
		}
		
		return head;
	}
	
	private static void showList(Node head) {
		
		while(head != null) {
			System.out.print(head.value + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		
		Node one = new Node(2);
		one.next = new Node(4);
		one.next.next = new Node(3);
		
		Node two = new Node(5);
		//two.next = new Node(6);
		//two.next.next = new Node(4);
		//two.next.next.next = new Node(3);
		
		showList(one);
		showList(two);
		
		//showList(addTwoNumbers(one, two));
		showList(addTwoNumbers(one, two, 0));
	}
}

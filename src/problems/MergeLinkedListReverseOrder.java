package problems;

public class MergeLinkedListReverseOrder {

	private static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	
	public static void merge(Node one, Node two) {
		
		Node n = new Node(-1);
		while(one.data != -1 || two.data != -1) {
			
			if(one.data == -1 && two.data != -1) {
				
				while(two.data != -1) {
					Node temp = new Node(two.data);
					temp.next = n;
					n = temp;
					two = two.next;
				}
				
				break;
			}
			
			if(two.data == -1 && one.data != -1) {
				
				while(one.data != -1) {
					Node temp = new Node(one.data);
					temp.next = n;
					n = temp;
					one = one.next;
				}
				
				break;
			}
			
			if(one.data > two.data) {
				
				Node temp = new Node(two.data);
				temp.next = n;
				n = temp;
				two = two.next;
				
			} else {
				
				Node temp = new Node(one.data);
				temp.next = n;
				n = temp;
				one = one.next;
			}
		}
		
		while(n.data != -1) {
			
			System.out.print(n.data + "  ");
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		
		Node one = new Node(2);
		one.next = new Node(5);
		one.next.next = new Node(8);
		one.next.next.next = new Node(12);
		one.next.next.next.next = new Node(-1);
		
		Node two = new Node(3);
		two.next = new Node(6);
		two.next.next = new Node(9);
		two.next.next.next = new Node(-1);
		
		merge(one, two);
	}
}

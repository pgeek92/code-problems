package datastructures.LinkedList;

public class OddEvenLinkedList {

	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param head
	 * @return
	 */
	public static Node oddEvenList(Node head) {
		Node odd = head;
		Node even = head.next;
		Node evenStart = even;
		
		// edge case/ corner case
		if(head == null || head.next == null) {
			return head;
		}
		
		while (odd.next != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenStart;
		return head;
	}
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 4);
		obj.addAtIndex(4, 5);
		
		MyLinkedList.printLinkedList(obj.head);
		MyLinkedList.printLinkedList(oddEvenList(obj.head));

	}

}

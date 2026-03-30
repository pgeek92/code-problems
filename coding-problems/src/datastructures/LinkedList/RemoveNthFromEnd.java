package datastructures.LinkedList;

public class RemoveNthFromEnd {

	/**
	 * Approach : Two-Pass Algorithm
	 * 			  a. Calculate the length of linked list - Pass 1
	 *            b. Reach the previous position to delete - Pass 2
	 * Drawback : List is traversed two times
	 * Space Complexity : O(1)
	 * Time Complexity : O(N)
	 * @param head
	 * @param n
	 * @return
	 */
	public static Node removeNthFromEndApr1(Node head, int n) {
		Node sentinel = new Node(0);
		sentinel.next = head;
		
		int length = 0;
		
		// First Pass
		while(head != null) {
			head = head.next;
			length++;
		}
		
		int prevNodePos = length - n;
		Node prev = sentinel;
		
		// Second Pass
		for(int i = 0; i < prevNodePos; i++) {
			prev = prev.next;
		}
		
		prev.next = prev.next.next;
		
		return sentinel.next;
	}
	
	/**
	 * Approach : One-Pass Algorithm
	 * Advantage : List is traversed one time only
	 * Space Complexity : O(1)
	 * Time Complexity : O(N)
	 * @param head
	 * @param n
	 * @return
	 */
	public static Node removeNthFromEndApr2(Node head, int n) {
		// Add sentinel node at the start
		Node sentinel = new Node(0);
		sentinel.next = head;
		
		// Move first pointer ahead of n
		Node first = sentinel;
		for(int i = 0; i < n; i++) {
			first = first.next;
		}
		
		// Move both the pointers until first pointer reaches the last node
		Node second = sentinel;
		while(first.next != null) {
			second = second.next;
			first = first.next;
		}
		
		// Delete the second.next
		second.next = second.next.next;
		
		return sentinel.next;
	}
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 4);
		obj.addAtIndex(4, 5);
		
		MyLinkedList.printLinkedList(obj.head);
		MyLinkedList.printLinkedList(removeNthFromEndApr1(obj.head, 3));
		MyLinkedList.printLinkedList(removeNthFromEndApr2(obj.head, 3));
	}

}

package datastructures.LinkedList;

public class MiddleNode {
	/**
	 * Approach : Fast and Slow Pointer (2 Pointer technique)
	 *            When traversing the list with a pointer @slowPointer, make another pointer @fastPointer that traverses twice
	 *            as fast. When @fastPointer reaches the end of the list, @slowPointer must be in the middle.
	 *            
	 *            When the list size is even, fastPointer != null condition is applicable
	 *            When the list size is odd, fastPointer.next != null condition is applicable
	 * Time Complexity : O(N)
	 * Space Complexity : O(1), space is used by slowPointer and fastPointer variables
	 * @link : https://leetcode.com/problems/middle-of-the-linked-list/description/
	 * @param head
	 * @return
	 */
	public static Node findMiddleNode(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		return slowPointer;
	}
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 4);
		obj.addAtIndex(4, 5);
		obj.addAtIndex(5, 6);
		obj.addAtIndex(6, 7);
		obj.addAtIndex(7, 8);
		obj.addAtIndex(8, 9);
		obj.addAtIndex(9, 10);
		obj.addAtIndex(10, 11);
		obj.addAtIndex(11, 12);
		
		System.out.println(obj.size);
		
		Node middleNode = findMiddleNode(obj.head);
		System.out.println(middleNode.data);
	}

}

package datastructures.LinkedList;

public class RemoveDuplicatesFromSortedList {

	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param head
	 * @return
	 */
	public static Node removeDuplicatesFromSortedList(Node head) {
		Node current = head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 2);
		obj.addAtIndex(3, 3);
		obj.addAtIndex(4, 4);
		
		MyLinkedList.printLinkedList(obj.head);
		MyLinkedList.printLinkedList(removeDuplicatesFromSortedList(obj.head));
	}
}

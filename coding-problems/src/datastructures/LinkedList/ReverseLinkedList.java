package datastructures.LinkedList;

public class ReverseLinkedList {
	
	/**
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @param head
	 * @return
	 */
	public static Node reverseLinkedList(Node head) {
		Node prev = null;
		Node curr = head;
		while(curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
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
		
		MyLinkedList.printLinkedList(reverseLinkedList(obj.head));
	}
}

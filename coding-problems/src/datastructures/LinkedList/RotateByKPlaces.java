package datastructures.LinkedList;

public class RotateByKPlaces {
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node rotateByKPlaces(Node head, int k) {
		// Base cases
		if(head == null) return null;
		if(head.next == null) return head;
		
		// calculate the length of the linked list
		int length = 0;
		Node curr = head;
		while(curr != null) {
			curr = curr.next;
			length++;
		}
		
		//if k >= n, then we should do the modulo to shrink the k, because after rotations length number of times, list become original - Important intuition
		k = k % length;
		
		Node slow = head;
		Node fast = head;
		
		for(int i = 0; i < k; i++) {
			fast = fast.next;
		}
		
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		fast.next = head;
		Node newHead = slow.next;
		slow.next = null;
		
		return newHead;
	}

	public static void main(String[] args) {
		MyLinkedList obj1 = new MyLinkedList();
		obj1.addAtIndex(0, 2);
		obj1.addAtIndex(1, 5);
		obj1.addAtIndex(2, 7);
		obj1.addAtIndex(3, 8);
		
		int k = 1;
		
		MyLinkedList.printLinkedList(obj1.head);
		MyLinkedList.printLinkedList(rotateByKPlaces(obj1.head, k));

	}

}

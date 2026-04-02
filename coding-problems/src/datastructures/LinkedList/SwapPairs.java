package datastructures.LinkedList;

public class SwapPairs {
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param head
	 * @return
	 */
	public static Node swapPairsIterativeApr(Node head) {
		if(head == null || head.next == null) return head;
		
		Node sentinel = new Node(0);
		sentinel.next = head;
		
		Node prev = sentinel;
		Node curr = head;
		Node next = head.next;
		
		while(curr != null && next != null) {
			prev.next = next;
			curr.next = next.next;
			next.next = curr;
			
			prev = curr;
			curr = prev.next;
			if(curr != null) {
				next = curr.next;
			}
		}
		
		return sentinel.next;
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(N) -> Recursive calls has to be stored in Stack frames of size of linked list
	 * @param head
	 * @return
	 */
	public static Node swapPairsRecursiveApr(Node head) {
		if(head == null || head.next == null) return head;
		
		Node left = head;
		Node right = head.next;
		
		left.next = swapPairsRecursiveApr(right.next);
		right.next = left;
		
		return right;
	}
	
	public static void main(String[] args) {
		MyLinkedList obj1 = new MyLinkedList();
		obj1.addAtIndex(0, 2);
		obj1.addAtIndex(1, 5);
		obj1.addAtIndex(2, 7);
		obj1.addAtIndex(3, 8);
		
		MyLinkedList.printLinkedList(obj1.head);
		MyLinkedList.printLinkedList(swapPairsIterativeApr(obj1.head));
		
		MyLinkedList obj2 = new MyLinkedList();
		obj2.addAtIndex(0, 1);
		obj2.addAtIndex(1, 2);
		obj2.addAtIndex(2, 3);
		obj2.addAtIndex(3, 4);
		MyLinkedList.printLinkedList(obj2.head);
		MyLinkedList.printLinkedList(swapPairsRecursiveApr(obj2.head));	
	}
}

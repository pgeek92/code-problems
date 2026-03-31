package datastructures.LinkedList;

public class AddTwoNumbers {
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static Node addTwoNumbers(Node l1, Node l2) {
		Node sentinel = new Node(0);
		Node current = sentinel;
		int carry = 0;
		
		while(l1 != null || l2 != null || carry != 0) {
			int x = (l1 != null) ? l1.data : 0;
			int y = (l2 != null) ? l1.data : 0;
			
			int sum = x + y + carry;
			carry = sum / 10;
			current.next = new Node(sum % 10);
			current = current.next;
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		
		return sentinel.next;
	}

	public static void main(String[] args) {
		MyLinkedList obj1 = new MyLinkedList();
		obj1.addAtIndex(0, 1);
		obj1.addAtIndex(1, 2);
		obj1.addAtIndex(2, 3);
		obj1.addAtIndex(3, 4);
		obj1.addAtIndex(4, 5);
		
		MyLinkedList.printLinkedList(obj1.head);
		
		MyLinkedList obj2 = new MyLinkedList();
		obj2.addAtIndex(0, 1);
		obj2.addAtIndex(1, 2);
		obj2.addAtIndex(2, 3);
		obj2.addAtIndex(3, 4);
		obj2.addAtIndex(4, 5);
		
		MyLinkedList.printLinkedList(obj2.head);
		MyLinkedList.printLinkedList(addTwoNumbers(obj1.head, obj2.head));

	}

}

package datastructures.LinkedList;

public class MergeTwoSortedList {
	
	/**
	 * Time Complexity : O(M+N)
	 * Space Complexity : O(1)
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static Node mergeTwoSortedList(Node list1, Node list2) {
		Node sentinel = new Node(-1);
		Node prev = sentinel;
		
		while(list1 != null && list2 != null) {
			if(list1.data <= list2.data) {
				prev.next = list1;
				list1 = list1.next;
			} else {
				prev.next = list2;
				list2 = list2.next;
			}
			
			prev = prev.next;
		}
		
		if(list1 == null) {
			prev.next = list2;
		} else {
			prev.next = list1;
		}
		
		return sentinel.next;
	}

	public static void main(String[] args) {
		MyLinkedList obj1 = new MyLinkedList();
		obj1.addAtIndex(0, 2);
		obj1.addAtIndex(1, 5);
		obj1.addAtIndex(2, 7);
		obj1.addAtIndex(3, 8);
		
		MyLinkedList.printLinkedList(obj1.head);
		
		MyLinkedList obj2 = new MyLinkedList();
		obj2.addAtIndex(0, 1);
		obj2.addAtIndex(1, 3);
		obj2.addAtIndex(2, 4);
		obj2.addAtIndex(3, 6);
		obj2.addAtIndex(4, 9);
		
		MyLinkedList.printLinkedList(obj2.head);
		MyLinkedList.printLinkedList(mergeTwoSortedList(obj1.head, obj2.head));

	}

}

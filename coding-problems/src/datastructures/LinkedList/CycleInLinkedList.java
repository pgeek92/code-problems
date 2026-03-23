package datastructures.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 *
 */
public class CycleInLinkedList {
	public static boolean hasCycle(Node head) {
		Set<Node> nodeSeen = new HashSet<Node>();
		Node current = head;
		while(current != null) {
			if(nodeSeen.contains(current)) {
				return true;
			}
			nodeSeen.add(current);
			current = current.next;
		}
		return false;
	}
	
	/**
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * @param head
	 * @return
	 */
	public static boolean hasCycleFloyd(Node head) {
		if(head == null) {
			return false;
		}
		
		Node slow = head;
		Node fast = head.next;
		while(slow != fast) {
			if(fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	
	public static void main (String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 4);
		obj.addAtIndex(4, 5);
		
		obj.head.next.next.next.next.next = obj.head.next.next;
		
		System.out.println(hasCycle(obj.head));
		System.out.println(hasCycleFloyd(obj.head));
	}
}

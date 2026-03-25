package datastructures.LinkedList;

public class RemoveElementsFromLinkedList {

	/**
	 * Approach 1 : Sentinel Node
	 * 				The problem seems to be very easy if one has to delete a node in the middle:
	 * 					- Pick the node-predecessor prev of the node to delete.
	 *				    - Set its next pointer to point to the node next to the one to delete.
	 *              Things are more complicated when the node or nodes to delete are in the head of the linked list.
	 *              How to deal with that? To reduce the problem
	 *              to the deletion of middle nodes with the help of sentinel node.
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param head
	 * @param val
	 * @return
	 */
	public static Node removeElements(Node head, int val) {
        Node sentinel = new Node(0);
        sentinel.next = head;
        
        Node prev = sentinel; 
        Node curr = head;
        while (curr != null) {
          if (curr.data == val) {
        	  prev.next = curr.next;
          }
          else {
        	  prev = curr;
          }
          curr = curr.next;
        }
        return sentinel.next;
    }
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		/*obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 6);
		obj.addAtIndex(3, 3);
		obj.addAtIndex(4, 4);
		obj.addAtIndex(5, 5);
		obj.addAtIndex(6, 6);*/
		
		/*obj.addAtIndex(0, 3);
		obj.addAtIndex(1, 3);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 3);
		obj.addAtIndex(4, 4);
		obj.addAtIndex(5, 5);*/
		
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 4);
		obj.addAtIndex(4, 4);
		obj.addAtIndex(5, 4);
		MyLinkedList.printLinkedList(obj.head);
		MyLinkedList.printLinkedList(removeElements(obj.head, 4));
	}

}

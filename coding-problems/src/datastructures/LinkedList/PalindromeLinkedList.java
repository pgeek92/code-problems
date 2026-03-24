package datastructures.LinkedList;

public class PalindromeLinkedList {
	/**
	 * Approach : Used In-place Algorithm
	 *            Intuition
	 *            
	 *            The only way we can avoid using O(n) extra space is by modifying the input in-place.

	 *            The strategy we can use is to reverse the second half of the Linked List in-place (modifying the Linked List structure), 
	 *            and then comparing it with the first half. Afterwards, we should re-reverse the second half and put the list back together. 
	 *            While you don't need to restore the list to pass the test cases, it is still good programming practice because the function could be a part 
	 *            of a bigger program that doesn't want the Linked List broken.
	 *            
	 *            Algorithm
	 *            Specifically, the steps we need to do are:
	 *            
	 *            Find the end of the first half.
	 *            Reverse the second half.
	 *            Determine whether or not there is a palindrome.
	 *            Restore the list.
	 *            Return the result.
	 *            To do step 1, we could count the number of nodes, calculate how many nodes are in the first half, and then iterate back down the list to 
	 *            find the end of the first half. Or, we could do it in a single parse using the two runners pointer technique. Either is acceptable, 
	 *            however we'll have a look at the two runners pointer technique here.
	 *            
	 *            Imagine we have 2 runners one fast and one slow, running down the nodes of the Linked List. In each second, the fast runner moves down 2 nodes, 
	 *            and the slow runner just 1 node. By the time the fast runner gets to the end of the list, the slow runner will be half way. 
	 *            By representing the runners as pointers, and moving them down the list at the corresponding speeds, we can use this trick to find the middle of 
	 *            the list, and then split the list into two halves.
	 *            
	 *            If there is an odd-number of nodes, then the "middle" node should remain attached to the first half.
	 *            
	 *            Step 2 uses the algorithm that can be found in the solution article for the Reverse Linked List problem to reverse the second half of the list.
	 *            
	 *            Step 3 is fairly straightforward. Remember that we have the first half, which might also contain a "middle" node at the end, and the second half, 
	 *            which is reversed. We can step down the lists simultaneously ensuring the node values are equal. When the node we're up to in the second list is null, 
	 *            we know we're done. If there was a middle value attached to the end of the first list, it is correctly ignored by the algorithm. The result should 
	 *            be saved, but not returned, as we still need to restore the list.
	 *            
	 *            Step 4 requires using the same function you used for step 2, and then for step 5 the saved result should be returned.
	 *            
	 *            The downside of this approach is that in a concurrent environment (multiple threads and processes accessing the same data), 
	 *            access to the Linked List by other threads or processes would have to be locked while this function is running, 
	 *            because the Linked List is temporarily broken. This is a limitation of many in-place algorithms though.
	 *            
	 *            Time Complexity : O(n)
	 *            Space Complexity : O(1)
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(Node head) {
		// Finding the middle of the linked list 
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Reverse the second half of the linked list
		Node prev = null;
		while(slow != null) {
			Node temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}
		
		// compare the values of both the linked list (first half & second half)
		Node firstHalfLinkedList = head;
		Node secondHalfLinkedList = prev;
		
		while(secondHalfLinkedList != null) {
			if(firstHalfLinkedList.data != secondHalfLinkedList.data) {
				return false;
			}
			
			firstHalfLinkedList = firstHalfLinkedList.next;
			secondHalfLinkedList = secondHalfLinkedList.next;
		}
		
		return true;
	}
	
	public static void main (String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 2);
		obj.addAtIndex(4, 4);
		
		System.out.println(isPalindrome(obj.head));
	}
}

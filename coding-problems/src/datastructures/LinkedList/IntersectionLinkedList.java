package datastructures.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList {
	
	/**
	 * Approach 1 : Brute Force
	 * 				Compare each and every node of linked list 1 with linked list 2
	 * Time Complexity : O(M*N)
	 * Space Complexity : O(1)
	 * M = length of linked list 1
	 * N = length of linked list 2
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static Node getIntersectionNodeApr1(Node headA, Node headB) {
		while(headA != null) {
			Node pointerB = headB;
			while(pointerB != null) {
				if(headA == pointerB) {
					return headA;
				}
				pointerB = pointerB.next;
			}
			headA = headA.next;
		}
		return null;
	}
	
	/**
	 * Approach 2 : Hash Table
	 * 				Traverse list B and store the address/reference of each node in a hash table. 
	 *              Then for each node in list A, check whether or not that node exists in the hash table. 
	 *              If it does, return it as it must be the intersection node. If we get to the end of 
	 *              list A without finding an intersection node, return null.
	 *              The one thing we need to be careful of is that we're comparing objects of type Node. 
	 *              We don't want to compare the values within the nodes; doing this would cause our code 
	 *              to break when two different nodes have the same value.
	 * Time Complexity : O(M+N)
	 * Space Complexity : O(M)
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static Node getIntersectionNodeApr2(Node headA, Node headB) {
		Set<Node> nodesInB = new HashSet<Node>();

        while(headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }

        while(headA != null) {
            if(nodesInB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }

        return null;
	}
	
	/**
	 * Approach 3 : Two Pointers
	 * 				While list A and list B could be different lengths, that the shared "tail" 
	 *              following the intersection has to be the same length. Because the "tails" must be 
	 *              the same length, we can conclude that if there is an intersection, 
	 *              then the intersection node will be one of these 5 possibilities.
	 *              So, to check for each of these pairs, we would start by setting a pointer at the 
	 *              start of the shorter list, and a pointer at the first possible matching node of the 
	 *              longer list. The position of this node is simply the difference between the two lengths, 
	 *              that is, M−N.
	 * Time Complexity : O(M + N)
	 * Space Complexity : O(1)             
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static Node getIntersectionNodeApr3(Node headA, Node headB) {
		Node pointerA = headA;
		Node pointerB = headB;
		while(pointerA != pointerB) {
			if(pointerA == null) {
				pointerA = headB;
			} else {
				pointerA = pointerA.next;
			}
			
			if(pointerB == null) {
				pointerB = headA;
			} else {
				pointerB = pointerB.next;
			}
		}
		
		return pointerA;
	}

	public static void main(String[] args) {
		MyLinkedList objA = new MyLinkedList();
		objA.addAtIndex(0, 1);
		objA.addAtIndex(1, 2);
		objA.addAtIndex(2, 3);
		objA.addAtIndex(3, 4);
		objA.addAtIndex(4, 5);
		
		MyLinkedList objB = new MyLinkedList();
		objB.addAtIndex(0, 10);
		objB.addAtIndex(1, 11);
		objB.addAtIndex(2, 12);
		objB.head.next.next.next = objA.head.next.next;
		objB.head.next.next.next.next = objA.head.next.next.next;
		objB.head.next.next.next.next.next = objA.head.next.next.next.next;
		
		MyLinkedList.printLinkedList(objA.head);
		MyLinkedList.printLinkedList(objB.head);
		
		System.out.println(getIntersectionNodeApr1(objA.head, objB.head).data);
		System.out.println(getIntersectionNodeApr2(objA.head, objB.head).data);
		System.out.println(getIntersectionNodeApr3(objA.head, objB.head).data);
	}
}

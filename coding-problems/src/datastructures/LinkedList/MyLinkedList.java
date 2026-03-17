package datastructures.LinkedList;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class MyLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		
		printLinkedList(head);
		
		head = addAtHead(head, 5);
		
		printLinkedList(head);
		
		head = addAtTail(head, 50);
		
		printLinkedList(head);
	}
	
	public static void printLinkedList(Node head) {
		Node current = head;
		
		while(current != null) {
			System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
	}
	
	public static Node addAtHead(Node head, int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		return newNode;
	}
	
	public static Node addAtTail(Node head, int val) {
		Node newNode = new Node(val);
		if(head == null) {
			return newNode;
		}
		
		Node last = head;
		
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = newNode;
		return head;
	}
}

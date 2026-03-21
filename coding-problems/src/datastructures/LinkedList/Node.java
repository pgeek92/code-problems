package datastructures.LinkedList;

public class Node {
	int data;
	Node next;
	Node () {
		
	}
	
	Node (int data) {
		this.data = data;
		this.next = null;
	}
	
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

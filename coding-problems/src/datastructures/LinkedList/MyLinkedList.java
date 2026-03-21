package datastructures.LinkedList;

public class MyLinkedList {
	
	protected Node head;
	protected int size;
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	
	public int get(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}
		
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		return curr.data;
	}
	
	public void addAtHead(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void addAtTail(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}
	
	
	public void addAtIndex(int index, int val) {
		if (index < 0 || index > size) return;
        if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            Node node = new Node(val);
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            node.next = curr.next;
            curr.next = node;
            size++;
        }
	}
	
	public void deleteAtIndex(int index) {
		if (index < 0 || index >= size) return;
        if (index == 0) head = head.next;
        else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            curr.next = curr.next.next;
        }
        size--;
	}
	
	public static void printLinkedList(Node head) {
		while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("nullptr");
	}
	
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		
		myLinkedList.addAtIndex(0, 1);
		printLinkedList(myLinkedList.head);
		
		myLinkedList.addAtIndex(1, 2);
		printLinkedList(myLinkedList.head);
		
		myLinkedList.addAtIndex(2, 3);
		printLinkedList(myLinkedList.head);
		
		myLinkedList.addAtIndex(3, 4);
		printLinkedList(myLinkedList.head);
		
		printLinkedList(myLinkedList.head);
		
		myLinkedList.addAtHead(0);
		printLinkedList(myLinkedList.head);
		
		System.out.println(myLinkedList.size);
		
		myLinkedList.addAtTail(5);
		printLinkedList(myLinkedList.head);
		
		System.out.println(myLinkedList.size);
		
		int val = 3, index = 3;
		myLinkedList.addAtIndex(index, val);
		printLinkedList(myLinkedList.head);
		
		myLinkedList.deleteAtIndex(3);
        printLinkedList(myLinkedList.head);
	}
}
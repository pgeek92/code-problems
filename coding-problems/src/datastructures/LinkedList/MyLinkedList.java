package datastructures.LinkedList;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class MyLinkedList {
	int size;
	Node head;
	
	public MyLinkedList() {
		size = 0;
		head = new Node(0);
	}
	
	public int get(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}
		
		Node curr = head;
		for(int i = 0; i < index + 1; i++) {
			curr = curr.next;
		}
		return curr.data;
	}
	
	public void addAtHead(int val) {
		addAtIndex(0, val);
	}
	
	
	public void addAtTail(int val) {
		addAtIndex(size, val);
	}
	
	
	public void addAtIndex(int index, int val) {
		if (index > size) return;
		if (index < 0) index = 0;
		++size;
		
		Node pred = head;
		for(int i = 0; i < index; i++) {
			pred = pred.next;
		}
		
		Node toAdd = new Node(val);
		toAdd.next = pred.next;
		pred.next = toAdd;
	}
	
	public void printLinkedList() {
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
	
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 1);
		obj.addAtIndex(1, 2);
		obj.addAtIndex(2, 3);
		obj.addAtIndex(3, 4);
		
		int value = obj.get(0);
		System.out.println(value);
		
		obj.printLinkedList();
	}
}
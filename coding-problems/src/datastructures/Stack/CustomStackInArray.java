package datastructures.Stack;

public class CustomStackInArray {

	public static void main(String[] args) throws Exception {
		MyStack myStack = new MyStack(4);
		myStack.push(5);
		myStack.push(10);
		myStack.push(15);
		System.out.println(myStack.peek());
		System.out.println(myStack.pop());
		System.out.println(myStack.peek());
		myStack.push(20);
		System.out.println(myStack.size());
	}
}

class MyStack {
	int capacity;
	int top;
	int[] arr;
	
	public MyStack(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.arr = new int[capacity];
	}
	
	public void push(int element) throws Exception {
		if(capacity == (top + 1)) {
			throw new Exception("Stack Overflow");
		}
		
		top += 1;
		arr[top] = element;
	}
	
	public int pop() throws Exception {
		if(top == -1) {
			throw new Exception("Stack Underflow");
		}
		
		int result = arr[top];
		top -= 1;
		return result;
	}
	
	public int peek() throws Exception {
		if(top == -1) {
			throw new Exception("Stack Underflow");
		}
		
		return arr[top];
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
}

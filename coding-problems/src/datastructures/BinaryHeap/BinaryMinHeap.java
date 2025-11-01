package datastructures.BinaryHeap;

import java.util.Arrays;

public class BinaryMinHeap {
	private int[] heap;
	private int size;
	private int capacity;
	
	public BinaryMinHeap(int capacity) {
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.size = 0;
	}
	
	/**@param : int i
	 * @implNote : Method to get the index of the parent of a given node
	 * @return : int
	 */
	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	/**@param : int i
	 * @description : Method to get the index of the left child of a given node
	 * @return : int
	 */
	private int leftChild(int i) {
		return 2 * i + 1;
	}
	
	/**@param : int i
	 * @implNote : Method to get the index of the right child of a given node
	 * @return : int
	 */
	private int rightChild(int i) {
		return 2 * i + 2;
	}
	
	/**@param : int i, int j
	 * @implNote : Method to swap two elements in the heap array 
	 */
	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	/**@implNote: Method to resize the heap array when capacity is reached 
	 */
	private void resize() {
		capacity *= 2;
		heap = Arrays.copyOf(heap, capacity);
	}
	
	/**
	 * Method to insert a new value into the heap
	 * @param value
	 */
	public void insert(int value) {
		if(size >= capacity) {
			// Resize the heap if capacity is reached
			resize();
		}
		
		// Place the new value at the end of the heap
		heap[size] = value;
		
		// Index of the newly added element
		int current = size;
		
		// Incease the size of the heap
		size++;
		
		// Restore the heap property by "heapifying up"
		while (current > 0 && heap[current] < heap[parent(current)]) {
			// Swap with the parent if smaller
			swap(current, parent(current));
			
			// Move up to the parent's position
			current = parent(current);
		}
	}
	
	private void heapifyDownIterative(int i) {
		while(true) {
			int smallest = i;
			
			int left = leftChild(i);
			
			int right = rightChild(i);
			
			if(left < size && heap[left] < heap[smallest]) {
				smallest = left;
			}
			
			if(right < size && heap[right] < heap[smallest]) {
				smallest = right;
			}
			
			if(smallest == i) {
				break;
			}
			
			swap(i, smallest);
			
			i = smallest;
		}
	}
	
	/**
	 * Method to restore the heap property by "heapifying down" from a given index
	 * @param i
	 */
	private void heapifyDown(int i) {
		// Assume the current index is the smallest
		int smallest = i;
		
		// Get the left child index
		int left = leftChild(i);
		
		// Get the right child index
		int right = rightChild(i);
		
		// If the left child is smaller than the current smallest element, update smallest
		if(left < size && heap[left] < heap[smallest]) {
			smallest = left;
		}
		
		// If the right child is smaller than the current smallest element, update smallest
		if(right < size && heap[right] < heap[smallest]) {
			smallest = right;
		}
		
		// If the smallest element is not the current element, swap and continue the heapifying down
		if(smallest != i) {
			swap(i, smallest);
			heapifyDown(smallest);
		}
	}
	
	/**
	 * Method to extract the minimum element from the heap
	 * @return
	 */
	public int extractMin() {
		if(size == 0) {
			// Check if the heap is empty
			throw new RuntimeException("Heap is empty!");
		}
		
		// The root of the heap is the minimum element
		int min = heap[0];
		
		// Replace the root with the last element in the heap
		heap[0] = heap[size - 1];
		size--;
		
		// Restore the heap property by "heapifying down" from the root
		heapifyDown(0);
		
		// Return the extracted minimum element
		return min;
	}
	
	private void decreaseKey(int i, int x) {
		heap[i] = x;
		
		while(i != 0 && heap[i] < heap[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	private void deleteElement(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	private void buildHeap() {
		size = heap.length;
		for(int i = (size - 2) / 2; i >= 0; i--) {
			heapifyDown(i);
		}
	}
	
	public void printHeap() {
		System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
	}
	
	public static void main(String[] args) {
		BinaryMinHeap binaryHeap = new BinaryMinHeap(10);
		binaryHeap.insert(10);
		binaryHeap.insert(20);
		binaryHeap.insert(30);
		binaryHeap.insert(40);
		binaryHeap.insert(50);
		binaryHeap.insert(35);
		binaryHeap.insert(38);
		binaryHeap.insert(45);

		System.out.println("Heap after inserting elements:");
		binaryHeap.printHeap();
		
		binaryHeap.deleteElement(3);
		
		binaryHeap.printHeap();
		
		binaryHeap = new BinaryMinHeap(6);
		binaryHeap.heap[0] = 10;
		binaryHeap.heap[1] = 5;
		binaryHeap.heap[2] = 20;
		binaryHeap.heap[3] = 2;
		binaryHeap.heap[4] = 4;
		binaryHeap.heap[5] = 8;
		binaryHeap.buildHeap();
		
		binaryHeap.printHeap();
	}
}

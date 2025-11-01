package datastructures.BinaryHeap;

import java.util.Arrays;

public class BinaryMaxHeap {
	private int[] heap;
	private int size;
	private int capacity;
	
	public BinaryMaxHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.heap = new int[capacity];
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
		while (current > 0 && heap[current] > heap[parent(current)]) {
			// Swap with the parent if smaller
			swap(current, parent(current));
			
			// Move up to the parent's position
			current = parent(current);
		}
	}
	
	private void heapifyDownIterative(int i) {
		while(true) {
			int largest = i;
			
			int left = leftChild(i);
			
			int right = rightChild(i);
			
			if(left < size && heap[left] > heap[largest]) {
				largest = left;
			}
			
			if(right < size && heap[right] > heap[largest]) {
				largest = right;
			}
			
			if(largest == i) {
				break;
			}
			
			swap(i, largest);
			
			i = largest;
		}
	}
	
	/**
	 * Method to restore the heap property by "heapifying down" from a given index
	 * @param i
	 */
	private void heapifyDown(int i) {
		// Assume the current index is the smallest
		int largest = i;
		
		// Get the left child index
		int left = leftChild(i);
		
		// Get the right child index
		int right = rightChild(i);
		
		// If the left child is smaller than the current smallest element, update smallest
		if(left < size && heap[left] > heap[largest]) {
			largest = left;
		}
		
		// If the right child is smaller than the current smallest element, update smallest
		if(right < size && heap[right] > heap[largest]) {
			largest = right;
		}
		
		// If the smallest element is not the current element, swap and continue the heapifying down
		if(largest != i) {
			swap(i, largest);
			heapifyDown(largest);
		}
	}
	
	/**
	 * Method to extract the maximum element from the heap
	 * @return
	 */
	public int extractMax() {
		if(size == 0) {
			// Check if the heap is empty
			throw new RuntimeException("Heap is empty!");
		}
		
		// The root of the heap is the minimum element
		int max = heap[0];
		
		// Replace the root with the last element in the heap
		heap[0] = heap[size - 1];
		size--;
		
		// Restore the heap property by "heapifying down" from the root
		heapifyDown(0);
		
		// Return the extracted minimum element
		return max;
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
		BinaryMaxHeap binaryMaxHeap = new BinaryMaxHeap(10);
		binaryMaxHeap.insert(50);
		binaryMaxHeap.insert(52);
		binaryMaxHeap.printHeap();
		System.out.println(binaryMaxHeap.extractMax());
		binaryMaxHeap.printHeap();
	}
}

package datastructures.BinaryHeap;

public class MinHeap {
	int [] arr;
	int size;
	int capacity;
	
	public MinHeap(int c) {
		this.arr = new int[c];
		this.size = 0;
		this.capacity = c;
	}
	
	int[] initialize(int c) {
		for(int i = 0;i < c; i++) {
			this.arr[i] = 10+i;
		}
		return this.arr;
	}
	
	int left(int i) {
		return this.arr[2*i + 1];
	}
	int right(int i) {
		return this.arr[2*i + 2];
	}
	int parent(int i) {
		return this.arr[(i - 1) / 2];
	}
}



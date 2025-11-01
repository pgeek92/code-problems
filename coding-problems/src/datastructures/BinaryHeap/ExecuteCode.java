package datastructures.BinaryHeap;

public class ExecuteCode {
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(6);
		int[] array = minHeap.initialize(6);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		int left = minHeap.right(1);
		System.out.println(left);
	}
}

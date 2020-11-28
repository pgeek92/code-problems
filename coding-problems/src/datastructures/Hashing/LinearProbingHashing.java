/**
 * Basic implementation of Linear Probing
 * -1 represents empty slot in array
 * -2 represents deleted slot in array
 * 
 * If -1 and -2 considered as a keys in an array, then we need to create a dummy node to reference this in the 
 * array, in case of deletion. Each time we have to check for 'Deleted' we have to check for this deleted node
 * 
 */
package datastructures.Hashing;

import java.util.Arrays;

public class LinearProbingHashing {
	static int capacity;
	static int[] arr;
	static int size;
	public static void main(String[] args) {
		initialize(7);
		insert(49);
		insert(50);
		insert(63);
		insert(64);
		insert(68);
		insert(69);
		
		Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
		System.out.println();
		System.out.println(search(65));
		
		System.out.println(delete(69));
		
		Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
	}
	
	private static void initialize(int c) {
		capacity = c;
		size = 0;
		arr = new int[capacity];
		Arrays.fill(arr, -1);
	}
	
	private static int hashFunc(int key) {
		return key % capacity;
	}
	
	private static boolean search(int key) {
		int h = hashFunc(key);
		int i = h;
		while (arr[i] != -1) {
			if(arr[i] == key) {
				return true;
			}
			i = (i+1) % capacity;
			if(i == h) {
				return false;
			}
		}
		return false;
	}
	
	private static boolean insert(int key) {
		if(size == capacity) {
			return false;
		}
		
		int i = hashFunc(key);
		while(arr[i] != -1 && arr[i] != -2 && arr[i] != key) {
			i = (i+1) % capacity;
		}
		
		if(arr[i] == key) {
			return false;
		} else {
			arr[i] = key;
			size++;
			return true;
		}	
	}
	
	private static boolean delete(int key) {
		int h = hashFunc(key);
		int i = h;
		while (arr[i] != -1) {
			if(arr[i] == key) {
				arr[i] = -2;
				return true;
			}
			
			i = (i+1) % capacity;
			if(i == h) {
				return false;
			}
		}
		return false;
	}
}

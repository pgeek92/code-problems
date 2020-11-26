package datastructures.Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
	static int BUCKET;
	static ArrayList<LinkedList<Integer>> table;
	
	private static void initialize(int b) {
		BUCKET = b;
		table = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i < b; i++) {
			table.add(new LinkedList<Integer>());
		}
	}
	
	private static void insert(int key) {
		int i = key % BUCKET;
		table.get(i).add(key);
	}
	
	private static void delete(int key) {
		int i = key % BUCKET;
		table.get(i).remove((Integer) key);
	}
	
	private static boolean search(int key) {
		int i = key % BUCKET;
		return table.get(i).contains(key);
	}
	
	public static void main(String[] args) {
		initialize(7);
		insert(70);
		insert(71);
		insert(56);
		insert(9);
		insert(72);
		
		System.out.println(table);
		
		System.out.println(search(57));
	}
}

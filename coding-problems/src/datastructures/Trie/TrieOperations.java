package datastructures.Trie;

public class TrieOperations {
	static class TrieNode {
		boolean isEnd;
		// Here We're considering only 26 lowercase english alphabets
		TrieNode[] child = new TrieNode[26];
	}
	
	static TrieNode root;
	
	static boolean search(String key) {
		TrieNode curr = root;
		for(int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if(curr.child[index] == null) {
				return false;
			}
			curr = curr.child[index];
		}
		return curr.isEnd;
	}
	
	static void insert(String key) {
		TrieNode curr = root;
		for(int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if(curr.child[index] == null) {
				curr.child[index] = new TrieNode();
			}
			curr = curr.child[index];
		}
		curr.isEnd = true;
	}
	
	static TrieNode delete(TrieNode root, String key, int i) {
		if(root == null) {
			return null;
		}
		
		if(i == key.length()) {
			root.isEnd = false;
			if(isEmpty(root)) {
				root = null;
			}
			return root;
		}
		
		int idx = key.charAt(i) - 'a';
		root.child[idx] = delete(root.child[idx], key, i+1);
		
		if(isEmpty(root) && root.isEnd == false) {
			root = null;
		}
		return root;
	}
	
	static boolean isEmpty(TrieNode root) {
		for(int i = 0;i < 26; i++) {
			if(root.child[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String key = "geek";
		root = new TrieNode();
		insert("geek");
		insert("geeks");
		System.out.println(search("geek"));
		delete(root, key, 0);
	}
}

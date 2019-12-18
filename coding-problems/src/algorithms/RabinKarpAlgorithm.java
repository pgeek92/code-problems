/**
 * Time complexity in worst case O(n^2)(depends on hash function)
 * Space complexity O(1)
 *
 * References
 * https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm
 * 
 * https://www.youtube.com/watch?v=H4VrKHVG5qI&t=15s
 * 
 */
package algorithms;

public class RabinKarpAlgorithm {

	private static int prime = 101;
	
	public static int patternSearch(String text, String pattern) {
		char[] textArr = text.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int patternLength = patternArr.length;
		int textLength = textArr.length;
		
		long patternHash = createHash(patternArr, patternLength);
		long textHash = createHash(textArr, patternLength);
		
		for(int i = 1; i <= (textLength - patternLength + 1); i++) {
			if(patternHash == textHash && checkEqual(textArr, i - 1, i + patternLength - 2, patternArr, 0, patternLength - 1)) {
				return i - 1;
			}
			if(i < textLength - patternLength + 1) {
                textHash = recalculateHash(textArr, i - 1, i + patternLength - 1, textHash, patternLength);
            }
		}
		return -1;
	}
	
	private static long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash/prime;
        newHash += str[newIndex]*Math.pow(prime, patternLength - 1);
        return newHash;
    }
	
	private static long createHash(char[] str, int end) {
		long hash = 0;
		for(int i = 0; i < end; i++) {
			hash += str[i]*Math.pow(prime, i);
		}
		return hash;
	}
	
	private static boolean checkEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
		if(end1 - start1 != end2 - start2) {
			return false;
		}
		while (start1 <= end1 && start2 <= end2) {
			if(str1[start1] != str2[start2]) {
				return false;
			}
			start1++;
			start2++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(patternSearch("TusharRoy", "sharRoy"));
	}
}

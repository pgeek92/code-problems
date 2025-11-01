package leetcode;

/**
 * Leetcode - https://leetcode.com/problems/reverse-string/description
 * @author prash
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseStringA(new char[] {'h','e','l','l','o'}));
		System.out.println(reverseStringB(new char[] {'h','e','l','l','o'}));
	}
	
	/**
	 * Two Pointer Approach
	 * Time Complexity - O(N)
	 * Space Complexity - O(1)
	 * @param s
	 * @return
	 */
	public static char[] reverseStringA(char[] s) {
		int charArrayLength = s.length;
        int j = charArrayLength - 1;
        for(int i = 0; i < charArrayLength; i++) {
            if (i >= j) {
                break;
            } else {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
            j = j-1;
        }
        
        return s;
	}
	
	public static void helper(char[] s, int left, int right) {
		if (left >= right) {
			return;
		}
	    char tmp = s[left];
	    s[left++] = s[right];
	    s[right--] = tmp;
	    helper(s, left, right);
	} 
	
	/**
	 * Recursive Approach
	 * Time Complexity - O(N)
	 * Space Complexity - O(N) -> Auxiliary Space to tackle Recusrion stack calls
	 * @param s
	 * @return
	 */
	public static char[] reverseStringB(char[] s) {
		helper(s, 0, s.length-1);
		return s;
	}

}

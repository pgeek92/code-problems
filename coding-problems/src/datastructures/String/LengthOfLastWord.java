package datastructures.String;

public class LengthOfLastWord {
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * Disadvantage : Two iterations
	 * @param sentence
	 * @return
	 */
	public static int lengthOfTheLastWordApr1(String sentence) {
		int p = sentence.length() - 1;
		while(p >= 0 && sentence.charAt(p) == ' ') {
			p--;
		}
		
		int length = 0;
		while(p >= 0 && sentence.charAt(p) != ' ') {
			p--;
			length++;
		}
		
		return length;
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * Advantage : One iteration
	 * @param sentence
	 * @return
	 */
	public static int lengthOfTheLastWordApr2(String sentence) {
		int p = sentence.length(); 
		int length = 0;
		while (p > 0) {
			p--;
			
			if(sentence.charAt(p) != ' ') {
				length++;
			} else if (length > 0) {
				return length;
			}
		}
		return length;
	}
	
	/**
	 * Time Complexity: O(N)
	 * Space Complexity : O(N)
	 * @param sentence
	 * @return
	 */
	public static int lengthOfTheLastWordApr3(String sentence) {
		sentence = sentence.trim();
		String[] sentenceArray = sentence.split(" ");
		return sentenceArray[sentenceArray.length - 1].length();
	}

	public static void main(String[] args) {
		System.out.println(lengthOfTheLastWordApr1("   Fly in   the moon      "));
		System.out.println(lengthOfTheLastWordApr1("   "));
		System.out.println(lengthOfTheLastWordApr2("   Fly in   the moon      "));
		System.out.println(lengthOfTheLastWordApr3("Prashant Gupta"));
	}

}

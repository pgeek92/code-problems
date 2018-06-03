/**
 * Write a function that takes in a string of one or more words, 
 * and returns the same string, but with all five or more letter words reversed 
 * (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. 
 * Spaces will be included only when more than one word is present.
 * 
 * Examples:
 * 
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" 
 * spinWords( "This is a test") => returns "This is a test" 
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 * 
 */

package codewars;

public class SpinWords {

	public static void main(String[] args) {
		System.out.println(spinWords("This is another test"));
	}

	public static String spinWords(String sentence) {
		String[] array = sentence.split(" ");
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() >= 5) {
				StringBuffer sb = new StringBuffer();
				sb.append(array[i]);
				sb.reverse();
				array[i] = sb.toString();
			}
		}
		sentence = String.join(" ", array);
		return sentence;
	}

}

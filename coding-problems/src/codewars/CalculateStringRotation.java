/**
 * Write a function that receives two strings and returns n, where n is equal to the number of characters we should shift the first string forward to match the second.
 * 
 * For instance, take the strings "fatigue" and "tiguefa". In this case, the first string has been rotated 5 characters forward to produce the second string, so 5 would be returned.
 * 
 * If the second string isn't a valid rotation of the first string, the method returns -1.
 * Examples:
 * 
 * "coffee", "eecoff" => 2
 * "eecoff", "coffee" => 4
 * "moose", "Moose" => -1
 * "isn't", "'tisn" => 2
 * "Esham", "Esham" => 0
 * "dog", "god" => -1
 * 
 * For Swift, your function should return an Int?. So rather than returning -1 when the second string isn't a valid rotation of the first, return nil.
 * 
 * shiftedDiff("coffee", "eecoff") => 2
 * shiftedDiff("eecoff", "coffee") => 4
 * shiftedDiff("moose", "Moose") => nil
 * shiftedDiff("isn't", "'tisn") => 2
 * shiftedDiff("Esham", "Esham") => 0
 * shiftedDiff("dog", "god") => nil
 * 
 */

package codewars;

public class CalculateStringRotation {

	public static void main(String[] args) {
		System.out.println(shiftedDiff("dog", "god"));
	}

	static int shiftedDiff(String first, String second) {
		String testString = second + second;

		if (!isValid(testString, first, second))
			return -1;
		return testString.indexOf(first);
	}

	static boolean isValid(String testString, String first, String second) {
		return testString.contains(first) && first.length() == second.length();
	}

}

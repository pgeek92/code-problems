/**
 * The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).
 * 
 * If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.
 * 
 * If
 * 
 * sz is <= 0 or if str is empty return ""
 * sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
 * 
 * Examples:
 * 
 * revrot("123456987654", 6) --> "234561876549"
 * revrot("123456987653", 6) --> "234561356789"
 * revrot("66443875", 4) --> "44668753"
 * revrot("66443875", 8) --> "64438756"
 * revrot("664438769", 8) --> "67834466"
 * revrot("123456779", 8) --> "23456771"
 * revrot("", 8) --> ""
 * revrot("123456779", 0) --> "" 
 * revrot("563000655734469485", 4) --> "0365065073456944"
 * 
 */

package codewars;

import java.util.*;

public class RevRot {

	public static void main(String[] args) {
		System.out.println(revRot("", 8));
	}

	public static String revRot(String strng, int sz) {

		// your code
		if (sz <= 0 || strng.isEmpty() || sz > strng.length()) {
			return "";
		} else {
			int index = 0;
			int sum = 0;
			ArrayList<String> list = new ArrayList<String>();
			String result = new String();
			while (index < strng.length()) {
				if (index + sz <= strng.length())
					list.add(strng.substring(index, index + sz));
				index = index + sz;
			}

			for (int i = 0; i < list.size(); i++) {
				sum = 0;
				for (int j = 0; j < sz; j++) {

					int digit = (int) list.get(i).charAt(j);
					sum += digit * digit * digit;
				}
				if (sum % 2 == 0) {
					StringBuilder str = new StringBuilder(list.get(i));
					str = str.reverse();
					result += str.toString();
				} else {

					String str = list.get(i).toString();
					str = str.substring(1, sz) + str.charAt(0);
					result += str;
				}
			}
			return result;
		}
	}
}

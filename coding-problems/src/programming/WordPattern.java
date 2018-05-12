/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * 
 */

package programming;

import java.util.HashMap;

public class WordPattern {
	public static void main(String[] args) {
		System.out.print(wordPattern("abba", "dog cat cat dog"));
	}
	
	public static boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if(strArr.length != pattern.length()){
            return false;
        }
        
        HashMap<Character, String> pattCharToStrMap = new HashMap<Character, String>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(pattCharToStrMap.containsKey(c)){
                String value = pattCharToStrMap.get(c);
                if(!value.equals(strArr[i])){
                    return false;
                }
            }else if(pattCharToStrMap.containsValue(strArr[i])){
                return false;
            }
            pattCharToStrMap.put(c, strArr[i]);
        }
        return true;
    }
}

package algorithms;

public class NaivePatternMatchingAlgorithm {

	public static void main(String[] args) {
		String text = "ABCABCD";
		String pattern = "ABCE";
		patternSearch(text, pattern);
	}
	
	public static void patternSearch(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		for(int i = 0; i <= (textLength-patternLength); i++) {
			int j;
			for(j = 0; j < patternLength; j++) {
				if(text.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j == patternLength) {
				System.out.println("Found index is : " + i);
			}
		}
	}
}

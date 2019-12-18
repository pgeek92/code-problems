package algorithms;

public class OptimizedNaivePatternMatchingAlgorithm {

	public static void main(String[] args) {
		String text = "ABCABCD";
		String pattern = "ABCD";
		patternSearch(text, pattern);
		System.out.println((int)'a');
	}
	
	public static void patternSearch(String text, String pattern) {
		int i = 0;
		int textLength = text.length();
		int patternLength = pattern.length();
		while (i <= textLength - patternLength)  
	    {  
	        int j;  
	  
	        for (j = 0; j < patternLength; j++)  
	            if (text.charAt(i + j) != pattern.charAt(j))  
	                break;  
	  
	        if (j == patternLength)  
	        {  
	            System.out.println("Pattern found at index "+i);  
	            i = i + patternLength;  
	        }  
	        else if (j == 0)  
	            i = i + 1;  
	        else
	            i = i + j;
	    }  
	}
}

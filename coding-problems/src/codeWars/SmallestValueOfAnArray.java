package codeWars;

public class SmallestValueOfAnArray 
{
	public static int findSmallest( final int[] numbers, final String toReturn ) 
	{
		//TODO: Add solution here
	    int smallestValue = numbers[0];
	    int index = 0;
	    for(int i = 1; i < numbers.length; i++)
	    {
	    	if(numbers[i] < smallestValue)
	    	{
	    		smallestValue = numbers[i];
	    		index = i;
	    	} 
	    }
	    if(toReturn.equals("index"))
	      return index;
	    else
	      return smallestValue;
	}
}
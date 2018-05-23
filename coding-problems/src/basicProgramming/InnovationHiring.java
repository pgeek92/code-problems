package basicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InnovationHiring {
	
	// Driven method
	public static void main(String[] args) {
		int minIndex = 0;
		int maxSubArraySize = 5;
		int maxIndex = maxSubArraySize;
		List<Object> selectedScore = new ArrayList<Object>();
		Scanner scanner = new Scanner(System.in);
		List<Integer> userInputs = new ArrayList<Integer>();
		
		// User input for noOfDays
		int noOfDays = scanner.nextInt();
		
		// User input for a candidate score on different days based on noOfDays
		for(int i = 0; i < noOfDays; i++){
			userInputs.add(scanner.nextInt());
		}
		
		// The below logic is to break the input array of candidate's score 
		// into chunks of 5 Days (Monday to Friday)
		while(minIndex != userInputs.size()){
			int subArraySum = 0;
			List<Integer> subArray = userInputs.subList(minIndex, maxIndex);
			List<Integer> subArrayClone = pairDeletion(subArray);
			
			subArraySum = calculateSumOfSubArray(subArrayClone);
			
			boolean isSumPresentInSubArray = subArrayClone.contains(subArraySum);
			
			if(isSumPresentInSubArray){
				selectedScore.add(".");
			}else if(subArraySum == 0){
				selectedScore.add(".");
			}else{
				selectedScore.add(findSecondHighest(subArrayClone));
			}
			minIndex = maxIndex;
			maxIndex = maxIndex + maxSubArraySize;
		}
		scanner.close();
		System.out.println(selectedScore);
	}
	
	/**
	 * This method will remove pair of Positive and Negative numbers
	 * @param subArray
	 * @return subArrayClone
	 */
	public static List<Integer> pairDeletion(List<Integer> subArray){
		List<Integer> subArrayClone = new ArrayList<Integer>(subArray);
		for(int i = 0; i < subArray.size(); i++){
			for(int j = i+1; j < subArray.size(); j++){
				if(subArray.get(i) + subArray.get(j) == 0){
					subArrayClone.remove(subArray.get(i));
					subArrayClone.remove(subArray.get(j));
				}
			}
		}
		System.out.println(subArrayClone);
		return subArrayClone;
	}

	/**
	 * This method will calculate sum of array elements
	 * @param userInputSublist
	 * @return sum
	 */
	public static int calculateSumOfSubArray(List<Integer> userInputSublist) {
		int sum = 0;
		for (Integer input : userInputSublist) {
			sum += input;
		}
		return sum;
	}
	
	/**
	 * This method will find the second highest from array element
	 * @param userInputSublist
	 * @return secondHighestElement
	 */
	public static int findSecondHighest(List<Integer> userInputSublist){
		Collections.sort(userInputSublist);
		return userInputSublist.get(userInputSublist.size()-2);
	}
}

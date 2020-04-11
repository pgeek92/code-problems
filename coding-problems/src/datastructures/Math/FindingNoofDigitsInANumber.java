package datastructures.Math;

public class FindingNoofDigitsInANumber {

	public static void main(String[] args) {
		System.out.println(iterativeSolution(328562856));
		System.out.println(recursiveSolution(328562856));
		System.out.println(logarithmicSolution(328562856));
		System.out.println(countDigits(328562856));
	}
	
	public static int iterativeSolution(int number) {
		int count = 0;
		while(number != 0) {
			number = number/10;
			count++;
		}
		return count;
	}
	
	public static int recursiveSolution(int number) {
		if(number == 0) {
			return 0;
		} else {
			return 1 + recursiveSolution(number/10);
		}
	}
	
	public static int logarithmicSolution(int number) {
		return (int) Math.floor(Math.log10(new Double(number)) + 1);
	}

	public static int countDigits(int number) {
		String numberInString = number + "";
		return numberInString.length();
	}
}

package datastructures.Recursion;

public class RecursionExampleOne {

	public static void main(String[] args) {
		System.out.println(sumOfNNumbers(5));

	}
	
	public static int sumOfNNumbers(int num) {
		if(num == 0) {
			return 0;
		}
		return num + sumOfNNumbers(num-1);
	}

}

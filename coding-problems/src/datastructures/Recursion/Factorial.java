package datastructures.Recursion;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorialOfANumber(4));
	}
	
	public static int factorialOfANumber(int num) {
		if(num == 1) {
			return 1;
		}
		return num * factorialOfANumber(num - 1);
	}
}

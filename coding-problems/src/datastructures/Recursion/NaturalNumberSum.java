package datastructures.Recursion;

public class NaturalNumberSum {

	public static void main(String[] args) {
		System.out.println(getSum(4));
	}
	
	public static int getSum(int n) {
		if(n == 0) {
			return 0;
		}
		
		return n + getSum(n-1);
	}

}

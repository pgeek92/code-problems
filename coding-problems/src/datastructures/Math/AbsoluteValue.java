package datastructures.Math;

import java.util.Scanner;

public class AbsoluteValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases--> 0) {
			int number = sc.nextInt();
			System.out.println(absolute(number));
		}
	}
	
	public static int absolute(int number) {
		if(number >= 0) {
			return number;
		} else {
			return number * -1;
		}
	}

}

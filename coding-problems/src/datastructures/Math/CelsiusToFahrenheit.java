package datastructures.Math;

import java.util.Scanner;

public class CelsiusToFahrenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases--> 0) {
			int number = sc.nextInt();
			System.out.println(cToF(number));
		}
	}
	
	public static double cToF(int C) {
		return (9*C + 160) / 5;
	}

}

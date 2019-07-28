/**
 * https://practice.geeksforgeeks.org/problems/fascinating-number/0
 */
package datastructures.Array;

import java.util.Scanner;

public class FascinatingNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		int[] numbers = new int[noOfTests];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = in.nextInt();
			if(numbers[i] < 100) {
		        System.out.println("Number should be atleast three digits");
		        continue;
		    }
			isNumberAFaccinatingNumber(numbers[i]);
		}
		in.close();
	}
	
	static void isNumberAFaccinatingNumber(int number) {
		int numberMultiply2 = number*2;
		int numberMultiply3 = number*3;
		String concNumber = number+""+numberMultiply2+""+numberMultiply3;
		int number0 = Integer.parseInt(String.valueOf(concNumber.charAt(0)));
		for(int i = 1; i < concNumber.length(); i++) {
			number0 = number0*Integer.parseInt(String.valueOf(concNumber.charAt(i)));
		}
		
		if(number0 == 362880) {
			System.out.println("Fascinating");
		} else {
			System.out.println("Not Fascinating");
		}
	}
}

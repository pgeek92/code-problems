package datastructures.Math;

import java.util.Scanner;

public class QuadraticEquationRoots {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases--> 0) {
			int a, b, c;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			quadraticRoots(a, b, c);
			System.out.println();
		}
	}
	
	public static void quadraticRoots(int a, int b, int c) {
		int root1 = 0, root2 = 0;
        int temp = (int)(Math.pow(b, 2) - 4*a*c); //value of b^2-4ac
        
        if(temp < 0)//if b^2-4ac is less then zero then roots are imaginary
            System.out.print("Imaginary");
        else
        {
    	    root1 = (int)Math.floor((-1*b + Math.sqrt(temp))/(2 *a)); //root1
    	    root2 = (int)Math.floor((-1*b - Math.sqrt(temp))/(2 *a));//root2
    	    System.out.print(root1+" "+root2);//print the answer
        }
	}

}

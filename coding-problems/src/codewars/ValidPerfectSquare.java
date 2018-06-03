/**
 * Given a positive integer num, write a function which returns True 
 * if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 */

package codewars;

public class ValidPerfectSquare {
	public static void main(String[] args) {
		System.out.println(isPerfectSquare(65984451));
	}
	public static boolean isPerfectSquare(int num) {
        for(int i = 1;num > 0;i+=2)
            num -= i;
        return 0 == num;
    }
}

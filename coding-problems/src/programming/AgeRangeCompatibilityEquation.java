/**
 * Given an integer (1 <= n <= 100) representing a person's age, return their minimum and maximum age range.
 * 
 * This equation doesn't work when the age <= 14, so use this equation instead:
 * 
 * min = age - 0.10 * age
 * max = age + 0.10 * age
 * You should floor all your answers so that an integer is given instead of a float (which doesn't represent age). Return your answer in the form [min]-[max]
 * 
 * ##Examples:
 * 
 * age = 27   =>   20-40
 * age = 5    =>   4-5
 * age = 17   =>   15-20
 *  
 */
package programming;

public class AgeRangeCompatibilityEquation {
	public static String datingRange(int age) {
		long min = 0;
		long max = 0;
		if (age <= 14) {
			min = Math.round(Math.floor(age - 0.10 * age));
			max = Math.round(Math.floor(age + 0.10 * age));
		} else {
			min = Math.round(Math.floor(age / 2 + 7));
			max = Math.round(Math.floor((age - 7) * 2));
		}
		return min + "-" + max;
	}
	
	public static void main(String[] args) {
		System.out.println(datingRange(13));
	}
}

/**
 * Sheldon, Leonard, Penny, Rajesh and Howard are in the queue for a "Double Cola" drink vending machine; there are no other people in the queue. The first one in the queue (Sheldon) buys a can, drinks it and doubles! The resulting two Sheldons go to the end of the queue. Then the next in the queue (Leonard) buys a can, drinks it and gets to the end of the queue as two Leonards, and so on.
 * 
 * For example, Penny drinks the third can of cola and the queue will look like this:
 * 
 * Rajesh, Howard, Sheldon, Sheldon, Leonard, Leonard, Penny, Penny
 * Write a program that will return the name of the person who will drink the n-th cola.
 * 
 * Note that in the very beginning the queue looks like that:
 * 
 * Sheldon, Leonard, Penny, Rajesh, Howard
 * ##Input
 * 
 * The input data consist of an array which contains at least 1 name, and single integer n.
 * 
 * (1 ≤ n ≤ 1000000000).
 * ##Output / Examples Return the single line — the name of the person who drinks the n-th can of cola. The cans are numbered starting from 1. Please note that you should spell the names like this: "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" (without the quotes). In that order precisely the friends are in the queue initially.
 * 
 * string[] names = new string[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
 *  int n = 1;
 * Line.WhoIsNext(names, n) --> "Sheldon"
 * 
 * int n = 6;
 * Line.WhoIsNext(names, n) --> "Sheldon"
 * 
 * int n = 52;
 * Line.WhoIsNext(names, n) --> "Penny"
 * 
 * int n = 7230702951;
 * Line.WhoIsNext(names, n) --> "Leonard"
 * 
 */

package codewars;

public class Line {

	public static void main(String[] args) {
		System.out.println();
		Line line = new Line();
		System.out.println(line.whoIsNext(new String[] {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"}, 3));
	}

	public int numberOfNames;

	public String whoIsNext(String[] names, int n) {
		numberOfNames = names.length;
		int iteration = findIterationNumber(n);
		int remainingField = findRemainingSum(iteration - 1);

		int numberOfNextPerson = ((n - remainingField) - 1) / ((int) Math.pow(2, iteration));

		return names[numberOfNextPerson];
	}

	private int findIterationNumber(int number) {
		int sumOfIterations = 0;
		int iteration = 0;
		while (number > sumOfIterations) {
			sumOfIterations += numberOfNames * Math.pow(2, iteration);
			iteration++;
		}

		return --iteration;
	}

	private int findRemainingSum(int iteration) {
		int sumOfIterations = 0;
		for (int i = 0; i <= iteration; i++) {
			sumOfIterations += numberOfNames * Math.pow(2, i);
		}

		return sumOfIterations;
	}

}

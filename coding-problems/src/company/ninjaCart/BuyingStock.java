/**
 * Alice wants to buy a stock. She knows the increase and decrease in the stock 
 * value for N consecutive days. Positive value denotes the increase in stock price 
 * and negative value denotes the decrease in stock price.
 * She can buy stock in the morning, the increment or decrement in the stock occurs in 
 * afternoon and the selling can be done only at night. She can buy and sell stock at most once.
 * She can choose not to buy stock at all. Selling is only possible if she has bought 
 * the stock before. You can safely assume that she buys the stock at the price 0 units 
 * at any particular day.
 * 
 * You have to calculate the maximum profit she can earn.
 * 
 * Input Format:
 * First line of the input contains an integer N denoting the number of days.
 * Next line contains N space separated integers denoting increase or decrease in value. 
 * (Positive number denotes increase and negative denotes decrease)
 * 
 * Output Format:
 * Maximum profit that can be earned in this trade.
 * 
 * Constraints :
 * 
 *  
 * 
 * SAMPLE INPUT 
 * 5
 * -5 2 3 -4 5 
 * SAMPLE OUTPUT 
 * 6
 * Explanation
 * Alice buys stock on day 2 morning . Initial value of stock is 0 ,
 * 
 * On day 2 , it increase by 2 ,so it's value becomes 2
 * 
 * On day 3 , it increase by 3 ,so it's value becomes 5
 * 
 * On day 4 , it decreases by 4 ,so it's value becomes 1
 * 
 * On day 5 , it increase by 5 ,so it's value becomes 6 ,
 * 
 * On day 5 night, she sells the stock to gain profit of 6
 * 
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, 
 * Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, 
 * Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, 
 * R(RScript), Racket, Ruby, Rust, Scala, Swift, Swift-4.1, Visual Basic
 * 
 */

package company.ninjaCart;

import java.util.Scanner;

public class BuyingStock {
	public static void main(String args[]) throws Exception {

		// Scanner
		int[] arr = new int[1000000];
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		System.out.print(maxStock(arr));

	}

	static int maxStock(int a[]) {
		int size = a.length;
		int maxstock = Integer.MIN_VALUE, max = 0;

		for (int i = 0; i < size; i++) {
			max = max + a[i];
			if (maxstock < max)
				maxstock = max;
			if (max < 0)
				max = 0;
		}
		return maxstock;
	}
}

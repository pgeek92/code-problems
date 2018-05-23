package basicProgramming;

import java.util.regex.Pattern;

public class BinaryRegexp {

	public static void main(String[] args) {
		System.out.println(multipleOf3());
	}

	public static Pattern multipleOf3() {
		// Regular expression that matches binary inputs that are multiple of 3
		return Pattern.compile("(0|1(01*0)*1)*");
	}

}

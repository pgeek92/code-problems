/**
 * Write a function, which takes a non-negative integer (seconds) as input and returns the time 
 * in a human-readable format (HH:MM:SS)
 * 
 * HH = hours, padded to 2 digits, range: 00 - 99
 * MM = minutes, padded to 2 digits, range: 00 - 59
 * SS = seconds, padded to 2 digits, range: 00 - 59
 * The maximum time never exceeds 359999 (99:59:59)
 * 
 */

package programming;

import java.text.DecimalFormat;

public class HumanReadableTime {
	public static String makeReadable(int seconds) {
		int minutes = 0, sec = 0, hr = 0;
		hr = seconds / 3600;
		minutes = (seconds - (hr * 3600)) / 60;
		sec = (seconds - (hr * 3600) - (minutes * 60));
		return new DecimalFormat("00").format(hr) + ":" + new DecimalFormat("00").format(minutes) + ":"
				+ new DecimalFormat("00").format(sec);
	}

	public static void main(String[] args) {
		System.out.println(makeReadable(366049401));
	}
}

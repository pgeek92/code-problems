package challenges.nearbuy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UsernameDisparitySimpleLogic {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		while(tests-->0) {
			char[] charArray = br.readLine().toCharArray();
			int value = 0;
			int len = charArray.length;
			for(int i = 0; i < len; i++) {
				for(int j = i; j < len; j++) {
					if(charArray[j - i] == charArray[j]) {
						value++;
					}else {
						break;
					}
				}
			}
			System.out.println(value);
		}
	}
}

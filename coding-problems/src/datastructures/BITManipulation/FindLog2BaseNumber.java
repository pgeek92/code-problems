package datastructures.BITManipulation;

public class FindLog2BaseNumber {

	public static void main(String[] args) {
		System.out.println(log2BaseNum(7));
	}
	
	public static int log2BaseNum (int num) {
		int count = 0;
		while (num > 1) {
			num >>= 1;
			count++;
		}
		return count;
	}
}

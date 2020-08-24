package datastructures.BITManipulation;

public class BitwiseHacks {

	public static void main(String[] args) {
		System.out.println(setBitAtNthPosition(7, 3));
		System.out.println(unsetBitAtNthPosition(7, 2));
		System.out.println(togglingABitAtNthPosition(7, 1));
		System.out.println(checkIfABitIsSetAtNthPosition(7, 2));
		System.out.println(strippingOffTheLowestSetBit(7));
		System.out.println(getLowestSetBit(7));
		System.out.println(clearLSBToIthBit(11, 2));
		System.out.println(clearMSBToIthBit(12, 2));
		System.out.println(uppercaseToLowercase('A'));
		System.out.println(lowercaseToUppercase('y'));
	}
	
	public static int setBitAtNthPosition(int num, int pos) {
		return num |= (1 << pos);
	}
	
	public static int unsetBitAtNthPosition(int num, int pos) {
		return num &= (~(1 << pos));
	}
	
	public static int togglingABitAtNthPosition(int num, int pos) {
		return num ^= (1 << pos);
	}
	
	public static boolean checkIfABitIsSetAtNthPosition(int num, int pos) {
		num = num & (1 << pos);
		return num > 0 ? true : false;
	}
	
	public static int strippingOffTheLowestSetBit(int num) {
		return num & (num - 1);
	}
	
	public static int getLowestSetBit(int num) {
		return num & (-num);
	}
	
	public static int clearLSBToIthBit(int num, int pos) {
		return num & ~((1 << pos+1) - 1);
	}
	
	public static int clearMSBToIthBit(int num, int pos) {
		return num & ((1 << pos) - 1);
	}
	
	public static char uppercaseToLowercase(char ch) {
		return ((char) (ch | ' '));
	}
	
	public static char lowercaseToUppercase(char ch) {
		return ((char) (ch & '_'));
	}
}

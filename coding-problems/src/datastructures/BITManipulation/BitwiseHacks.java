package datastructures.BITManipulation;

public class BitwiseHacks {

	public static void main(String[] args) {
		System.out.println(setBitAtNthPosition(7, 3));
		System.out.println(unsetBitAtNthPosition(7, 2));
		System.out.println(togglingABitAtNthPosition(7, 1));
		System.out.println(checkIfABitIsSetAtNthPosition(7, 2));
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
}

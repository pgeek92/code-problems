package challenges.nearbuy;

public class MaximumDifference {

	public static void main(String[] args) {
		int[] inputArr = new int[] {1, 2, 90, 10, 110};
		int arrLen = inputArr.length;
		int maxDiffInArr = inputArr[1] - inputArr[0];
		int minArrEle = inputArr[0];
		for(int i = 1; i < arrLen; i++) {
			if(inputArr[i] - minArrEle > maxDiffInArr) {
				maxDiffInArr = inputArr[i] - minArrEle;
			}
			if(inputArr[i] < minArrEle) {
				minArrEle = inputArr[i];
			}
		}
		if(maxDiffInArr <= 0) {
			System.out.println(-1);
		}else {
			System.out.println(maxDiffInArr);
		}
	}

}

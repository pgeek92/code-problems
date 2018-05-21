package challenges.nearbuy;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicates {

	public static void main(String[] args) {
		Map<Integer, Integer> numberToCountMap = new HashMap<Integer, Integer>();
		int[] inputArr = new int[] {1, 2, 1, 3, 4, 2, 1, 4, 3};
		int arrLen = inputArr.length;
		int count = 0;
		for(int i = 0; i < arrLen; i++) {
			if(numberToCountMap.get(inputArr[i]) != null) {
				numberToCountMap.put(inputArr[i], numberToCountMap.get(inputArr[i]) + 1);
			}else {
				numberToCountMap.put(inputArr[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : numberToCountMap.entrySet()) {
			if(entry.getValue() > 1) {
				count++;
			}
		}
		System.out.println(count);
	}
}

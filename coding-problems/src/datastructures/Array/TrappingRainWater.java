/**
 * https://www.geeksforgeeks.org/trapping-rain-water/
 */
package datastructures.Array;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] array = new int[] {3, 0, 1, 2, 5};
		
		int rainWater = simpleApproach(array);
		System.out.println(rainWater);
		
		rainWater = efficientSolution(array);
		System.out.println(rainWater);
		
		rainWater = moreEfficientSolution(array);
		System.out.println(rainWater);
	}

	/**
	 * time taken is O(n*n)
	 * @param array
	 * @return
	 */
	private static int simpleApproach(int[] array) {
		int leftMax = 0;
		int rightMax = 0;
		
		int rainWater = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int k = i; k >= 0; k--) {
				if(array[k] >= array[i]) {
					leftMax = array[k];
				}
			}
			
			for(int j = i+1; j < array.length; j++) {
				if(array[i] < array[j]) {
					rightMax = array[j];
				}
			}
			rainWater += (Math.min(leftMax, rightMax) - array[i]);
		}
		return rainWater;
	}
	
	/**
	 * This method is taking O(n) time and O(n) space
	 * @param array
	 * @return
	 */
	private static int efficientSolution(int[] array) 
    { 
        int left[] = new int[array.length]; 
        int right[] = new int[array.length]; 
       
        int water = 0; 
       
        left[0] = array[0]; 
        for (int i = 1; i < array.length; i++) 
           left[i] = Math.max(left[i-1], array[i]); 
       
        right[array.length-1] = array[array.length-1]; 
        for (int i = array.length-2; i >= 0; i--) 
           right[i] = Math.max(right[i+1], array[i]); 
       
        for (int i = 0; i < array.length; i++) 
           water += Math.min(left[i],right[i]) - array[i]; 
       
        return water; 
    }

	private static int moreEfficientSolution(int[] array) {
		int result = 0; 
        
        int leftMax = 0, rightMax = 0; 
           
        int start = 0, end = array.length-1; 
           
        while(start <= end)  
        { 
            if(array[start] < array[end]) 
            { 
                if(array[start] > leftMax) { 
                	leftMax = array[start]; 
                }
                else {
                	result += leftMax - array[start]; 
                }
                start++;
            } 
            else
            { 
                if(array[end] > rightMax) {
                	rightMax = array[end];
                } else {
                	result += rightMax - array[end]; 
                }
                end--; 
            } 
        } 
        return result;
	}
}

/**
 * In this problem, you have to implement the int [] removeEven(int[] arr) 
 * method, which removes all the even elements from the array and 
 * returns back updated array.
 * 
 */
package datastructures.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CheckRemoveEven {

	public static void main(String[] args) {
		int[] arr = removeEven(new int[] {1, 2, 4, 5, 10, 6, 3});
		for(Integer i : arr) {
			System.out.println(i);
		}
		
		Integer[] arrLst = new Integer[] {1, 2, 4, 5, 10, 6, 3};
		removeEvenUsingJavaCollections(arrLst);
	}
	
	public static void removeEvenUsingJavaCollections(Integer[] arr) {
		List<Integer> arrLst = new ArrayList<Integer>(Arrays.asList(arr));
		@SuppressWarnings("rawtypes")
		Iterator itr = arrLst.iterator(); 
        while (itr.hasNext()) 
        { 
            int x = (Integer)itr.next(); 
            if (x%2 == 0) {
                itr.remove();
            }
        }
		
		for(Integer i : arrLst) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] removeEven(int[] arr) {
		int oddElements = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				oddElements++;
			}
		}
		
		int[] result = new int[oddElements];
		int result_index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				result[result_index++] = arr[i];
			}
		}
		return result; // change this and return the correct result array
	}
}

/**
 * Write a method, isCircleSorted(int[] A) (Java, JavaScript), or Array#circularly_sorted? (Ruby) that determines if A is circularly sorted. An Array is circularly sorted if the elements are sorted in ascending order, but displaced, or rotated, by any number of steps.
 * 
 * For Example:
 * 
 * // True:
 * isCircleSorted([2,3,4,5,0,1]);
 * isCircleSorted([4,5,6,9,1]);
 * isCircleSorted([10,11,6,7,9]);
 * isCircleSorted([1,2,3,4,5]);
 * isCircleSorted([5,7,43,987,-9,0]);
 * 
 * 
 * // False:
 * isCircleSorted([4,1,2,5]);
 * isCircleSorted([8,7,6,5,4,3]);
 * isCircleSorted([6,7,4,8]);
 * isCircleSorted([7,6,5,4,3,2,1]);
 * 
 */

package codewars;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CircularlySortedArray {

	public static void main(String[] args) {
		System.out.println(isCircleSorted(new int[] {1, 2, 3, 4, 5}));
	}
	
	public static boolean isCircleSorted(int[] a) {
        LinkedList<Integer> input = new LinkedList<>();
        for (Integer a1 : a) {
            input.add(a1);
        }
        
        LinkedList<Integer> stamp = new LinkedList<>(input);    // for comparison
        stamp.sort(Comparator.naturalOrder());
        
        for (int i = 0; i < a.length; i++) {
            if (input.equals(stamp)) return true;
            Collections.rotate(input, 1);
        }       
        
        return false;
    }

}

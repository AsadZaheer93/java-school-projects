package W5_ZAHEER_ASAD;

import java.util.*;

public class InsertionSort {
    private InsertionSort() { }
    /*
	 * Sort array using insertion sort algorithm
	 * 
	 * @param array. Array created from main
	 * 
	 * @return none.
	 */
    public static void sort(Comparable[] array) {
        int size = array.length;
        //insertion sort
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
            	//swap positions
                exch(array, j, j-1);
            }
        }
    }
    /*
	 * Sort array using insertion sort algorithm
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * 
	 * @return none
	 */
    public static void sort(Comparable[] array, int lo, int hi) {
    	//insertion sort
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(array[j], array[j-1]); j--) {
            	//swap positions
                exch(array, j, j-1);
            }
        }
    }

    /*
     * Sort array using an insertion sort algorithm
     * 
     * @param array. Array created from main
     * @param compare. Order to compare
     * 
     * @return none
     */
    public static void sort(Object[] array, Comparator compare) {
        int size = array.length;
        //insertion sort
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && less(array[j], array[j-1], compare); j--) {
            	//swap positions
                exch(array, j, j-1);
            }
        }
    }

    /*
     * Sort sub array using an insertion sort algorithm
     * 
     * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
     * @param compare. Order to compare
     * 
     * @return none
     */
    public static void sort(Object[] array, int lo, int hi, Comparator compare) {
    	//insertion sort
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(array[j], array[j-1], compare); j--) {
            	//swap positions
                exch(array, j, j-1);
            }
        }
    }
    /*
     * Finds the index of an array
     * 
     * @param array. Array created from main
     * 
     * @return indexArray. Index of array
     */
    public static int[] indexSort(Comparable[] array) {
    	//initialize variables
        int size = array.length;
        int[] indexArray = new int[size];
        //copy array
        for (int i = 0; i < size; i++) {
            indexArray[i] = i;
        }
        //find and exchange indices
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && less(array[indexArray[j]], array[indexArray[j - 1]]); j--) {
            	//swap positions
                exch(indexArray, j, j - 1);
            }
        }
        return indexArray;
    }
    /*
	 * Check which element is lesser than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * 
	 * @return boolean. If element lesser than
	 */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /*
	 * Check which element is lesser than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * 
	 * @return boolean. If element lesser than
	 */
    private static boolean less(Object v, Object w, Comparator compare) {
        return compare.compare(v, w) < 0;
    }
        
    /*
	 * Change the positions of two elements
	 * 
	 * @param array. Array created from main
	 * @param i. Position of array
	 * @param j. Position of array
	 * 
	 * @return none.
	 */
    private static void exch(Object[] array, int i, int j) {
        Object swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    /*
	 * Change the positions of two elements
	 * 
	 * @param array. Array created from main
	 * @param i. Position of array
	 * @param j. Position of array
	 * 
	 * @return none.
	 */
    private static void exch(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}

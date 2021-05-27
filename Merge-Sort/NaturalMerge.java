/*
 * Program Name: NaturalMerge.java
 * @author Asad Zaheer
 * @date 16 February 2020
 * 
 * Exercise 4: Creative Problem 2.2.16 Natural Merge Sort (1.5 point)
 * Example: For the array 1, 3, 5, 2, 4, 0, 10, 15, 11, 13
 * Bottom up will start by taking arrays of one and merge:  1, 3.  2, 5,    0, 4,   10, 15,   11, 13
 * The natural merge sort will start with the longest sorted subarrays:
 * 		First merge: 1, 3, 5 with 2, 4 and get 1, 2, 3, 4, 5
 * 		Second merge 0, 10, 15 with 11, 13 and get 0, 10, 11, 13, 15
 * 		After first pass we obtain: 1, 2, 3, 4, 5,   0, 10, 11, 13, 15
 * 		At the second pass we merge 1, 2, 3, 4, 5, with 0, 10, 11, 13, 15
 * 		And we obtain the result 0,  1, 2, 3, 4, 5, 10, 11, 13, 15
 * 		This is the final result as it is ordered.
 * 2.2.16 Natural mergesort. Write a version of bottom-up mergesort that takes advantage of order 
 * in the array by proceeding as follows each time it needs to find two arrays to merge: find a sorted 
 * subarray (by incrementing a pointer until finding an entry that is smaller than its predecessor in 
 * the array), then find the next, then merge them. Analyze the running time of this algorithm in 
 * terms of the array size and the number of maximal increasing sequences in the array.
 * 
 * This program will merge sort 3 different arrays. The arrays will be divided into sub arrays
 * and then sorted using a merge sort and then will be merge sorted again with the increasing
 * build array.
 */
package W4_ZAHEER_ASAD;

import java.util.*;

public class NaturalMerge {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer");
		Comparable[] testCase1 = new Comparable[] {1, 3, 5, 2, 4, 0, 10, 15, 11, 13};
		//display original array
		StdOut.println("\nNatural Merge Sort test 1");
		display(testCase1);
		StdOut.println();
		//merge sort
		sort(testCase1);
		StdOut.println();
		display(testCase1);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		Comparable[] testCase2 = new Comparable[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
		//display original array
		StdOut.println("\nNatural Merge Sort test 2");
		display(testCase2);
		StdOut.println();
		//merge sort
		sort(testCase2);
		StdOut.println();
		display(testCase2);
		double time2 = timer2.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		Comparable[] testCase3 = new Comparable[] {23, 18, 64, 91, 33, 98, 21, 54, 14, 16, 75};
		//display original array
		StdOut.println("\nNatural Merge Sort test 3");
		display(testCase3);
		StdOut.println();
		//merge sort
		sort(testCase3);
		StdOut.println();
		display(testCase3);
		double time3 = timer3.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	/*
     * Sort arrays using merge sort for each sub array
     * 
     * @param a. array that is passed in from main
     * 
     * @return none
     */
	public static void sort(Comparable[] a) {   
		//initialize variables
		Comparable[] aux = new Comparable [a.length];
		int mid = 0; 
		int hi = 0;
		boolean check = true;
		//sort array
		while(check) {
			int i = 0;
			//find sub array
			while (less(a[i], a[i+1]) && i<a.length-2) {
				i++;
			}
			mid = i;
			//end of array
			if (mid == a.length - 1) {
				break;
			}
			//merge sub array
			if (mid == a.length-2) {
				StdOut.print("merge(a, 0, " + mid + ", " + hi + ")" + "    ");
				merge(a, aux, 0, mid, a.length - 1); 
				return;
			}
			int j = mid+1;
			//find next sub array
			while (less(a[j], a[j+1]) && j<a.length - 2) {
				j++;
			}
			hi=j;
			StdOut.print("merge(a, 0, " + mid + ", " + hi + ")" + "    ");
			//merge sub array
			merge(a, aux, 0, mid, hi); 
		}
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {  
		// Merge a[lo..mid] with a[mid+1..hi].   
		int i = lo;
		int j = mid + 1;   
		//Copy a[lo..hi] to aux[lo..hi].
		for (int k = lo; k <= hi; k++) {  
			aux[k] = a[k];
		}
		//Merge back to a[lo..hi].
	    for (int k = lo; k <= hi; k++) {  
	        if (i > mid) {
	        	a[k] = aux[j++];
	        }
	        else if (j > hi ) {
	        	a[k] = aux[i++];
	        }
	        else if (less(aux[j], aux[i])) {
	        	a[k] = aux[j++];
	        }
	        else {
	        	a[k] = aux[i++];
	        }
	    }
	    //output elements of merge
		for (int x = 0; x <= hi; x++) {
			if (a[x] == null) {
				//exclude null values
				break;
			}
			else {
				//output merge
				StdOut.print(a[x] + " "); 
			}
		}
		StdOut.println("  ");
	}
	//auxiliary array for merges
	private static Comparable[] aux;      
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
	 * Output the array
	 * 
	 * @param array. Array created from main
	 * 
	 * @return none
	 */
	public static void display(Comparable[] array) {
		int size = array.length;
		for (int x = 0; x < size; x++) {
			//add spacing after each element
			StdOut.print(array[x] + " ");
		}
		StdOut.println();
	}
}

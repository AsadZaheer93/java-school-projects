/*
 * Program Name: MedianOfThreePartitioning.java
 * @author Asad Zaheer
 * @date 1 March 2020
 * 
 * Exercise 4: Median of three partitioning (1 point)
 * Implement the median of three algorithm as described on page 296.
 * 
 * Median-of-three partitioning. A second easy way to improve the performance 
 * of quicksort is to use the median of a small sample of items taken from the 
 * subarray as the partitioning item. Doing so will give a slightly better 
 * partition, but at the cost of computing the median. It turns out that 
 * most of the available improvement comes from choosing a sample of size 3 
 * and then partitioning on the middle item (see Exercises 2.3.18 and 2.3.19). 
 * As a bonus, we can use the sample items as sentinels at the ends of the 
 * array and remove both array bounds tests in partition().
 * 
 * This program will first shuffle the array elements, find the median,
 * partition the array and finally sort it using the quick algorithm. 
 * This test will happen 3 times.
 */
package W5_ZAHEER_ASAD;

import java.util.*;

public class MedianOfThreePartitioning {
	public static void main(String[] args) {
		StdOut.println("Asad Zaheer");
		//initialize variables
		Comparable [] numSet1 = new Comparable [] {80, 57, 78, 40, 49, 51, 77, 30, 81, 9};
		Comparable [] numSet2 = new Comparable [] {69, 65, 35, 52, 20, 16, 70, 68, 2, 38};
		Comparable [] numSet3 = new Comparable [] {85, 74, 92, 46, 31, 72, 26, 75, 84, 29};
		
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("\nTest 1:\n\nBefore Sorted Array:"); 
		display(numSet1);
		sort(numSet1); // sort and trace array
		StdOut.println("\nSorted Array:");
		display(numSet1); // print sorted array
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		StdOut.println("\n\n\nTest 2:\n\nBefore Sorted Array:"); 
		display(numSet2);
		sort(numSet2); // sort and trace array
		StdOut.println("\nSorted Array:"); 
		display(numSet2); // print sorted array
		double time2 = timer2.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for first test
		Stopwatch timer3 = new Stopwatch();
		StdOut.println("\n\n\nTest 3:\n\nBefore Sorted Array:"); 
		display(numSet3);
		sort(numSet3); // sort and trace array
		StdOut.println("\nSorted Array:"); 
		display(numSet3); // print sorted array
		double time3 = timer3.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	/*
	 * Shuffle and then sort/trace array
	 * 
	 * @param array. Array created from main
	 * 
	 * @return none.
	 */
	public static void sort(Comparable array[]) {
		//eliminate dependence on input
		StdRandom.shuffle(array);          
		StdOut.println("\n\nShuffled Array:");
		//output shuffled array
		display(array);
		StdOut.println("\n\nQuick Sort Trace:");
		int lo = 0;
		int hi = array.length - 1;
		//sort array
		quickSort(array, lo, hi); 
	}
	/*
	 * Sort array using quicksort algorithm
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * 
	 * @return none.
	 */
	private static void quickSort(Comparable array[], int lo, int hi) {
		if(lo >= hi) {
			return;
		}
		//find the median of the array
		int median = median(array, lo, hi); 
		//partition array with median
		int partition = partition(array, lo, hi, median); 
		quickSort(array, 0, partition - 1); 
		quickSort(array, partition + 1, hi);
	}
	/*
	 * Split array into smaller array and change array elements
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * @param count. The level of the iteration
	 * 
	 * @return j. Partitioning element
	 */
	private static int partition(Comparable array[], int lo, int hi, int median) { 
		//Partition into a[lo..i-1], a[i], a[i+1..hi].    
		int i = lo; 
		int j = hi + 1; 
		int v = median;
		while (true) {  
			StdOut.print("i: " + i + "   j: " + (j - 1) + "   ");
			display(array);
			StdOut.println("    median:" + array[median] + "   index: " + median);
			//Scan right, scan left, check for scan complete, and exchange. 
			while (less(array[++i], v)) {
				if (i == hi) {
					break;     
				}
			}
			while (less(v, array[--j])) {
				if (j == lo) {
					break;      
				}
			}
			if (i >= j) {
				break;      
			}
			exch(array, i, j);   
		} 
		//Put v = a[j] into position 
		exch(array, lo, j);
		//with a[lo..j-1] <= a[j] <= a[j+1..hi].
		return j;             
	}
	/*
	 * find the median of an array
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * 
	 * @return hi. The median of the array.
	 */
	public static int median(Comparable array[], int lo, int hi) {
		//middle index
		int mid = (lo + hi) / 2;
		if(less(array[mid], array[lo])) {
			//switch position of mid and low
			exch(array, lo, mid);
		}
		if(less(array[hi], array[lo])) {
			//switch position of low and hi
			exch(array, lo, hi);
		}
		if(less(array[hi], array[mid])) {
			//switch position of mid and hi
			exch(array, mid, hi);
		}
		//switch median and highest position
		exch(array, mid, hi); 
		//median
		return hi; 
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
	 * Change the positions of two elements
	 * 
	 * @param array. Array created from main
	 * @param i. Position of array
	 * @param j. Position of array
	 * 
	 * @return none.
	 */
	private static void exch(Comparable[] array, int i, int j) {  
		Comparable t = array[i]; 
		array[i] = array[j]; 
		array[j] = t;  
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
	}
}

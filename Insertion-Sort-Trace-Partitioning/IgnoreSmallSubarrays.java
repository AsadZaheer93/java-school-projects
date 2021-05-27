/*
 * Program Name: IgnoreSmallSubarrays.java
 * @author Asad Zaheer
 * @date 1 March 2020
 * 
 * Exercise 5: Ignore small arrays (1 point)
 * 
 * 2.3.27 Ignore small subarrays. Run experiments to compare the following strategy 
 * for dealing with small subarrays with the approach described in Exercise 2.3.25: 
 * Simply ignore the small subarrays in quicksort, then run a single insertion sort 
 * after the quick- sort completes. Note : You may be able to estimate the size of 
 * your computer’s cache memory with these experiments, as the performance of this 
 * method is likely to degrade when the array does not fit in the cache.
 * 
 * This program will sort 3 unsorted arrays using a hybrid of insertion and quicksort.
 */
package W5_ZAHEER_ASAD;

import java.util.*;

public class IgnoreSmallSubarrays {
	public static void main(String[] args) {
		StdOut.println("Asad Zaheer");
		//initialize variable
		Comparable [] name1 = new Comparable [] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		Comparable [] name2 = new Comparable [] {"A", "T", "E", "E", "B", "A", "M", "I", "R"};
		Comparable [] name3 = new Comparable [] {"A", "Y", "A", "A", "N", "A", "L", "A", "M"};
		
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("\nTest 1:\n\nBefore Sorted Array:"); 
		//output unsorted array
		display(name1); 
		StdOut.println();
		//sort and trace array
		sort(name1, 4); 
		StdOut.println("\nSorted Array:"); 
		//output sorted array
		display(name1);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		StdOut.println("\n\nTest 2:\n\nBefore Sorted Array:"); 
		//output unsorted array
		display(name2); 
		StdOut.println();
		//sort and trace array
		sort(name2, 3);
		StdOut.println("\nSorted Array:"); 
		//output sorted array
		display(name2);
		double time2 = timer2.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		StdOut.println("\n\nTest 3:\n\nBefore Sorted Array:"); 
		//output unsorted array
		display(name3); 
		StdOut.println();
		//sort and trace array
		sort(name3, 5);
		StdOut.println("\nSorted Array:"); 
		//output sorted array
		display(name3);
		double time3 = timer3.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	/*
	 * Sort array
	 * 
	 * @param array. Array created from main
	 * @param cutoff. Cut off point position within the array
	 * 
	 * @return none.
	 */
	public static void sort(Comparable[] array, int cutoff) {
		sort(array, cutoff, 0, array.length-1);
		insertionSort(array, 0, array.length-1);
	}
	/*
	 * Sort array using insertion algorithm
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * 
	 * @return none.
	 */
	private static void insertionSort(Comparable[] array, int lo, int hi) {
		for (int i=lo; i<=hi; i++) {
			for(int j=i; j>lo && less(array[j], array[j-1]); j--) {
				//switch positions
				exch(array, j, j-1);
			}
		}	
	}
	/*
	 * Sort array based on cutoff point
	 * 
	 * @param array. Array created from main
	 * @param cutoff. Cut off point position within the array
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * 
	 * @return none.
	 */
	private static void sort(Comparable[] array, int cutoff, int lo, int hi) {   
		//exit method
		if (hi <= lo) {
			return;  
		}
		int N = hi - lo + 1;
		//exit method to skip subarrays
		if (N <= cutoff) {
			return;
		}
		else {
			//Partition
			int j = partition(array, lo, hi); 
			//Sort left part a[lo .. j-1].
			sort(array, cutoff, lo, j - 1);    
			//Sort right part a[j+1 .. hi].
			sort(array, cutoff, j + 1, hi);                
		}
	}
	/*
	 * Split array into smaller array and change array elements
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * 
	 * @return j. Partitioning element
	 */
	private static int partition(Comparable[] array, int lo, int hi) {  
		//Partition into a[lo..i-1], a[i], a[i+1..hi].    
		int i = lo;
		int j = hi + 1;     
		//partitioning item
		Comparable v = array[lo];            
		while (true) {  
			StdOut.print("i: " + i + "   j: " + j + "   ");
			//Scan right, scan left, check for scan complete, and exchange.  
			display(array);
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
			if (i >= j) break;      
			exch(array, i, j);   
		} 
		//Put v = a[j] into position  
		exch(array, lo, j);   
		//with a[lo..j-1] <= a[j] <= a[j+1..hi].
		return j;              
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
		StdOut.println();
	}
}

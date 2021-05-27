/*
 * Program Name: NameTracePartition.java
 * @author Asad Zaheer
 * @date 1 March 2020
 * 
 * Exercise 1: Tracing partition (1 point)
 * Trance the execution of the Partition method for your name in capitals 
 * (first name followed by  last name with no space)
 * For each iteration in the outer while loop specify the values for elements 
 * in the array, i and j.
 * 
 * This program will trace a partition of an unsorted array and then
 * display the output for each iteration and finally display the
 * final sorted array. This test will occur 3 times.
 */
package W5_ZAHEER_ASAD;

import java.util.*;

public class NameTracePartition {
	public static void main(String args[]) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer Test 1:");
		String [] fulName = new String [] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		StdOut.println("\nArray before sorted: ");
		//output name
		display(fulName); 
		//sort and trace name
		quickSort(fulName); 
		StdOut.println("\nSorted Array:");
		//print sorted full name
		display(fulName);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 2:");
		String [] fulName2 = new String [] {"A", "T", "E", "E", "B", "A", "M", "I", "R"};
		StdOut.println("\nArray before sorted: ");
		//output name
		display(fulName2); 
		//sort and trace name
		quickSort(fulName2); 
		StdOut.println("\nSorted Array:");
		//print sorted full name
		display(fulName2); 
		double time2 = timer2.elapsedTime();
		//display the execution time second test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 3:");
		String [] fulName3 = new String [] {"A", "Y", "A", "A", "N", "A", "L", "A", "M"};
		StdOut.println("\nArray before sorted: ");
		//output name
		display(fulName3); 
		//sort and trace name
		quickSort(fulName3); 
		StdOut.println("\nSorted Array:");
		//print sorted full name
		display(fulName3); 
		double time3 = timer3.elapsedTime();
		//display the execution time third test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
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
		//left and right scan indices 
		int j = hi+1;        
		//partitioning item
		Comparable parition = array[lo];            
		while (true) {        
			StdOut.print("i: " + i + "   j: " + j + "   ");
			display(array);
			StdOut.println();
			//Scan right, scan left, check for scan complete, and exchange. 
			while (less(array[++i], parition)) {
				if (i == hi) {
					break;     
				}
			}
			while (less(parition, array[--j])) {
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
	 * Split the array and then sort the left and right part of array
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * 
	 * @return none.
	 */
	private static void quickSort(Comparable[] array, int lo, int hi) {      
		if (hi <= lo) {
			return;      
		}
		//Partition
		int j = partition(array, lo, hi);  
		//Sort left part a[lo .. j-1].
		quickSort(array, lo, j-1);     
		//Sort right part a[j+1 .. hi].
		quickSort(array, j+1, hi);              
	}
	/*
	 * Shuffle array and then trace the quicksort
	 * 
	 * @param array. Array created from main
	 * 
	 * @return none.
	 */
	public static void quickSort(Comparable[] array) { 
		//Eliminate dependence on input.
		StdRandom.shuffle(array);          
		StdOut.println("\nShuffled Array:");
		//output shuffled array
		display(array);
		StdOut.println("\nTrace:");
		quickSort(array, 0, array.length - 1);
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

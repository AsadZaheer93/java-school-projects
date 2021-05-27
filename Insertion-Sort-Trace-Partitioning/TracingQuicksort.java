/*
 * Program Name: TracingQuicksort.java
 * @author Asad Zaheer
 * @date 1 March 2020
 * 
 * Exercise 2: Tracing quicksort (1 point)
 * For each recursive call specify the depth of the call 
 * (start with 1 for top level call and at each recursive call 
 * go one level deeper):
 * 
 * Level 1: sort (0, 9)
 * Level 2: partition (0, 9) = 1
 * Level 2: sort(0,0)
 * Level 2: sort(2, 9)
 * 
 * This will output a trace of a quicksorted array that will
 * display each time the a sort is committed. This test will
 * occur 3 times.
 */
package W5_ZAHEER_ASAD;

import java.util.*;

public class TracingQuicksort {
	public static void main(String args[]) {
		//initialize variable
		Comparable [] name1 = new Comparable [] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		Comparable [] name2 = new Comparable [] {"A", "T", "E", "E", "B", "A", "M", "I", "R"};
		Comparable [] name3 = new Comparable [] {"A", "Y", "A", "A", "N", "A", "L", "A", "M"};
		
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer Test 1:");
		//sort and trace name
		sort(name1); 
		StdOut.println("\nSorted Array:");
		//print sorted name
		display(name1); 
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 2:");
		//sort and trace name
		sort(name2); 
		StdOut.println("\nSorted Array:");
		//print sorted name
		display(name2); 
		double time2 = timer2.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 3:");
		//sort and trace name
		sort(name3); 
		StdOut.println("\nSorted Array:");
		//print sorted name
		display(name3);
		double time3 = timer3.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
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
	private static int partition(Comparable[] array, int lo, int hi, int count) {  
		//Partition into a[lo..i-1], a[i], a[i+1..hi].    
		int i = lo;
		//left and right scan indices 
		int j = hi + 1;            
		//partitioning item
		Comparable parition = array[lo];            
		while (true) {  
			StdOut.print("i: " + i + " j: " + j + "   ");
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
		if (array[lo] != array[j]) {
			//if elements are not the same output partition and exchange elements and level
			StdOut.println("Level " + count + ": partition (" + array[lo] + " exchange " + array[j] + ")");
		}
		//Put v = a[j] into position 
		exch(array, lo, j);  
		//with a[lo..j-1] <= a[j] <= a[j+1..hi]. 
		return j;             
	}
	/*
	 * Shuffle and then sort/trace array
	 * 
	 * @param array. Array created from main
	 * 
	 * @return none.
	 */
	public static void sort(Comparable[] array) {        
		int count = 2;
		StdOut.println("\nArray before sorted: ");
		//output array before sorted
		display(array);
		//Eliminate dependence on input.
		StdRandom.shuffle(array);          
		StdOut.println("\n\nShuffled Array:");
		//output randomized array
		display(array);
		StdOut.println("\n\nTrace:");
		StdOut.println("\nLevel 1: sort (0, " + (array.length-1) + ")");
		sort(array, 0, array.length - 1, count);
	}   
	/*
	 * Split the array and then sort the left and right part of array
	 * 
	 * @param array. Array created from main
	 * @param lo. Lowest element of array
	 * @param hi. Highest element of array
	 * @param count. The level of the iteration
	 * 
	 * @return none.
	 */
	private static void sort(Comparable[] array, int lo, int hi, int count) {      
		if (hi <= lo) {
			return;      
		}
		//Partition
		int j = partition(array, lo, hi, count);  
		StdOut.println("\nLevel " + count + ": sort (" + lo + ", " + hi + ")");
		count++;
		//Sort left part a[lo .. j-1].
		sort(array, lo, j-1, count); 
		//Sort right part a[j+1 .. hi].
		sort(array, j+1, hi, count);              
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

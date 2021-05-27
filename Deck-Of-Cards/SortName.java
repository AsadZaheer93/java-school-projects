/*
 * Program Name: SortName.java
 * @author Asad Zaheer
 * @date 8 February 2020
 * 
 * Exercise 1 Tracing (1 point): Write the letters in your name as a sequence without 
 * spaces (first name, middle name, last name). In my case the sequence is: M I H A I B O I C U. 
 * Following the model in the guided module, submit a trace of how the 3 elementary sorts 
 * algorithms will sort the letter in alphabetic order. In my example the sort result will 
 * be: A B C H I I I M O U . Be sure, that each step of the algorithm is clearly presented in 
 * the result table. Grading: 0.3 points selection sort, 0.3 points insertion sort and 0.4 
 * points shell sort. Each tracing mistake will take out .05 points from your result. 
 * key.
 * 
 * This program will create 9 array will 3 different names and then 
 * have each of the names be sorted 3 different ways. The names
 * will be sorted by selection sort, insertion sort and shell sort.
 */
package W3_ZAHEER_ASAD;

import java.util.*;

public class SortName {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize 3 names repeated 3 times
		String name1[] = new String[] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		String name2[] = new String[] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		String name3[] = new String[] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		String name4[] = new String[] {"H", "A", "M", "A", "D", "Z", "A", "H", "E", "E", "R"};
		String name5[] = new String[] {"H", "A", "M", "A", "D", "Z", "A", "H", "E", "E", "R"};
		String name6[] = new String[] {"H", "A", "M", "A", "D", "Z", "A", "H", "E", "E", "R"};
		String name7[] = new String[] {"Z", "O", "H", "A", "I", "B", "Z", "A", "H", "E", "E", "R"};
		String name8[] = new String[] {"Z", "O", "H", "A", "I", "B", "Z", "A", "H", "E", "E", "R"};
		String name9[] = new String[] {"Z", "O", "H", "A", "I", "B", "Z", "A", "H", "E", "E", "R"};
		//Sort Asad Zaheer
		selectionSort(name1);
		StdOut.println();
		insertionSort(name2);
		StdOut.println();
		shellSort(name3);
		StdOut.println();
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		//Sort Hamad Zaheer
		selectionSort(name4);
		StdOut.println();
		insertionSort(name5);
		StdOut.println();
		shellSort(name6);
		StdOut.println();
		double time2 = timer2.elapsedTime();
		//display the execution time for second test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		//Sort Zohaib
		selectionSort(name7);
		StdOut.println();
		insertionSort(name8);
		StdOut.println();
		shellSort(name9);
		double time3 = timer3.elapsedTime();
		//display the execution time for third test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	/*
	 * Sort array in using selection algorithm
	 * 
	 * @param array. Array from main
	 * 
	 * @return none
	 */
	public static void selectionSort(Comparable[] array) { 
		//initialize variables
		int size = array.length;
		StdOut.print("Asad Zaheer\nStart of tracing array with selection sort: ");
		//output array before sorted
		display(array);
		StdOut.println();
		for (int x = 0; x < size; x++) {  
			//minimum index
			int min = x;                
			for (int y = x + 1; y < size; y++) {
				if (less(array[y], array[min])) {
					//switch element
					min = y;
				}
			}
			//output trace
			StdOut.print("I:  " + x + " min:  " + min + "   ");
			//output array sorted
			display(array);
			exch(array, x, min);
		} 
		//output final results
		StdOut.println("End of trace result: ");
		display(array);
	}
	/*
	 * Sort array in using insertion algorithm
	 * 
	 * @param array. Array from main
	 * 
	 * @return none
	 */
	public static void insertionSort(Comparable[] array) {  
		//initialize variables
		int size = array.length;
		StdOut.print("Asad Zaheer\nStart of tracing array with insertion sort: ");
		//output array before sorted
		display(array);
		for (int x = 1; x < size; x++) { 
			int count = 0;
			for (int y = x; y > 0 && less(array[y], array[y - 1]); y--) {
				//switch element and increase count
				exch(array, y, y - 1);
				count++;
			}
			//output trace
			StdOut.print("I:   " + x + " min:  " + count + "   ");
			//output array sorted
			display(array);
		}
		//output final results
		StdOut.println("End of trace result: ");
		display(array);
	}
	/*
	 * Sort array in using shell algorithm
	 * 
	 * @param array. Array from main
	 * 
	 * @return none
	 */
	public static void shellSort(Comparable[] array) {
		//initialize variables
		int size = array.length;
		int h = 1;
		StdOut.print("Asad Zaheer\nStart of tracing array with shell sort: ");
		//output array before sorted
		display(array);
		while (h < size/3) h = 3*h + 1; {
			while (h >= 1) {  
				int count = 0;
				for (int x = h; x < size; x++) { 
					for (int y = x; y >= h && less(array[y], array[y-h]); y -= h) {
						//switch element and increase count
						exch(array, y, y-h);
						count++;
					}
				}
				//output trace
				StdOut.print(h + "-sort     min: " + count + "    ");
				//output array sorted
				display(array);
				h = h/3; 
			}
		}
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
	 * Check which element is greater than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * 
	 * @return boolean. If element greater than
	 */
    private static void exch(Comparable[] a, int i, int j) {  
    	Comparable t = a[i]; a[i] = a[j]; a[j] = t;  
    }
}

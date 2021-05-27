/*
 * Program Name: FasterMerge.java
 * @author Asad Zaheer
 * @date 16 February 2020
 * 
 * Exercise 2: Creative Problem 2.2.10 Faster merge. Implement a version of merge() 
 * that copies the second half of a[] to aux[] in decreasing order and then does the 
 * merge back to a[]. This change allows you to remove the code to test that each 
 * of the halves has been exhausted from the inner loop. Note: The resulting sort 
 * is not stable (see page 341).
 * 
 * This program will sort 3 different array at a faster rate than a regular top
 * down merge sort. 
 */
package W4_ZAHEER_ASAD;

import java.util.*;

public class FasterMerge {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer");
		Comparable[] testCase1 = new Comparable[] {"E", "D", "S", "Q", "E", "S", "I", "O"};
		StdOut.println("\nTest 1 of faster merge sort:");
		display(testCase1);
		StdOut.println();
		sort(testCase1);
		StdOut.println();
		display(testCase1);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for first test
		Stopwatch timer2 = new Stopwatch();
		Comparable[] testCase2 = new Comparable[] {"A", "T", "E", "E", "B", "A", "M", "I", "R"};
		StdOut.println("\nTest 2 of faster merge sort:");
		display(testCase2);
		StdOut.println();
		sort(testCase2);
		StdOut.println();
		display(testCase2);
		double time2 = timer2.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for first test
		Stopwatch timer3 = new Stopwatch();
		Comparable[] testCase3 = new Comparable[] {"A", "Y", "A", "A", "N", "A", "L", "A", "M"};
		StdOut.println("\nTest 3 of faster merge sort:");
		display(testCase3);
		StdOut.println();
		sort(testCase3);
		StdOut.println();
		display(testCase3);
		double time3 = timer3.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	//auxiliary array for merges
	private static Comparable[] aux;      
	/*
	 * sort auxiliary array
	 * 
	 * @param a. array of name
	 * 
	 * @return none
	 */
    public static void sort(Comparable[] a) {
    	//Allocate space just once.
    	aux = new Comparable[a.length];    
    	sort(a, 0, a.length - 1);
    }
    /*
     * Sort arrays using merge sort
     * 
     * @param a. array that is passed in from main
     * @param lo. The first element of the array
     * @param hi. The last element of the array
     * 
     * @return none
     */
    private static void sort(Comparable[] a, int lo, int hi)   {      
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;   
		//Sort left half
		sort(a, lo, mid); 
		//Sort right half
		sort(a, mid+1, hi);           
		merge(a, lo, mid, hi);
		//display trace
		StdOut.print("merge (a, " + lo + ", " + mid + ", " + hi + ")   "); 
		//output elements of merge
		for (int j=0; j<=hi; j++) {
			if (a[j] == null) {
				//exclude null values
				break; 
			}
			else {
				//output merge
				StdOut.print(a[j] + " "); 
			}
    	}
		StdOut.println("  ");  
	}  
    /*
     * Sort arrays using a faster method of merge sort
     * 
     * @param a. array from main
     * @param lo. The first element of the array
     * @param mid. The middle element of the array
     * @param hi. The last element of the array
     * 
     * @return none
     */
	public static void merge(Comparable[] a, int lo, int mid, int hi) { 
		//copy first half
		for (int x = lo; x <= mid; x++) {
			aux[x] = a[x];  
		}
		//copy second half
		for (int x = mid + 1; x <= hi; x++) {
			aux[x] = a[hi - x + mid +1]; 
		}
		int i = lo; 
		int j = hi;
		//merge at a faster rate
		for (int k=lo; k<=hi; k++) {     
			if (less(aux[j], aux[i])) {
				//decreasing order
				a[k] = aux[j--]; 
			}
			else {
				//increasing order
				a[k] = aux[i++]; 
			}
		}
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

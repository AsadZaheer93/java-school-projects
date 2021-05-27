/*
 * Program Name: Cutoff.java
 * @author Asad Zaheer
 * @date 1 March 2020
 * 
 * Exercise 3: Cutoff to insertion sort (1 point)
 * Implement the cutoff to insertion sort algorithm as described on page 296.
 * 
 * Cutoff to insertion sort. As with most recursive algorithms, an easy way to 
 * improve the performance of quicksort is based on the following two observations:
 * ■ Quicksort is slower than insertion sort for tiny subarrays.
 * ■ Being recursive, quicksort’s sort() is certain to call itself for tiny 
 * subarrays. Accordingly, it pays to switch to insertion sort for tiny subarrays. 
 * A simple change to Algorithm 2.5 accomplishes this improvement: replace the 
 * statement
 * if (hi <= lo) return;
 * in sort() with a statement that invokes insertion sort for small subarrays:
 * if (hi <= lo + M) { Insertion.sort(a, lo, hi); return; }
 * The optimum value of the cutoff M is system-dependent, but any value between 5 and
 * 15 is likely to work well in most situations (see Exercise 2.3.25).
 * 
 * This program will create 3 arrays and then sort these arrays using a hybrid
 * sort with both quick sort and insertion sort. This test will occur 3 times.
 */
package W5_ZAHEER_ASAD;

import java.util.*;

public class Cutoff {
	public static void main(String[] args) {
		//initialize variables
    	Comparable [] name1 = new Comparable [] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		Comparable [] name2 = new Comparable [] {"A", "T", "E", "E", "B", "A", "M", "I", "R"};
		Comparable [] name3 = new Comparable [] {"A", "Y", "A", "A", "N", "A", "L", "A", "M"};
		
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 1:\n\nUnsorted Array:");
		display(name1);
		sort(name1);
		StdOut.println("\nSorted Array:");
		display(name1);
        StdOut.println();
        double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
        
        //start stop watch for first test
      	Stopwatch timer2 = new Stopwatch();
        StdOut.println("Asad Zaheer\n\nTest 2:\n\nUnsorted Array:");
        display(name2);
        sort(name2);
        StdOut.println("\nSorted Array:");
        display(name2);
        StdOut.println();
        double time2 = timer2.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
        
        //start stop watch for first test
      	Stopwatch timer3 = new Stopwatch();
        StdOut.println("Asad Zaheer\n\nTest 3:\n\nUnsorted Array:");
        display(name3);
        sort(name3);
        StdOut.println("\nSorted Array:");
        display(name3);
        double time3 = timer3.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
    }
	
	private Cutoff() { }
	
    /*
     * Shuffle array and then sort with natural sort
     * 
     * @param array. Array created from main
     */
    public static void sort(Comparable[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);  
    }

    /* 
     * Sort a subarray using the quicksort algorithm
     * 
     * @param array. Array created from main
     */
    private static void sort(Comparable[] array, int lo, int hi) { 
    	if (hi <= lo) {
    		return;
    	}
    	int M = 0;
    	if (hi <= lo + M) {  
    		InsertionSort.sort(array, lo, hi); 
    		return;  
    	}
        int v = partition(array, lo, hi);
        sort(array, lo, v - 1);
        sort(array, v + 1, hi); 
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
    private static int partition(Comparable[] array, int lo, int hi) {
    	//Partition into a[lo..i-1], a[i], a[i+1..hi].  
        int i = lo;
        int j = hi + 1;
        Comparable v = array[lo];
        while (true) { 
        	//Scan right, scan left, check for scan complete, and exchange.
            while (less(array[++i], v)) {
                if (i == hi) {
                	break;
                }
            }
            //switch hi
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
	 * Check which element is lesser than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * 
	 * @return boolean. If element lesser than
	 */
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) {
        	return false;
        }
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
    private static void exch(Object[] array, int i, int j) {
        Object swap = array[i];
        array[i] = array[j];
        array[j] = swap;
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

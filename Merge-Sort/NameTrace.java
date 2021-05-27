/*
 * Program Name: NameTrace.java
 * @author Asad Zaheer
 * @date 16 February 2020
 * 
 * Exercise 1 Tracing (1 point):
 * Merge sorted arrays (0.3 points): Based on the above guided activities, perform 
 * the following traces and submit your answer. For Activity 1: Merge sorted arrays 
 * order the letters in your first name, order the letters in your last name and 
 * then show the trace for merging them as described in Activity 1.  
 * For the next two parts: Write the letters in your name as a sequence without 
 * spaces (first name, middle name, last name). In my case the sequence is: 
 * M I H A I B O I C U. Following the model in the guided modules 2 and 3, 
 * submit a trace of how the 2 merge sorts algorithms will sort the letter in 
 * alphabetic order. In my example the sort result will be: A B C H I I I M O U . 
 * Be sure, that each step of the algorithm is clearly presented in the result table. 
 * Top Down Merge Sort Grading: 0.3 points
 * Bottom Up Merge Sort, Grading: 0.4 points 
 * 
 * This program will merge sort the first name and then the last name. Then it will
 * combine both names and commit another merge. The second time a merge is done is
 * with the full name with a top-down merge and then a bottom up merge. This test
 * will occur 3 times.
 */
package W4_ZAHEER_ASAD;

import java.util.*;

public class NameTrace {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize first and last name arrays
		StdOut.println("Asad Zaheer\nTest 1:");
		//String[] fName = new String[] {"A", "S", "A", "D"};
		//String[] lName = new String[] {"Z", "A", "H", "E", "E", "R"};
		
		
		String[] fName = new String[] {"E", "D", "S", "Y"};
		String[] lName = new String[] {"E", "T", "I", "O"};
		
		String[] fullNameTD = new String[] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		String[] fullNameBU = new String[] {"A", "S", "A", "D", "Z", "A", "H", "E", "E", "R"};
		//first name sort
		StdOut.println("\nFirst Name:");
		display(fName);
		StdOut.println();
		sort(fName);
		//last name sort
		StdOut.println("\nLast Name:");
		display(lName);
		StdOut.println();
		sort(lName);
		//merge both first and last name
		String[] name = combine(fName, lName); 
		//display full name sorted
		display(name);
		StdOut.println();
		//full name top-down merge sort
		StdOut.println("Top-down merge sort:");
		display(fullNameTD);
		StdOut.println();
		//sort full name
		sort(fullNameTD); 
		//full name bottom-up merge sort
		StdOut.println("\nBottom-up merge sort:");
		display(fullNameBU);
		sortB(fullNameBU);
		display(fullNameBU);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		//Testing for Ateeb Amir
		StdOut.println("\n\nTest 2");
		String[] fName2 = new String[] {"A", "T", "E", "E", "B"};
		String[] lName2 = new String[] {"A", "M", "I", "R"};
		String[] fullNameTD2 = new String[] {"A", "T", "E", "E", "B", "A", "M", "I", "R"};
		String[] fullNameBU2 = new String[] {"A", "T", "E", "E", "B", "A", "M", "I", "R"};
		//first name sort
		StdOut.println("\nFirst Name:");
		display(fName2);
		StdOut.println();
		sort(fName2);
		//last name sort
		StdOut.println("\nLast Name:");
		display(lName2);
		StdOut.println();
		sort(lName2);
		//merge both first and last name
		String[] name2 = combine(fName2, lName2); 
		//display full name sorted
		display(name2);
		StdOut.println();
		//full name top-down merge sort
		StdOut.println("Top-down merge sort:");
		display(fullNameTD2);
		StdOut.println();
		//sort full name
		sort(fullNameTD2); 
		//full name bottom-up merge sort
		StdOut.println("\nBottom-up merge sort:");
		display(fullNameBU2);
		sortB(fullNameBU2);
		display(fullNameBU2);
		double time2 = timer2.elapsedTime();
		//display the execution time second test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		//testing for Ayaan Alam
		StdOut.println("\n\nTest 3");
		String[] fName3 = new String[] {"A", "Y", "A", "A", "N"};
		String[] lName3 = new String[] {"A", "L", "A", "M"};
		String[] fullNameTD3 = new String[] {"A", "Y", "A", "A", "N", "A", "L", "A", "M"};
		String[] fullNameBU3 = new String[] {"A", "Y", "A", "A", "N", "A", "L", "A", "M"};
		//first name sort
		StdOut.println("\nFirst Name:");
		display(fName3);
		StdOut.println();
		sort(fName3);
		//last name sort
		StdOut.println("\nLast Name:");
		display(lName3);
		StdOut.println();
		sort(lName3);
		//merge both first and last name
		String[] name3 = combine(fName3, lName3); 
		//display full name sorted
		display(name3);
		StdOut.println();
		//full name top-down merge sort
		StdOut.println("Top-down merge sort:");
		display(fullNameTD3);
		StdOut.println();
		//sort full name
		sort(fullNameTD3); 
		//full name bottom-up merge sort
		StdOut.println("\nBottom-up merge sort:");
		display(fullNameBU3);
		sortB(fullNameBU3);
		display(fullNameBU3);
		double time3 = timer3.elapsedTime();
		//display the execution time third test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	/* 
	 * Top down merge sort
	 * 
	 * @param a. Name unsorted
	 * @param lo. first element of name
	 * @param mid. middle element of name
	 * @param hi. last element of name
	 * 
	 * @return none.
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {  
		//Merge a[lo..mid] with a[mid+1..hi].
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
	}
	/* 
	 * Combine first and last name
	 * 
	 * @param fName. first name of person
	 * @param lName. last name of person
	 * 
	 * @return fullName. The full name of person
	 */
	public static String[] combine(String[] fName, String[] lName) {
		//initial full name array
		String [] fullName = new String [fName.length + lName.length];
		int size = fName.length + lName.length;
		StdOut.println("\nFull Name:");
		//add full name
		for (int x = 0; x < size; x++) {
			StdOut.print("k: " + x + "  ");
			//copy first name
			if (x < fName.length) {
				fullName[x] = fName[x];
			}
			//copy last name
			if (x >= fName.length && x < size) {
				fullName[x] = lName[x - fName.length];
			}
			//output each merge
			for (int y = 0; y < size; y++) {
				if (fullName[y] == null) {
					//don't output null values
					break;
				}
				else {
					//output letter
					StdOut.print(fullName[y] + " ");
				}
			}
			StdOut.println("  ");
		}
		return fullName;   
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
	 * top down merge sort of name
	 * 
	 * @param a. array of name
	 * @param lo. first letter of name
	 * @param hi. last letter of name
	 * 
	 * @return none
	 */
    private static void sort(Comparable[] a, int lo, int hi) { 
       if (hi <= lo) return;
       int mid = lo + (hi - lo) / 2;
       //sort first half
       sort(a, lo, mid);    
       //sort second half
       sort(a, mid+1, hi); 
       merge(a, lo, mid, hi);
       //display trace
       StdOut.print("merge (a, " + lo + ", " + mid + ", " + hi + ")   ");
       //print out array
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
    /*
	 * bottom up merge sort of name
	 * 
	 * @param a. array of name
	 * 
	 * @return none
	 */
    public static void sortB(Comparable[] a) {
    	//initialize variables
    	int size = a.length;
    	aux = new Comparable[size];
    	//output the size of windows
    	for (int sz = 1; sz < size; sz = sz+sz) {
    		if ((sz == 1) || (sz == 2) || (sz == 4) || (sz == 8) || (sz == 16)) {
				StdOut.println("\nsz = " + sz); 
    		}
    		for (int lo = 0; lo < size - sz; lo += sz + sz) {
    			//output each time a merge occurs
    			if ((sz == 1) || (sz == 2) || (sz == 4) || (sz == 8) || (sz == 16)) {
					StdOut.println("merge(a, " + lo + ", " + (lo + sz - 1) + ", " + (lo + sz + sz - 1) + ")");
    			}
    			merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, size - 1));
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
	

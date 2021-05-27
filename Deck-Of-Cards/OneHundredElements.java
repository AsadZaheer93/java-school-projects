/*
 * Program Name: OnHundredElements.java
 * @author Asad Zaheer
 * @date 8 February 2020
 * 
 * Exercise 5: based on 2.1.19 Shellsort worst case - page 265 
 * (1 point, 1 bonus point): Perform the following steps (modified 
 * book question for 111 elements):
	•	Create a method to randomly generate an array of 111 elements 
		with the numbers from 1 to 111
	•	Modify shell sort to compute and return the number of compares 
		between the array elements it executes
	•	Create an experiment to determine the answer and print the 
		best array(s) found, with the elements separated by space. 
	•	The student(s) that will generated the most compares will get 
		a bonus point (but need to be a correct result) Include in 
		the answer the list of elements separated by space. If tied 
		in the number of compares the more arrays you submit with that 
		number of compares you win. In case of another tie, the bonus 
		point is divided to the number of students with both ties.
 * 
 * This program will sort 111 positive numbers using the Shell sort 
 * algorithm. After the sort has been completed it will output the
 * total number of comparisons within the array.
 */
package W3_ZAHEER_ASAD;

import java.util.*;

public class OneHundredElements {
	public static void main(String args[]) {
		//start stop watch
		Stopwatch timer = new Stopwatch();
		//initialize values
		int size = 111;
		int[] array = new int[size];
		//generate random numbers
		for(int x = 0; x < size; x++) {
			array[x] = randomNumber();
		}
		//output the array before being sorted
		System.out.println("Asad Zaheer\nCurrent Array: ");
		display(array);
		System.out.println();
		//sort array and count the total number of comparisons
		int count = shellSort(array, size);
		//output results
		System.out.println("Total number of comparison: " + count + "\nSorted Array: ");
		display(array);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
	}   
	/*
	 * Create a random number between 1 and 111
	 * 
	 * @param none
	 * 
	 * @return rand. A random number
	 */
	public static int randomNumber() {
		Random rand = new Random();
		//randomize number
		return rand.nextInt(111 - 1) + 1;   
	}
	/*
	 * Sort an array using shell sort algorithm
	 * 
	 * @param array. Random array created
	 * @param size. Size of the array
	 * 
	 * @return sameCounter. Total number of comparisons
	 */
	public static int shellSort(int[] array, int size) {
		//initialize variables
		int y;
		int sameCounter = 0;
		//check window and decrease over each loop
		for (int h = size/2; h > 0; h = h / 2) { 
			for (int x = h; x < size; x++) {
				int t = array[x];
				//check each array
				for (y = x; y >= h && array[y - h] > t; y = y - h) {
					//change window position by one
					array[y] = array[y - h];
					//increase count
					sameCounter++;
				}
				array[y] = t;
			}
		}
		//return the final count
		return sameCounter;
	}
	/*
	 * Output the array
	 * 
	 * @param array. Random array created
	 * 
	 * @return none
	 */
	public static void display(int[] array) {
		//size of the array
		int size = array.length;
		for (int x = 0; x < size; x++) {
			//output each element
			StdOut.print(array[x] + "  ");
			//go to the next line
			if ((x % 20) == 0) {
				StdOut.println();
			}
		}
		StdOut.println();
	}
}

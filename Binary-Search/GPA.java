/*
 * Program Name: GPA.java
 * @author Asad Zaheer
 * @date 15 March 2020
 * 
 * Exercise 4 (1 point) Textbook exercise 3.1.1
 * Using the above implementation, write a client that creates a symbol table mapping 
 * letter grades to numerical scores (as in the textbook table: A+ 4.33, A 4.00, 
 * A- 3.67, B+ 3.33, ... F 0). You need to read letter grades from the standard input 
 * (or the command line)  and print the average GPA. See textbook for details. 
 * 
 * This program will calculate the average gpa of 3 sets of grades.
 */
package W6_ZAHEER_ASAD;

import java.util.*;

public class GPA {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
        StdOut.println("Asad Zaheer\nTest 1");
        BinearySearchAlphabetName<String, Double> score = new BinearySearchAlphabetName<String, Double>();
        //build first table
        score.put("A+", 4.33);
        score.put("A", 4.00);
        score.put("A-", 3.67);
        score.put("B+", 3.33);
        score.put("B", 3.00);
        score.put("B-", 2.67);
        score.put("C+", 2.33);
        score.put("C", 2.00);
        score.put("C-", 1.67);
        score.put("D", 1.00);
        score.put("F", 0.00);
        //collection of grades
        String[] grades = new String[]{"A","B","C","D","F"};
        //calculate gpa
        double gpa = new GPA().average(score, grades);
        //output gpa
        StdOut.printf("GPA: %.2f", gpa);
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
        StdOut.println("Asad Zaheer\nTest 2");
        //collection of grades
        String[] grades2 = new String[]{"A+","A","A-","B+","B","B-","A+","A+"};
        //calculate gpa
        double gpa2 = new GPA().average(score, grades2);
        //output gpa
        StdOut.printf("GPA: %.2f", gpa2);
        double time2 = timer2.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time2 + " seconds.\n");
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();
        StdOut.println("Asad Zaheer\nTest 3");
        //collection of grades
        //-++==+-+++----=-=--+ 
        String[] grades3 = new String[]{"C-","D","D","D","F","F","F","B+","D","C+","C-","D","C-","D","F","C-","F","A-","C-","C+"};
        //calculate gpa
        double gpa3 = new GPA().average(score, grades3);
        //output gpa
        StdOut.printf("GPA: %.2f", gpa3);
        double time3 = timer3.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time3 + " seconds.\n");
    }
	/*
	 * Calculate average gpa
	 * 
	 * @param score. Numerical grade
	 * @param grades. Alphabetical grade
	 * 
	 * @return average. Average of all grades
	 */
    private double average(BinearySearchAlphabetName<String, Double> score, String[] grades) {
    	//initialize variables
    	double total = 0;
    	double average = 0;
    	//total all scores
        for(String grade : grades) {
        	total += score.get(grade);
        }
        //calculate average
        average = total / grades.length;
        return average;
    }
}

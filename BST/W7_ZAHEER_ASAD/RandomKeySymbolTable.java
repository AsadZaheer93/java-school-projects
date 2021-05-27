/*
 * Program Name: RandomKeySymbolTable.java
 * @author Asad Zaheer
 * @date 27 March 2020
 * 
 * Exercise 3.2.21 (1.5 point) implement and test randomKey()
 * 
 * 3.2.21 Add a BST method randomKey() that returns a random key 
 * from the symbol table in time proportional to the tree height, 
 * in the worst case.
 */
package W7_ZAHEER_ASAD;

import java.util.*;

public class RandomKeySymbolTable {
	public static void main(String[] args) { 
		//start stop watch for first test
		Stopwatch timer = new Stopwatch(); 
		//create symbol table
		BST<String, String> edqajtms = new BST<String, String>(); 
    	StdOut.println("Asad Zaheer Test 1\n");
    	//build table
    	edqajtms.put("E", "0"); 
    	edqajtms.put("D", "1"); 
    	edqajtms.put("Q", "2"); 
    	edqajtms.put("A", "3");
    	edqajtms.put("J", "4"); 
    	edqajtms.put("T", "5"); 
    	edqajtms.put("M", "6"); 
    	edqajtms.put("S", "7");
    	//output random values
        StdOut.println("Generating random keys 10 times:");  
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time + " seconds.\n"); 
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch(); 
 		StdOut.println("Asad Zaheer Test 2\n");
 		//output random values
        StdOut.println("Generating random keys 10 times:");  
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("\nExecution time " + time2 + " seconds.\n"); 
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch(); 
 		StdOut.println("Asad Zaheer Test 3\n");
 		//output random values
        StdOut.println("Generating random keys 10 times:");  
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        StdOut.println(edqajtms.select(randomKey()));
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("\nExecution time " + time3 + " seconds.\n"); 
    } 
	/*
	 * find random key
	 * 
	 * @param none
	 * 
	 * @return randomNum. Random number between 0 and 8
	 */
	public static Integer randomKey() {
	   	Random random = new Random();
	   	int randomNum = random.nextInt(8);    	
	   	return randomNum;  
	}
}

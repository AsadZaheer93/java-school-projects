/*
 * Program Name: TraceMethods.java
 * @author Asad Zaheer
 * @date 27 March 2020
 * 
 * Exercise 3.2.15 (1.5 point) For the tree in the textbook trace the following 
 * operations: floor, select, ceiling, rank, keys
 * 
 * 3.2.15 Give the sequences of nodes examined when the methods in BST are used 
 * to compute each of the following quantities for the tree drawn at right.
 * 
 * a. floor("Q")
 * b. select(5) E
 * c. ceiling("Q")
 * d. rank("J")
 * f. keys("D", "T")
 * 
 */
package W7_ZAHEER_ASAD_3_2_15;

public class TraceMethods {
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

        //floor("Q")
        StdOut.println("floor(\"Q\"): ");
        StdOut.println(edqajtms.floor("Q"));
        //select(5)
        StdOut.println("\nselect(5): "); 
        StdOut.println(edqajtms.select(5));
        //ceiling("Q")
        StdOut.println("\nceiling(\"Q\"): ");
        StdOut.println(edqajtms.ceiling("Q"));
        //race rank("J")
        StdOut.println("\nrank(\"J\"): ");
        StdOut.println(edqajtms.rank("J"));
        //keys("D", "T")
        StdOut.println("\nkeys(\"D\", \"T\"): ");
        StdOut.println(edqajtms.range("D", "T"));
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch(); 
    	StdOut.println("Asad Zaheer Test 2\n");
        //floor("Q")
        StdOut.println("floor(\"T\"): ");
        StdOut.println(edqajtms.floor("T"));
        //select(5)
        StdOut.println("\nselect(2): "); 
        StdOut.println(edqajtms.select(5));
        //ceiling("Q")
        StdOut.println("\nceiling(\"M\"): ");
        StdOut.println(edqajtms.ceiling("M"));
        //race rank("J")
        StdOut.println("\nrank(\"A\"): ");
        StdOut.println(edqajtms.rank("A"));
        //keys("D", "T")
        StdOut.println("\nkeys(\"E\", \"M\"): ");
        StdOut.println(edqajtms.range("E", "M"));
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("\nExecution time " + time2 + " seconds.\n");
 		
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch(); 
    	StdOut.println("Asad Zaheer Test 3\n");
        //floor("Q")
        StdOut.println("floor(\"M\"): ");
        StdOut.println(edqajtms.floor("M"));
        //select(5)
        StdOut.println("\nselect(7): "); 
        StdOut.println(edqajtms.select(7));
        //ceiling("Q")
        StdOut.println("\nceiling(\"A\"): ");
        StdOut.println(edqajtms.ceiling("A"));
        //race rank("J")
        StdOut.println("\nrank(\"A\"): ");
        StdOut.println(edqajtms.rank("A"));
        //keys("D", "T")
        StdOut.println("\nkeys(\"A\", \"S\"): ");
        StdOut.println(edqajtms.range("A", "S"));
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("\nExecution time " + time3 + " seconds.\n");
    }
}



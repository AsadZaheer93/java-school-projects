/* 
 * Program Name: Bonus.java
 * @author Asad Zaheer
 * @date 6 April 2020
 * 
 * Bonus (2 points)
 * Algorithm 3.4 Insert for red-black BSTs
 * Implement and test the algorithm 3.4.
 * Add a method to print a RB-BST indexing the subnodes
 * Test the tree, inserting element by element and printing the result with:
 * 1. textbook example: SEARCHEXAMPLE where the value is the index of the letter in the initial word.
 * 2. the letters in your name
 */
package W8_ZAHEER_ASAD;

import java.util.*;

public class Bonus<Key extends Comparable<Key>, Value> {
	public static void main(String[] args) { 
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//add keys and values for S E A R C H E X A M P L E
		StdOut.println("Asad Zaheer Test 1\nS E A R C H E X A M P L E");
		redBlack.put("S", "0"); 
		getValue("S"); 
		display("", redBlack.root, false);
		StdOut.println();
		redBlack.put("E", "1"); 
		getValue("E"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("A", "2"); 
		getValue("A"); 
		display("", redBlack.root, false);
		StdOut.println();
		redBlack.put("R", "3"); 
		getValue("R"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("C", "4"); 
		getValue("C"); 
		display("", redBlack.root, false);
		StdOut.println();
		redBlack.put("H", "5"); 
		getValue("H"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("E", "6"); 
		getValue("E"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("X", "7"); 
		getValue("X"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("A", "8"); 
		getValue("A"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("M", "9"); 
		getValue("M"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("P", "10"); 
		getValue("P"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("L", "11"); 
		getValue("L"); 
		display("", redBlack.root, false); 
		StdOut.println();
		redBlack.put("E", "12"); 
		getValue("E"); 
		display("", redBlack.root, false); 
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
	  	//add keys and values for A S A D Z A H E E R
		StdOut.println("\nAsad Zaheer Test 2\nA S A D Z A H E E R");
		name.put("A", "0"); 
		getValue("A"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("S", "1"); 
		getValue("S"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("A", "2"); 
		getValue("A"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("D", "3"); 
		getValue("D"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("Z", "4"); 
		getValue("Z"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("A", "5"); 
		getValue("A"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("H", "6"); 
		getValue("H"); 
		display("", name.root, false);
		StdOut.println();
		name.put("E", "7"); 
		getValue("E"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("E", "8"); 
		getValue("E"); 
		display("", name.root, false); 
		StdOut.println();
		name.put("R", "9"); 
		getValue("R"); 
		display("", name.root, false); 
		double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("\nExecution time " + time2 + " seconds.\n");
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();
 		StdOut.println("Asad Zaheer Test 3\nA S I K R E T H W A N");
 		//add keys and values for A S I K R E T H W A N
		name2.put("A", "0"); 
		getValue("A"); 
		display("", name2.root, false);
		StdOut.println();
		name2.put("S", "1"); 
		getValue("S"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("I", "2"); 
		getValue("I"); 
		display("", name2.root, false);
		StdOut.println();
		name2.put("K", "3"); 
		getValue("K"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("R", "4"); 
		getValue("R"); 
		display("", name2.root, false);
		StdOut.println();
		name2.put("E", "5"); 
		getValue("E"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("T", "6"); 
		getValue("T"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("H", "7"); 
		getValue("H"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("A", "8"); 
		getValue("A"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("W", "9"); 
		getValue("W"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("A", "10"); 
		getValue("A"); 
		display("", name2.root, false); 
		StdOut.println();
		name2.put("N", "11"); 
		getValue("N"); 
		display("", name2.root, false); 
 		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("\nExecution time " + time3 + " seconds.\n");
		
    }
	//initialize symbol tables
	private static RedBlack<String, String> redBlack = new RedBlack<String, String>(); 
	private static RedBlack<String, String> name = new RedBlack<String, String>(); 
	private static RedBlack<String, String> name2 = new RedBlack<String, String>(); 
	/*
	 * get value for passed in key
	 * 
	 * @param key. the key
	 * 
	 * @return none.
	 */
	public static void getValue(String key) {	
        StdOut.println("Add: " + key + "\nIndex: " + redBlack.get(key));
	}
	/*
	 * display red and black binary tree
	 * 
	 * @param pre. Prefix
	 * @param node. Node of tree
	 * @param left. check if left node exists
	 * 
	 * @return none
	 */
	public static void display(String pre, RedBlack<String, String>.Node n, boolean isLeft) {
		if (n != null) {
			display(pre + "     ", n.right, false);
	        System.out.println (pre + redBlack.toString(n) + n.key);
	        display(pre + "     ", n.left, true);
	    }
	}
    
	
}







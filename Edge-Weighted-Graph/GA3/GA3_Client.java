/*
 * Program Name: GA3_Client.java
 * @author Asad Zaheer
 * @date 24 April 2020
 * 
 * Module 4.3 - Guided Assignment 3 Read a weighted graph from a file (1 point)
 * Implement and test the constructor EdgeWeightedGraph(In in).
 */
package GA3;

public class GA3_Client {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 1\n");
		//create graph from text input
		EdgeWeightedGraph EWG = new EdgeWeightedGraph(new In("./src/tinyEWG.txt"));
		StdOut.println("tinyEWG Graph:"); 
		//print tinyEWG graph
		EWG.detailedPrint();
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
 		
 		//start stop watch for first test
 		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 2\n");
		//create graph from text input
		EdgeWeightedGraph EWG2 = new EdgeWeightedGraph(new In("./src/mediumEWG.txt"));
		StdOut.println("mediumEWG Graph:"); 
		//print tinyEWG graph
		EWG2.detailedPrint();
		double time2 = timer2.elapsedTime();
 		//display the execution time2 first test
 		StdOut.println("Execution time2 " + time2 + " seconds.\n");
 		
 		//start stop watch for first test
 		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 3\n");
		//create graph from text input
		EdgeWeightedGraph EWG3 = new EdgeWeightedGraph(new In("./src/1000EWG.txt"));
		StdOut.println("10000EWG Graph:"); 
		//print tinyEWG graph
		EWG3.detailedPrint();
		double time3 = timer3.elapsedTime();
 		//display the execution time3 first test
 		StdOut.println("Execution time3 " + time3 + " seconds.\n");
	}
}

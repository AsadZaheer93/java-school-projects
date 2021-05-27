/* 
 * Program Name: TestGraph.java
 * @author Asad Zaheer
 * @date 13 April 2020
 * 
 * Read the textbook sections:
 * Representation alternatives (pg 524)
 * Adjacency-lists data structure (pg 525-527)
 * Class Graph (Graph Data Type) (pg 526)
 * Test Search (pg 529)
 * Implement the class Graph
 * Implement a detailedPrint() method that will show in the output (for tinyG.txt, page 522, 524):
 * Number of vertices: 13
 * Number of edges: 13
 * adj[0] = (6, 2, 1, 5)
 * adj[1] = (0)
 * adj[2] = (0)
 * adj[3] = (5, 4)
 * ...
 * Implement TestGraph class that will read the description of a graph and print the detailed description 
 * Test with tinyG.txt; mediumG.txt; largeG.txt
 * Include screenshots with the execution (for the large graphs you do not need to include all the nodes, just the few first)
 */
package TestGraph;

import NoParallelAndLoop.StdOut;
import NoParallelAndLoop.Stopwatch;

public class TestGraph {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//read in file and build graph
		Graph G = new Graph(new In("./src/TestGraph/tinyG.txt"));
		StdOut.println("Asad Zaheer Test 1\n");
		//output results
		G.detailedPrint();
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		//read in file and build graph
		Graph G2 = new Graph(new In("./src/TestGraph/mediumG.txt"));
		StdOut.println("Asad Zaheer Test 2\nThe following data has been limited to the first 100 as the file is to large\n");
		//output results
		G2.detailedPrint();
		double time2 = timer2.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time2 + " seconds.\n");

		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		//read in file and build graph
		Graph G3 = new Graph(new In("./src/TestGraph/LargeG.txt"));
		StdOut.println("Asad Zaheer Test 3\nThe following data has been limited to the first 100 as the file is to large\n");
		//output results
		G3.detailedPrint();
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	}
}

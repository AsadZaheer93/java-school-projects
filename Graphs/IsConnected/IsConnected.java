/* 
 * Program Name: IsConnected.java
 * @author Asad Zaheer
 * @date 13 April 2020
 * 
 * Read the textbook sections:
 * Depth-first search(pg 530)
 * Searching in a maze (pg 530)
 * Warmup (pg 531)
 * Class DepthFirstSearch (pg 531)
 * One way passages (pg 532)
 * Tracing DFS (pg 532)
 * Detailed trace of DFS (pg 533)
 * Implement the class DepthFirstSearch
 * Create a method isConnected that will return true if the graph is connected
 * Implement TestConnected class that will read the description of a graph, print 
 * the detailed description if it has less than 30 nodes and then print if the graph 
 * is connected or not
 * Test with tinyG.txt; mediumG.txt; largeG.txt
 * Include screenshots with the execution (for the large graphs you do not need to 
 * include all the nodes, just the few first)
 */
package IsConnected;

import TestGraphOperations.StdOut;

public class IsConnected {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer Test 1\n");
		//read through file
		Graph G = new Graph(new In("./src/TestGraph/tinyG.txt"));
		//output graph
		G.detailedPrint();
		//search graph to see if it's connected
		DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
		//check if graph is connected
		if(dfs.isConnected()) {
			//output is connected
			StdOut.println("tinyG graph is connected\n");
		}
		else {
			//output not connected
			StdOut.println("tinyG graph is not connected\n");
		}
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 2\n");
		//read through file
		Graph G2 = new Graph(new In("./src/TestGraph/mediumG.txt"));
		//output graph
		G2.detailedPrint();
		//search graph to see if it's connected
		DepthFirstSearch dfs2 = new DepthFirstSearch(G2, 0);
		//check if graph is connected
		if(dfs2.isConnected()) {
			//output is connected
			StdOut.println("mediumG graph is connected\n");
		}
		else {
			//output not connected
			StdOut.println("mediumG graph is not connected\n");
		}
		double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 3\n");
		//read through file
		Graph G3 = new Graph(new In("./src/TestGraph/largeG.txt"));
		//output graph
		G3.detailedPrint();
		//search graph to see if it's connected
		DepthFirstSearch dfs3 = new DepthFirstSearch(G3, 0);
		//check if graph is connected
		if(dfs3.isConnected()) {
			//output is connected
			StdOut.println("largeG graph is connected\n");
		}
		else {
			//output not connected
			StdOut.println("largeG graph is not connected\n");
		}
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	}
}

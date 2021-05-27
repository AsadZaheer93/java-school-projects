/* 
 * Program Name: TraceIsConnected.java
 * @author Asad Zaheer
 * @date 13 April 2020
 * 
 * Read the textbook sections:
 * Depth-first search(pg 530)
 * Tracing DFS (pg 532)
 * Detailed trace of DFS (pg 533)
 * Modify the method isConnected so that will print a spaced trace of calls and 
 * checks (add more spaces for depth) and also print the marked values
 * The output must be similar with the figure on page 533:
 * isConnected() marked = [F,F,F,F...
 * __dfs(0) marked = [T,F,F,F...
 * ____dfs(2) marked = [T,F,F,F...
 * see detailed trace of DFS (pg 533)
 * Test with tinyG.txt; mediumG.txt; largeG.txt
 * Include screenshots with the execution (for the large graphs you do not need to 
 * include all the nodes, just the few first)
 */
package TraceIsConnected;

public class TraceIsConnected {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer Test 1\n");
		//read through file
		Graph G = new Graph(new In("./src/TestGraph/tinyG.txt"));
		//output graph
		G.detailedPrint();
		DepthFirstSearch dfs = new DepthFirstSearch(G);
		StdOut.print("isConnected()");
		//output trace
		dfs.isConnected(G, 0);
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
		DepthFirstSearch dfs2 = new DepthFirstSearch(G2);
		StdOut.print("isConnected()");
		//output trace
		dfs2.isConnected(G, 0);
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
		DepthFirstSearch dfs3 = new DepthFirstSearch(G3);
		StdOut.print("isConnected()");
		//output trace
		dfs3.isConnected(G3, 0);
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	}
}

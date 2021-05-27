/* 
 * Program Name: TestGraphOperations.java
 * @author Asad Zaheer
 * @date 13 April 2020
 * 
 * Read the textbook section
 * Undirected graph data type - API (pg 522)
 * Typical graph processing code (pg 525-527)
 * Operations (pg 527)
 * Implement the following methods
 * Compute the degree of a vertex (0.1)
 * Compute the maximum degree in the graph (0.1)
 * Compute the minimum degree in the graph (0.1)
 * Compute the average degree in the graph (0.1)
 * Count the number of self-loops (0.1)
 * Count the number of parallel vertices (0.1)
 * Add a vertex (0.1)
 * Delete a vertex (0.1)
 * Delete an edge (0.1)
 * Check whether the graph contains the edge v-w (0.1)
 * Implement TestGraphOperations class that will read the description of a graph and 
 * print the detailed description (each tested method 0.1) 
 * Test with tinyG.txt; mediumG.txt; largeG.txt; and random operations for each
 * Start by printing the graph (if the number of vertices is less than 20)
 * Apply all the counting operations on each graph
 * For each graph add 10 vertices, print the graph if the number of vertices is less 
 * than 30 and then delete the 10 vertices  in the order they were added
 * For each graph add 10 random edges, print the graph if the number of vertices is 
 * less than 30, and then delete the 10 edges in the order they were added
 * For each graph test if they contain 10 randomly generated edges. Print the results.
 */
package TestGraphOperations;

public class TestGraphOperations {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		final int TEN = 10;
		StdOut.println("Asad Zaheer Test 1\n");
		Graph G = new Graph(new In("./src/TestGraph/tinyG.txt"));
		StdOut.println("Initial tinyG Graph:\n");
		//check if there are less than 20 vertices
		if(G.V() < 20) {
			G.detailedPrint();
		}
		//add vertices
		StdOut.println("Vertices added: ");
		for(int x = 0; x < TEN; x++) {
			//output added vertices
			StdOut.print(G.V() + ", ");
			Graph.addVertex();
		}
		StdOut.println();
		//check if there are less than 30 vertices
		if(G.V() < 30) {
			G.detailedPrint();
		}
		//delete vertices
		StdOut.println("Vertices deleted: ");
		for(int x = 0; x < TEN; x++) {
			//output deleted vertices
			StdOut.print(G.V() + ", ");
			Graph.deleteVertex(G);
		}
		StdOut.println();
		//check if there are less than 20 vertices
		if(G.V() < 20) {
			G.detailedPrint();
		}
		//add random edges
		int v[] = {0,1,2,3,4,5,6,7,8,9};
		int w[] = {4,0,5,3,1,2,9,6,8,7};
		StdOut.println("Edges added: ");
		for(int x = 0; x < TEN; x++) {
			StdOut.print(v[x] + "-" + w[x] + ", ");
			G.addEdge(v[x], w[x]);
		}
		StdOut.println();
		//output results
		G.detailedPrint();
		//delete edges
		StdOut.println("Edges deleted: ");
		for(int x = 0; x < TEN; x++) {
			StdOut.print(v[x] + "-" + w[x] + ", ");
			Graph.deleteEdge(G, v[x], w[x]);
		}
		StdOut.println();
		//output results
		G.detailedPrint();
		//output results
		StdOut.println("Maximum Degree:" + Graph.maxDegree(G));
		StdOut.println("Minimum Degree:" + Graph.minDegree(G));
		StdOut.println("Average Degree:" + Graph.avgDegree(G));
		StdOut.println("Total self-loops:" + Graph.numberOfSelfLoops(G));
		StdOut.println("Graph contain edge 2-3?" + Graph.hasEdge(G,2,3));
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
		
		
		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 2\n");
		Graph G2 = new Graph(new In("./src/TestGraph/mediumG.txt"));
		StdOut.println("Initial mediumG Graph:\n");
		//check if there are less than 20 vertices
		if(G2.V() < 20) {
			G2.detailedPrint();
		}
		//add vertices
		StdOut.println("Vertices added: ");
		for(int x = 0; x < TEN; x++) {
			//output added vertices
			StdOut.print(G2.V() + ", ");
			Graph.addVertex();
		}
		StdOut.println();
		//check if there are less than 30 vertices
		if(G2.V() < 30) {
			G2.detailedPrint();
		}
		//delete vertices
		StdOut.println("Vertices deleted: ");
		for(int x = 0; x < TEN; x++) {
			//output deleted vertices
			StdOut.print(G2.V() + ", ");
			Graph.deleteVertex(G2);
		}
		StdOut.println();
		//check if there are less than 20 vertices
		if(G2.V() < 20) {
			G2.detailedPrint();
		}
		//add random edges
		int v2[] = {0,1,2,3,4,5,6,7,8,9};
		int w2[] = {1,6,2,3,4,0,7,8,5,9};
		StdOut.println("Edges added: ");
		for(int x = 0; x < TEN; x++) {
			StdOut.print(v2[x] + "-" + w2[x] + ", ");
			G2.addEdge(v2[x], w2[x]);
		}
		StdOut.println();
		//output results
		G2.detailedPrint();
		//delete edges
		StdOut.println("Edges deleted: ");
		for(int x = 0; x < TEN; x++) {
			StdOut.print(v2[x] + "-" + w2[x] + ", ");
			Graph.deleteEdge(G2, v2[x], w2[x]);
		}
		StdOut.println();
		//output results
		G2.detailedPrint();
		//output results
		StdOut.println("Maximum Degree:" + Graph.maxDegree(G2));
		StdOut.println("Minimum Degree:" + Graph.minDegree(G2));
		StdOut.println("Average Degree:" + Graph.avgDegree(G2));
		StdOut.println("Total self-loops:" + Graph.numberOfSelfLoops(G2));
		StdOut.println("Graph contain edge 0-1?" + Graph.hasEdge(G2,0,1));
		double time2 = timer2.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 3\n");
		Graph G3 = new Graph(new In("./src/TestGraph/largeG.txt"));
		StdOut.println("Initial largeG Graph:\n");
		//check if there are less than 20 vertices
		if(G3.V() < 20) {
			G3.detailedPrint();
		}
		//add vertices
		StdOut.println("Vertices added: ");
		for(int x = 0; x < TEN; x++) {
			//output added vertices
			StdOut.print(G3.V() + ", ");
			Graph.addVertex();
		}
		StdOut.println();
		//check if there are less than 30 vertices
		if(G3.V() < 30) {
			G3.detailedPrint();
		}
		//delete vertices
		StdOut.println("Vertices deleted: ");
		for(int x = 0; x < TEN; x++) {
			//output deleted vertices
			StdOut.print(G3.V() + ", ");
			Graph.deleteVertex(G3);
		}
		StdOut.println();
		//check if there are less than 20 vertices
		if(G3.V() < 20) {
			G3.detailedPrint();
		}
		//add random edges
		int v3[] = {0,1,2,3,4,5,6,7,8,9};
		int w3[] = {5,1,3,6,4,7,0,8,2};
		StdOut.println("Edges added: ");
		for(int x = 0; x < 9; x++) {
			StdOut.print(v3[x] + "-" + w3[x] + ", ");
			G3.addEdge(v3[x], w3[x]);
		}
		StdOut.println();
		//output results
		G3.detailedPrint();
		//delete edges
		StdOut.println("Edges deleted: ");
		for(int x = 0; x < 9; x++) {
			StdOut.print(v3[x] + "-" + w3[x] + ", ");
			Graph.deleteEdge(G3, v3[x], w3[x]);
		}
		StdOut.println();
		//output results
		G3.detailedPrint();
		//output results
		StdOut.println("Maximum Degree:" + Graph.maxDegree(G3));
		StdOut.println("Minimum Degree:" + Graph.minDegree(G3));
		StdOut.println("Average Degree:" + Graph.avgDegree(G3));
		StdOut.println("Total self-loops:" + Graph.numberOfSelfLoops(G3));
		StdOut.println("Graph contain edge 5-2?" + Graph.hasEdge(G3,5,2));
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	}
}

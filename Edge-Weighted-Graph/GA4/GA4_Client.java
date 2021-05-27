/*
 * Program Name: GA4_Client.java
 * @author Asad Zaheer
 * @date 24 April 2020
 * 
 * Module 4.3 - Guided Assignment 4 Lazy Prim MST algorithm (1 point)
 * Read
 * MST API and test client (pages 613 - 615)
 * Prim's algorithm (pages 616-619)
 * Class LazyPrimMST (page 619)
 * Implement and test LazyPrimMST (including missing classes - see exercises)
 * Use all the test data files mentioned in the textbook.
 */
package GA4;

public class GA4_Client {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer\n");
		// initialize new Edge Weighted Graph (EWG)
		EdgeWeightedGraph EWG = new EdgeWeightedGraph(new In("./src/tinyEWG.txt"));
		EdgeWeightedGraph EWG1 = new EdgeWeightedGraph(new In("./src/mediumEWG.txt"));
		EdgeWeightedGraph EWG2 = new EdgeWeightedGraph(new In("./src/1000EWG.txt"));

		// Find MSTs for each graph
        LazyPrimMST mst = new LazyPrimMST(EWG); 
        LazyPrimMST mst1 = new LazyPrimMST(EWG1); 
        LazyPrimMST mst2 = new LazyPrimMST(EWG2); 
		
		//output tinyEWG
		StdOut.println("tinyEWG Graph:"); 
		EWG.detailedPrint();	
		//output mediumEWG
		StdOut.println("mediumEWG Graph:"); 
		EWG1.detailedPrint();	
		//output 1000EWG
		StdOut.println("1000EWG Graph:"); 
		EWG2.detailedPrint();	
		StdOut.println();
      		
		//output MSTs
		StdOut.println("Asad Zaheer\nLazy Test 1\n\nMST of given EWG: ");
		//output edges and weight
        for (Edge e : mst.edges()) {											
            StdOut.println(e); 
        }
        //output total MST weight
        StdOut.print("Total MST Weight: "); 
        StdOut.printf("%.5f\n", mst.weight());	
        StdOut.println();
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
        
        //start stop watch for second test
      	Stopwatch timer2 = new Stopwatch();
        //output edges and weight
        StdOut.println("Asad Zaheer\nLazy Test 2\n\nMST of given EWG: ");									
        for (Edge e : mst1.edges()) {												
            StdOut.println(e); 
        }
        //output total MST weight
        StdOut.print("Total MST Weight: "); 
        StdOut.printf("%.5f\n", mst1.weight());	
        StdOut.println();
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
        
        //start stop watch for third test
      	Stopwatch timer3 = new Stopwatch();
        //output edges and weight
        StdOut.println("Asad Zaheer\nLazy Test 3\n\nMST of given EWG: ");									
        for (Edge e : mst2.edges()) {												
            StdOut.println(e); 
        }
        //output total MST weight
        StdOut.print("Total MST Weight: "); 
        StdOut.printf("%.5f\n", mst2.weight());
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	} 
}

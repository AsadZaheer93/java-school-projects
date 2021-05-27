/*
 * Program Name: GA6_Client.java
 * @author Asad Zaheer
 * @date 24 April 2020
 * 
 * Module 4.3 - Guided Assignment 6 Kruskal's algorithm (1 point)
 * Read
 * Kruskal's algorithm (pages 624-630)
 * Algorithm 4.8 (page 627)
 * Implement and test Algorithm 4.8.
 */
package GA6;

public class GA6_Client {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer\n");
		//initialize graphs
		EdgeWeightedGraph EWG = new EdgeWeightedGraph(new In("./src/tinyEWG.txt"));
		EdgeWeightedGraph EWG1 = new EdgeWeightedGraph(new In("./src/mediumEWG.txt"));
		EdgeWeightedGraph EWG2 = new EdgeWeightedGraph(new In("./src/1000EWG.txt"));
		//create MSTs for each graph
        KruskalMST mst = new KruskalMST(EWG); 
        KruskalMST mst1 = new KruskalMST(EWG1); 
        KruskalMST mst2 = new KruskalMST(EWG2); 
        //output original EWG
        StdOut.println("tinyEWG Graph:");
		EWG.detailedPrint();				
		StdOut.println("mediumEWG Graph:"); 
		EWG1.detailedPrint();				
		StdOut.println("1000EWG Graph:"); 
		EWG2.detailedPrint();	
        
        StdOut.println("Asad Zaheer\nKruskal Test 1\n\nMST of tinyEWG: ");										
        for (Edge e : mst.edges()) {												
        	//output each edge and weight
            StdOut.println(e); 
        }
        //output total weight
        StdOut.print("Total MST Weight: "); 
        StdOut.printf("%.5f\n", mst.weight());	
        StdOut.println();
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
        
        //start stop watch for second test
        Stopwatch timer2 = new Stopwatch();
        StdOut.println("Asad Zaheer\nKruskal Test 2\n\nMST of mediumEWG: ");										
        for (Edge e : mst1.edges()) {	
        	//output each edge and weight
            StdOut.println(e); 
        }
        //output total weight
        StdOut.print("Total MST Weight: "); 
        StdOut.printf("%.5f\n", mst1.weight());	
        StdOut.println();
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
        
        //start stop watch for third test
      	Stopwatch timer3 = new Stopwatch();
        StdOut.println("Asad Zaheer\nKruskal Test 3\n\nMST of 1000EWG: ");										
        for (Edge e : mst2.edges()) {			
        	//output each edge and weight
            StdOut.println(e); 
        }
        //output total weight
        StdOut.print("Total MST Weight: "); 
        StdOut.printf("%.5f\n", mst2.weight());	
        StdOut.println();
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	} 
}

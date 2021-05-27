/*
 * Program Name: GA5_Client.java
 * @author Asad Zaheer
 * @date 24 April 2020
 * 
 * Module 4.3 - Guided Assignment 5 Eager version of Prim's MST algorithm (1 point)
 * Read
 * Eager version of Prim's algorithm (pages 620-623)
 * Class PrimMST (page 622)
 * Implement and test class PrimMST (page 622) including the mentioned exercises.
 */
package GA5;

public class GA5_Client {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer");
		//initialize graphs
		EdgeWeightedGraph EWG = new EdgeWeightedGraph(new In("./src/tinyEWG.txt"));
		EdgeWeightedGraph EWG1 = new EdgeWeightedGraph(new In("./src/mediumEWG.txt"));
		EdgeWeightedGraph EWG2 = new EdgeWeightedGraph(new In("./src/1000EWG.txt"));
		//create MSTs for each graph
        PrimMST mst = new PrimMST(EWG); 
        PrimMST mst1 = new PrimMST(EWG1); 
        PrimMST mst2 = new PrimMST(EWG2); 
		//output original EWG
		StdOut.println("tinyEWG Graph");
		EWG.detailedPrint();				
		StdOut.println("mediumEWG Graph"); 
		EWG1.detailedPrint();				
		StdOut.println("1000EWG Graph"); 
		EWG2.detailedPrint();					
      
		StdOut.println("Asad Zaheer\nPrism Test 1\n\nMST of tinyEWG: ");										
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
        StdOut.println("Asad Zaheer\nPrism Test 2\n\nMST of mediumEWG: ");										
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
        StdOut.println("Asad Zaheer\nPrism Test 3\n\nMST of 1000EWG: ");										
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

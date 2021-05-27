/*
 * Program Name: TestEdge.java
 * @author Asad Zaheer
 * @date 24 April 2020
 * 
 * Read
 * Section 4.3 Introduction (page 604)
 * Assumptions (page 605)
 * Underlying principles (pages 606-607)
 * Edge-weighted graph data type (pages 608-609)
 * 
 * Implement and test Weighted edge data type (1 point)
 * Implement class Edge (page 610)
 * Design and implement a class TestEdge that will create and print the first 
 * 5 edges in the tinyEWG file (see page 604 for values)  
 */
package GA1;

public class TestEdge {
	public static void main(String[] args)  {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 1\n");
		//create edges
		Edge e1 = new Edge(2, 8, 0.75);
		Edge e2 = new Edge(4, 3, 0.29);
		Edge e3 = new Edge(5, 2, 0.33);
		Edge e4 = new Edge(0, 10, 0.93);
		Edge e5 = new Edge(3, 6, 0.22);
		//output edges
    	StdOut.println(e1);
    	StdOut.println(e2);
    	StdOut.println(e3);
    	StdOut.println(e4);
    	StdOut.println(e5);	
    	StdOut.println();
    	double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
    	
 		Stopwatch timer2 = new Stopwatch();
    	StdOut.println("Asad Zaheer\n\nTest 2\n");
    	//create edges
    	Edge e6 = new Edge(1, 1, 0.88);
		Edge e7 = new Edge(4, 5, 0.62);
		Edge e8 = new Edge(0, 7, 0.23);
		Edge e9 = new Edge(3, 6, 0.34);
		Edge e10 = new Edge(2, 10, 0.02);
		//output edges
    	StdOut.println(e6);
    	StdOut.println(e7);
    	StdOut.println(e8);
    	StdOut.println(e9);
    	StdOut.println(e10);	
    	StdOut.println();
    	double time2 = timer2.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
    	
    	Stopwatch timer3 = new Stopwatch();
    	StdOut.println("Asad Zaheer\n\nTest 3\n");
    	//create edges
    	Edge e11 = new Edge(4, 1, 0.97);
		Edge e12 = new Edge(0, 7, 0.30);
		Edge e13 = new Edge(5, 8, 0.98);
		Edge e14 = new Edge(3, 9, 0.96);
		Edge e15 = new Edge(1, 10, 0.14);
		//output edges
    	StdOut.println(e11);
    	StdOut.println(e12);
    	StdOut.println(e13);
    	StdOut.println(e14);
    	StdOut.println(e15);	
    	StdOut.println();
    	double time3 = timer3.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	}
}

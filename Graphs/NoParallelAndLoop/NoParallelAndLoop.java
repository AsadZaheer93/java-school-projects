/* 
 * Program Name: NoParrallelAndLoop.java
 * @author Asad Zaheer
 * @date 13 April 2020
 * 
 * Exercise 4.1.5 (1 point)
 * Modify Graph to disallow parallel edges and self-loops (try to define 
 * one that contains each of them and see that error is shown)
 */
package NoParallelAndLoop;

public class NoParallelAndLoop extends Graph {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize graph
		NoParallelAndLoop graph = new NoParallelAndLoop(5);
		StdOut.println("Asad Zaheer Test 1\n");
		//build graph
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		StdOut.println("Current Graph:\n" + graph);
		//add edges
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        //output results
        StdOut.println("Graph after added edges:\n" + graph);
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
 		//initialize graph
		NoParallelAndLoop graph2 = new NoParallelAndLoop(5);
		StdOut.println("Asad Zaheer Test 2\n");
		//build graph
		graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 3);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
		StdOut.println("Current Graph:\n" + graph2);
		//add edges
		graph2.addEdge(1, 0);
		graph2.addEdge(1, 3);
		//output results
        StdOut.println("Graph after added edges:\n" + graph2);
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();
 		//initialize graph
		NoParallelAndLoop graph3 = new NoParallelAndLoop(5);
		StdOut.println("Asad Zaheer Test 3\n");
		//build graph
		graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(0, 3);
        graph3.addEdge(1, 2);
        graph3.addEdge(1, 3);
        graph3.addEdge(1, 4);
        graph3.addEdge(2, 3);
        graph3.addEdge(2, 4);
		StdOut.println("Current Graph:\n" + graph3);
		//add edges
		graph3.addEdge(3, 4);
		graph3.addEdge(4, 0);
		graph3.addEdge(4, 2);
		//output results
        StdOut.println("Graph after added edges:\n" + graph3);
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
    }
	/*
     * initialize a graph
     *
     * @param V number of vertices
     * 
     * @return none
     */
	public NoParallelAndLoop(int V) {
        super(V);
    }
	/*
	 * check edges
	 * 
	 * @param v. vertex one
	 * @param w. vertex two
	 * 
	 * @return none
	 */
    public void addEdge(int v, int w) {
        //check to see if self loops and parallel edges exists
        if (v == w || hasEdge(v, w)) {
        	//error message for parallel or self loop
        	StdOut.println("Edges between vertices " + v + " and " + w + " are either parallels or self loops\n");
            return;
        }
        super.addEdge(v, w);
    }
    /*
     * check if adjacent vertices have edges
     * 
     * @param v. vertex one
	 * @param w. vertex two
	 * 
	 * @return true or false
     */
    private boolean hasEdge(int v, int w) {
        for(int edge: adj(v)) {
        	//check if adjacent vertices have edges
            if (edge == w) {
                return true;
            }
        }
        return false;
    }
}

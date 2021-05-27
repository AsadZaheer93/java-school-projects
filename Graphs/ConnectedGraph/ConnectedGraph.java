/* 
 * Program Name: ConnectedGraph.java
 * @author Asad Zaheer
 * @date 13 April 2020
 * 
 * 4.1.10 Prove that every connected graph has a vertex whose removal 
 * (including all adjacent edges) will not disconnect the graph, and
 * write a DFS method that finds such a vertex. Hint : Consider a 
 * vertex whose adjacent vertices are all marked.
 */
package ConnectedGraph;

public class ConnectedGraph {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer Test 1\n");
		//initialize graph
        Graph graph = new Graph(6);
        //build graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        //output graph
        StdOut.println(graph);
        //connected graph initialize
        ConnectedGraph connectedGraph = new ConnectedGraph(graph, 0);
        StdOut.println("Total vertices removed: " + connectedGraph.searchRemovedVertex());
        StdOut.println();
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 2\n");
		//initialize graph
        Graph graph2 = new Graph(6);
        //build graph
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 3);
        graph2.addEdge(0, 4);
        graph2.addEdge(0, 5);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 3);
        graph2.addEdge(2, 4);
        //output graph
        StdOut.println(graph2);
        //connected graph initialize
        ConnectedGraph connectedGraph2 = new ConnectedGraph(graph2, 0);
        StdOut.println("Total vertices removed: " + connectedGraph2.searchRemovedVertex());
        StdOut.println();
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Asad Zaheer Test 3\n");
		//initialize graph
        Graph graph3 = new Graph(6);
        //build graph
        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(0, 3);
        graph3.addEdge(0, 4);
        graph3.addEdge(0, 5);
        graph3.addEdge(1, 2);
        graph3.addEdge(1, 3);
        graph3.addEdge(1, 4);
        graph3.addEdge(2, 3);
        graph3.addEdge(2, 4);
        graph3.addEdge(2, 5);
        graph3.addEdge(3, 4);
        //output graph
        StdOut.println(graph);
        //connected graph initialize
        ConnectedGraph connectedGraph3 = new ConnectedGraph(graph3, 0);
        StdOut.println("Total vertices removed: " + connectedGraph3.searchRemovedVertex());
        StdOut.println();
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
    }
	//initialize variables
	private boolean[] marked;
    private int count;
    private int removeV;
    private Graph graph;
    private int v;
    /*
     * Initializes a 
     *
     * @param graph. previous graph created
     * @param V. v
     *
     * @return none
     */
    public ConnectedGraph(Graph graph, int v) {
    	marked = new boolean[graph.V()];
        this.graph = graph;
        this.v = v;
    }
    /*
     * find removed vertex
     * 
     * @param none
     * 
     * @return removeV. vertex removed
     */
    public int searchRemovedVertex() {
        dfs(graph, v);
        return removeV;
    }
    /*
     * search through graph
     * 
     * @param graph. previous graph created
     * @param v. vertex
     * 
     * @return none
     */
    private void dfs(Graph graph, int v) {
    	//increase number of removed vertices
    	marked[v] = true;
        count++;
        boolean isMarked = true;
        //check each vertex of a graph
        for(int nextTo : graph.adj(v)) {
        	//check if a vertex has been visited before
            if (!marked[nextTo]) {
            	isMarked = false;
                dfs(graph, nextTo);
            }
        }
        if (isMarked) {
        	removeV = v;
        }
    }
    /*
     * check if vertex is marked(previously visited)
     * 
     * @param v. vertex
     * 
     * @return true or false
     */
    public boolean marked(int v) {
        return marked[v];
    }
    /*
     * total number of removed vertices
     * 
     * @param none
     * 
     * @return count. total number of removed vertices
     */
    public int count() {
        return count;
    }
}

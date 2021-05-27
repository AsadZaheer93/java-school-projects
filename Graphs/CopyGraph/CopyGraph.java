/* 
 * Program Name: CopyGraph.java
 * @author Asad Zaheer
 * @date 13 April 2020
 * 
 * 4.1.3 Create a copy constructor for Graph that takes as input a graph G 
 * and creates and initializes a new copy of the graph. Any changes a 
 * client makes to G should not affect the newly created graph.
 */
package CopyGraph;

public class CopyGraph {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer Test 1\n");
		//initialize graph
        Graph graph = new Graph(5);
        //build graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        //output graph
        StdOut.println("Initial graph:\n" + graph);
        //copy old graph to new graph
        CopyGraph copyGraph = new CopyGraph(graph);
        //add one edge	
        copyGraph.addEdge(0, 4);
        //output results
        StdOut.println("Copy graph after adding one edge:\n" + copyGraph);
        StdOut.println("And initial graph before copying:\n" + graph);
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
        StdOut.println("Initial graph:\n" + graph2);
        //copy old graph to new graph
        CopyGraph copyGraph2 = new CopyGraph(graph2);
        //add one edge		
        copyGraph2.addEdge(3, 4);
        //output results
        StdOut.println("Copy graph after adding one edge:\n" + copyGraph2);
        StdOut.println("And initial graph before copying:\n" + graph2);
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
        StdOut.println("Initial graph:\n" + graph3);
        //copy old graph to new graph
        CopyGraph copyGraph3 = new CopyGraph(graph3);
        //add two edges
        copyGraph3.addEdge(3, 5);
        copyGraph3.addEdge(4, 5);
        //output results
        StdOut.println("Copy graph after adding one edge:\n" + copyGraph3);
        StdOut.println("And initial graph before copying:\n" + graph3);
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
    }
	//initialize variables
	private final int V;
    private int E;
    private Bag<Integer>[] adj;
    /*
     * Initializes a graph with number of vertices.
     *
     * @param V. v
     *
     * @return none
     */
    public CopyGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }
    /*
     * Initializes a graph from input.
     *
     * @param  in the input stream
     *
     * @return none
     */
    public CopyGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    /*
     * Initializes a graph from another graph.
     *
     * @param graph. initially created graph
     *
     * @return none
     */
    public CopyGraph(Graph G) {
    	//initialize vertices and edges
    	this.V = G.V();
        this.E = G.E();
        //create bag
        adj = (Bag<Integer>[]) new Bag[V];
        //copy vertices
        for(int x = 0; x < V; x++) {
        	adj[x] = new Bag<>();
        }
        //copy G
        for(int v = 0; v < G.V(); v++) {
            Stack<Integer> stack = new Stack<>();
            //copy connecting vertices for edges
            for (int next : G.getAdj()[v]) {
                stack.push(next);
            }
            for (int next : stack) {
                adj[v].add(next);
            }
        }
    }
    /*
     * get the number of vertices
     * 
     * @param none
     *
     * @return V. the number of vertices
     */
    public int V() {
        return V;
    }
    /*
     * get the number of edges.
     * 
     * @param none
     *
     * @return E. the number of edges
     */
    public int E() {
        return E;
    }
    /*
     * Add undirected edges
     *
     * @param  v. one v in the edge
     * @param  w. the other v in the edge
     * 
     * @return
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    /*
     * get the vertices adjacent to v.
     *
     * @param v. the v
     * 
     * @return adj[v]. adjacent v
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    /*
     * Returns a string of this graph.
     * 
     * @param none
     *
     * @return s. the number of vertices
     */
    public String toString() {
    	String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
     	   	s += v + ": ";
     	   	for (int w : this.adj(v)) {
     	   		s += w + " ";
     	   	}
     	   	s += "\n";
        }
        return s; 
    }
}

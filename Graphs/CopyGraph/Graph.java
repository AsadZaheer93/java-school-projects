package CopyGraph;

public class Graph {
	//initialize variables
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
    /*
     * initialize a graph
     *
     * @param  V number of vertices
     * 
     * @return none
     */
    public Graph(int V) {
    	this.V = V; 
    	this.E = 0;
    	adj = (Bag<Integer>[]) new Bag[V]; 
    	for (int v = 0; v < V; v++) {
          adj[v] = new Bag<Integer>();
    	}
    }
    /*
     * Initializes a graph from input.
     *
     * @param  in the input stream
     *
     * @return none
     */
    public Graph(In in) {
    	this(in.readInt());
    	int E = in.readInt();
    	for (int i = 0; i < E; i++) { // Add an edge.
    		int v = in.readInt(); 
    		int w = in.readInt(); 
    		addEdge(v, w);
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
     * @param  v. one vertex in the edge
     * @param  w. the other vertex in the edge
     * 
     * @return
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    /*
     * get the vertices adjacent to vertex.
     *
     * @param v. the vertex
     * 
     * @return adj. adjacent
     */
    public Bag<Integer>[] getAdj() {
        return adj;
    }
    /*
     * get the vertices adjacent to vertex.
     *
     * @param v. the vertex
     * 
     * @return adj[v]. adjacent vertex
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
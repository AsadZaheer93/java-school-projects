package TestGraph;

public class Graph {
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
    	this.V = in.readInt();
        int E = in.readInt();
        adj = (Bag<Integer>[]) new Bag[V];
    	for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        for (int i = 0; i < E; i++) {
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
    public Graph(Graph G) {
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
     * @return adj[v]. adjacent vertex
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    /*
     * Returns a string of this graph.
     * 
     * @param none.
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
    /*
     * Returns first 100 string of this graph.
     * 
     * @param none.
     *
     * @return none
     */
    public void detailedPrint() {
    	String string = "Vertices: " + V + "\nEdges: " + E + "\n";
    	int limit = V;
        if(V > 100) {
        	limit = 100;
        }
        for (int v = 0; v < limit; v++) {
            string += "adj[" + v + "] = (";
            int size = adj[v].size();
            for (int w : adj[v]) {
        		string += w + ", ";
            	size --;
            }
            string += ")\n";
        }
    	StdOut.println(string);
    }
}
package GA1;
/**
 *  The {@code Digraph} class represents a directed graph of vertices
 *  named 0 through <em>V</em> - 1.
 *  It supports the following two primary operations: add an edge to the digraph,
 *  iterate over all of the vertices adjacent from a given vertex.
 *  It also provides
 *  methods for returning the indegree or outdegree of a vertex, 
 *  the number of vertices <em>V</em> in the digraph, 
 *  the number of edges <em>E</em> in the digraph, and the reverse digraph.
 *  Parallel edges and self-loops are permitted.
 *  <p>
 *  This implementation uses an <em>adjacency-lists representation</em>, which
 *  is a vertex-indexed array of {@link Bag} objects.
 *  It uses &Theta;(<em>E</em> + <em>V</em>) space, where <em>E</em> is
 *  the number of edges and <em>V</em> is the number of vertices.
 *  All instance methods take &Theta;(1) time. (Though, iterating over
 *  the vertices returned by {@link #adj(int)} takes time proportional
 *  to the outdegree of the vertex.)
 *  Constructing an empty digraph with <em>V</em> vertices takes
 *  &Theta;(<em>V</em>) time; constructing a digraph with <em>E</em> edges
 *  and <em>V</em> vertices takes &Theta;(<em>E</em> + <em>V</em>) time.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/42digraph">Section 4.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Digraph {
	//initialize variables
    private final int V;           
    private int E;                
    private Bag<Integer>[] adj;    
    private int[] indegree;        
    /*
     * Initialize digraph
     *
     * @param  V. number of vertices
     * 
     * @return none
     */
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /*
     * Initializes a digraph with input .
     *
     * @param in. input 
     * 
     * @return none
     */
    public Digraph(In in) {
    	this.V = in.readInt();
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w); 
        }
    }

    /*
     * Initialize new digraph that is a deep copy of another digraph.
     *
     * @param G. digraph to be copied
     * 
     * @return none
     */
    public Digraph(Digraph G) {
        this.V = G.V();
        this.E = G.E();
        //update indegrees
        indegree = new int[V];
        for (int v = 0; v < V; v++) {
            this.indegree[v] = G.indegree(v);
        }
        //update adjacency lists
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        //reverse to original order
        for (int v = 0; v < G.V(); v++) {
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
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
     * validate vertex
     * 
     * @param v. vertex
     * 
     * @return none
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("ERROR! Vertex must be between 0 and " + (V-1));
        }
    }
    /*
     * Add directed edges
     *
     * @param  v. tail vertex
     * @param  w. head vertex
     * 
     * @return
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
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
        validateVertex(v);
        return adj[v];
    }
    /*
     * Returns the number of directed edges from the vertex
     *
     * @param v. the vertex
     * 
     * @return adj[v].size(). outdegree vertex
     */
    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /*
     * Returns the number of directed edges from the vertex
     *
     * @param  v. the vertex
     * 
     * @return indegree[v]. indegree vertex 
     */
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    /*
     * reverse digraph
     * 
     * @param none
     *
     * @return reverse. digraph in reverse
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
        	for (int w : adj(v)) {
        		reverse.addEdge(w, v);
        	}
        }
        return reverse;
    }
    /*
     * Returns first 10 string of this graph.
     * 
     * @param none.
     *
     * @return none
     */
    public void detailedPrint() {
    	String string = "Vertices: " + V + "\nEdges: " + E + "\n";
    	int limit = V;
        if(V > 10) {
        	limit = 10;
        }
        for (int v = 0; v < limit; v++) {
            string += "adj[" + v + "] = (";
            int size = adj[v].size();
            for (int w : adj[v]) {
        		string += w;
        		if(size != 1) {
        			string += ", ";
        		}
            	size --;
            }
            string += ")\n";
        }
    	StdOut.println(string);
    }
}


package GA6;
import java.util.NoSuchElementException;

/**
 *  The {@code EdgeWeightedGraph} class represents an edge-weighted
 *  graph of vertices named 0 through <em>V</em> � 1, where each
 *  undirected edge is of type {@link Edge} and has a real-valued weight.
 *  It supports the following two primary operations: add an edge to the graph,
 *  iterate over all of the edges incident to a vertex. It also provides
 *  methods for returning the degree of a vertex, the number of vertices
 *  <em>V</em> in the graph, and the number of edges <em>E</em> in the graph.
 *  Parallel edges and self-loops are permitted.
 *  By convention, a self-loop <em>v</em>-<em>v</em> appears in the
 *  adjacency list of <em>v</em> twice and contributes two to the degree
 *  of <em>v</em>.
 *  <p>
 *  This implementation uses an <em>adjacency-lists representation</em>, which
 *  is a vertex-indexed array of {@link Bag} objects.
 *  It uses &Theta;(<em>E</em> + <em>V</em>) space, where <em>E</em> is
 *  the number of edges and <em>V</em> is the number of vertices.
 *  All instance methods take &Theta;(1) time. (Though, iterating over
 *  the edges returned by {@link #adj(int)} takes time proportional
 *  to the degree of the vertex.)
 *  Constructing an empty edge-weighted graph with <em>V</em> vertices takes
 *  &Theta;(<em>V</em>) time; constructing a edge-weighted graph with
 *  <em>E</em> edges and <em>V</em> vertices takes
 *  &Theta;(<em>E</em> + <em>V</em>) time. 
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/43mst">Section 4.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private Bag<Edge>[] adj;
    
    
    
    /**
     * Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    /**
     * Initializes a random edge-weighted graph with {@code V} vertices and <em>E</em> edges.
     *
     * @param  V the number of vertices
     * @param  E the number of edges
     * @throws IllegalArgumentException if {@code V < 0}
     * @throws IllegalArgumentException if {@code E < 0}
     */
    public EdgeWeightedGraph(int V, int E) {
        this(V);
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }
    
    /**  
     * Initializes an edge-weighted graph from an input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices and edge weights,
     * with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IllegalArgumentException if {@code in} is {@code null}
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     */
    public EdgeWeightedGraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");

        try {
            V = in.readInt();
            adj = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Edge>();
            }

            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                double weight = in.readDouble();
                Edge e = new Edge(v, w, weight);
                addEdge(e);
            }
        }   
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in EdgeWeightedGraph constructor", e);
        }
    }

    /*
     * Initializes a new edge-weighted graph
     *
     * @param  G. the edge-weighted graph to copy
     * 
     * @return none
     */
    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }
    /*
     * number of vertices
     * 
     * @param none
     *
     * @return the number of vertices
     */
    public int V() {
        return V;
    }

    /*
     * number of edges
     * 
     * @param none
     *
     * @return the number of edges
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
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    /*
     * Adds undirected edge 
     * 
     * @param  e. edge
     * 
     * @return none
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /*
     * edges on vertex
     *
     * @param v. vertex
     * 
     * @return the edges incident on vertex 
     */
    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /*
     * degree of vertex 
     *
     * @param  v the vertex
     * 
     * @return the degree of vertex
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /*
     * Returns all edges in this edge-weighted graph.
     * 
     * @param none
     * 
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                //add one copy of self loop
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                    	list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }
    /*
     * Returns first 10 string of this graph.
     * 
     * @param none.
     *
     * @return none
     */
    public void detailedPrint() {		
    	//initialize string
        String string = V + " vertices\n" + E + " edges\n";
        //set maximum
        int sizeCap = V;	
        //set max to 10
        if(V > 10) {										
        	sizeCap = 10;
        }
        //build string for 10 vertices
        for (int v = 0; v < sizeCap; v++) {				
            string += "Vertices: ";
            int a = adj[v].size();
            if(adj[v] != null) {
                for (Edge w : adj[v]) {
            		string += w;
                	if(a != 1) {
                		string += ", ";
                	}
                	a --;
                }
            }
            string += "\n";
        }
        //output string
    	StdOut.println(string);					
    }
}





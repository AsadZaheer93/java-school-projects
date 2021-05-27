package TraceIsConnected;

import NoParallelAndLoop.StdOut;

public class Graph {
    private static int V;
    private int E;
    private static Bag<Integer>[] adj;
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
    /*
     * compute the degree of v
     * 
     * @param G. graph
     * @param v. vertex
     * 
     * @return degree. degree of v
     */
    public static int degree(Graph G, int v) {
    	int degree = 0;
    	for (int w : G.adj(v)) {
    		degree++; 
    	}
    	return degree;
    }
    
    /*
     * compute maximum degree
     * 
     * @param G. graph
     * 
     * @return max. maximum degree
     */
    public static int maxDegree(Graph G) {
    	int max = 0;
    	for (int v = 0; v < G.V(); v++) {
    		if (degree(G, v) > max) {
    			max = degree(G, v);
    		}
    	}
    	return max; 
    }
    /*
     * compute minimum degree
     * 
     * @param G. graph
     * 
     * @return min. minimum degree
     */
    public static int minDegree(Graph G) {
		int min = G.V();
		for(int v = 0; v < G.V(); v++) {
			if(degree(G, v) < min) {
				min = degree(G, v);
			}
		}
		return min;
	}
    /*
     * compute average degree
     * 
     * @param G. graph
     * 
     * @return average degree
     */
    public static int avgDegree(Graph G) { 
    	return 2 * G.E() / G.V(); 
    }
    /*
     * count self loops
     * 
     * @param G. graph
     * 
     * @return number of loops
     */
    public static int numberOfSelfLoops(Graph G) {
    	int count = 0;
    	for (int v = 0; v < G.V(); v++) {
    		for (int w : G.adj(v)) {
    			if (v == w) count++;
    		}
    	}
    	return count/2;   // each edge counted twice
    }
    /*
     * check if adjacent vertices have edges
     * 
     * @param v. vertex one
	 * @param w. vertex two
	 * 
	 * @return true or false
     */
    static boolean hasEdge(Graph G, int v, int w) {
    	for(int t: G.adj(v)) {
			if(t == w) {
				return true;
			}
    	}
		return false;
    }
    /*
     * delete edge
     * 
     * @param G. graph
     * @param v. vertex one
	 * @param w. vertex two
	 * 
	 * @return none
     */
    public static void deleteEdge(Graph G, int v, int w) {
		G.adj[v].remove(w);
		G.adj[w].remove(v);
	}
    /*
     * add vertex
     * 
     * @param none
	 * 
	 * @return none
     */
    public static void addVertex() {
    	Bag<Integer>[] items = (Bag<Integer>[])new Bag[V+1];
		for (int x = 0; x < V; x++) {
			items[x] = adj[x];
		}
		items[V] = new Bag<Integer>();
		V += 1;
		adj = items;
    }
    /*
     * delete vertex
     * 
     * @param G. graph
	 * 
	 * @return none
     */
	public static void deleteVertex(Graph G) {
		V--;
	}
}
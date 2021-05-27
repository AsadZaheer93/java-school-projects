package GA4;
/******************************************************************************
 *  Compilation:  javac LazyPrimMST.java
 *  Execution:    java LazyPrimMST filename.txt
 *  Dependencies: EdgeWeightedGraph.java Edge.java Queue.java
 *                MinPQ.java UF.java In.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/43mst/tinyEWG.txt
 *                https://algs4.cs.princeton.edu/43mst/mediumEWG.txt
 *                https://algs4.cs.princeton.edu/43mst/largeEWG.txt
 *
 *  Compute a minimum spanning forest using a lazy version of Prim's 
 *  algorithm.
 *
 *  %  java LazyPrimMST tinyEWG.txt 
 *  0-7 0.16000
 *  1-7 0.19000
 *  0-2 0.26000
 *  2-3 0.17000
 *  5-7 0.28000
 *  4-5 0.35000
 *  6-2 0.40000
 *  1.81000
 *
 *  % java LazyPrimMST mediumEWG.txt
 *  0-225   0.02383
 *  49-225  0.03314
 *  44-49   0.02107
 *  44-204  0.01774
 *  49-97   0.03121
 *  202-204 0.04207
 *  176-202 0.04299
 *  176-191 0.02089
 *  68-176  0.04396
 *  58-68   0.04795
 *  10.46351
 *
 *  % java LazyPrimMST largeEWG.txt
 *  ...
 *  647.66307
 *
 ******************************************************************************/
/**
 *  The {@code LazyPrimMST} class represents a data type for computing a
 *  <em>minimum spanning tree</em> in an edge-weighted graph.
 *  The edge weights can be positive, zero, or negative and need not
 *  be distinct. If the graph is not connected, it computes a <em>minimum
 *  spanning forest</em>, which is the union of minimum spanning trees
 *  in each connected component. The {@code weight()} method returns the 
 *  weight of a minimum spanning tree and the {@code edges()} method
 *  returns its edges.
 *  <p>
 *  This implementation uses a lazy version of <em>Prim's algorithm</em>
 *  with a binary heap of edges.
 *  The constructor takes &Theta;(<em>E</em> log <em>E</em>) time in
 *  the worst case, where <em>V</em> is the number of vertices and
 *  <em>E</em> is the number of edges.
 *  Each instance method takes &Theta;(1) time.
 *  It uses &Theta;(<em>E</em>) extra space in the worst case
 *  (not including the edge-weighted graph).
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/43mst">Section 4.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For alternate implementations, see {@link PrimMST}, {@link KruskalMST},
 *  and {@link BoruvkaMST}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class LazyPrimMST {
	//initialize variables
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private double weight;      
    private Queue<Edge> mst;    
    private boolean[] marked;    
    private MinPQ<Edge> pq;      

    /*
     * minimum spanning tree (or forest) of an edge-weighted graph.
     * 
     * @param G. graph
     * 
     * @return none
     */
    public LazyPrimMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
            	//get minimum spanning forest
            	prim(G, v);     
            }
        }
        // check optimality conditions
        assert check(G);
    }

    /*
     * Prim's algorithm
     * 
     * @param G. graph
     * @param s. source
     * 
     * @return none
     */
    private void prim(EdgeWeightedGraph G, int s) {
        scan(G, s);
        while (!pq.isEmpty()) {                       
            Edge e = pq.delMin();                  
            int v = e.either(), w = e.other(v);        
            assert marked[v] || marked[w];
            if (marked[v] && marked[w]) {
            	continue;      
            }
            //add e to MST
            mst.enqueue(e);                            
            weight += e.weight();
            if (!marked[v]) {
            	//v is part of tree
            	scan(G, v);               
            }
            if (!marked[w]) {
            	//w is part of tree
            	scan(G, w);  
            }
        } 
    }        
    /*
     * add all edges
     * 
     * @param G. graph
     * @param v. vertex
     * 
     * @return none
     */
    private void scan(EdgeWeightedGraph G, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
            	pq.insert(e); 
            }
        }
    }
    /*
     * Returns the edges 
     * 
     * @param none
     * 
     * @return mst. the edges 
     */
    public Iterable<Edge> edges() {
        return mst; }

    /*
     * sum of edge weights
     * 
     * @param none
     * 
     * @return weight. sum of edge weights 
     */
    public double weight() {
        return weight; 
    }
    /*
     * add to all edges from v to unmarked vertices
     * 
     * @param G. graph
     * @param v. vertex
     * 
     * @return none
     */
    private void visit(EdgeWeightedGraph G, int v)   {  
    	//mark v    
    	marked[v] = true;      
    	for (Edge e : G.adj(v)) {    
    		if (!marked[e.other(v)]) {
    			//add to all edges from v to unmarked vertices.  
    			pq.insert(e);   
    		}
    	}
    } 
    
    /*
     * check optimality conditions 
     * 
     * @param G. graph
     * 
     * @return true or false
     */
    private boolean check(EdgeWeightedGraph G) {
        //check weight
        double totalWeight = 0.0;
        for (Edge e : edges()) {
            totalWeight += e.weight(); 
        }
        if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
            return false; 
        }
        //check if acyclic
        UF uf = new UF(G.V());
        for (Edge e : edges()) {
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) == uf.find(w)) {
                System.err.println("Not a forest");
                return false; 
            }
            uf.union(v, w); 
        }
        //check if spanning forest
        for (Edge e : G.edges()) {
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) != uf.find(w)) {
                System.err.println("Not a spanning forest");
                return false; 
            } 
        }
        //check if minimal spanning forest 
        for (Edge e : edges()) {
            //all edges in MST except e
            uf = new UF(G.V());
            for (Edge f : mst) {
                int x = f.either();
                int y = f.other(x);
                if (f != e) {
                	uf.union(x, y); 
                }
        	}
            //check if e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either(), y = f.other(x);
                if (uf.find(x) != uf.find(y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;  
                    }  
                }  
            }  
        }
        return true; 
    }
    /*
     * Unit tests 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}















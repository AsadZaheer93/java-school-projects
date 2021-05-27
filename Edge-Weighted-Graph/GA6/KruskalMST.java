package GA6;
/******************************************************************************
 *  Compilation:  javac KruskalMST.java
 *  Execution:    java  KruskalMST filename.txt
 *  Dependencies: EdgeWeightedGraph.java Edge.java Queue.java MinPQ.java
 *                UF.java In.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/43mst/tinyEWG.txt
 *                https://algs4.cs.princeton.edu/43mst/mediumEWG.txt
 *                https://algs4.cs.princeton.edu/43mst/largeEWG.txt
 *
 *  Compute a minimum spanning forest using Kruskal's algorithm.
 *
 *  %  java KruskalMST tinyEWG.txt 
 *  0-7 0.16000
 *  2-3 0.17000
 *  1-7 0.19000
 *  0-2 0.26000
 *  5-7 0.28000
 *  4-5 0.35000
 *  6-2 0.40000
 *  1.81000
 *
 *  % java KruskalMST mediumEWG.txt
 *  168-231 0.00268
 *  151-208 0.00391
 *  7-157   0.00516
 *  122-205 0.00647
 *  8-152   0.00702
 *  156-219 0.00745
 *  28-198  0.00775
 *  38-126  0.00845
 *  10-123  0.00886
 *  ...
 *  10.46351
 *
 ******************************************************************************/

/**
 *  The {@code KruskalMST} class represents a data type for computing a
 *  <em>minimum spanning tree</em> in an edge-weighted graph.
 *  The edge weights can be positive, zero, or negative and need not
 *  be distinct. If the graph is not connected, it computes a <em>minimum
 *  spanning forest</em>, which is the union of minimum spanning trees
 *  in each connected component. The {@code weight()} method returns the 
 *  weight of a minimum spanning tree and the {@code edges()} method
 *  returns its edges.
 *  <p>
 *  This implementation uses <em>Krusal's algorithm</em> and the
 *  union-find data type.
 *  The constructor takes &Theta;(<em>E</em> log <em>E</em>) time in
 *  the worst case.
 *  Each instance method takes &Theta;(1) time.
 *  It uses &Theta;(<em>E</em>) extra space (not including the graph).
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/43mst">Section 4.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For alternate implementations, see {@link LazyPrimMST}, {@link PrimMST},
 *  and {@link BoruvkaMST}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class KruskalMST {
	//initialize variables
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private double weight;                        
    private Queue<Edge> mst = new Queue<Edge>();  
    /*
     * minimum spanning tree 
     *  
     * @param G. graph
     * 
     * @return none
     */
    public KruskalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e); 
        }
        //run greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            //does not create cycle
            if (uf.find(v) != uf.find(w)) { 
            	//merge
                uf.union(v, w); 
                //add edge
                mst.enqueue(e); 
                weight += e.weight(); 
            }  
        }
        // check optimality conditions
        assert check(G);  
    }
    /*
     * edges in a minimum spanning tree 
     * 
     * @param none
     * 
     * @return mst. edges in a minimum spanning tree 
     */
    public Iterable<Edge> edges() {
        return mst;  
    }
    /*
     * sum of the edge weights
     * 
     * @param none
     * 
     * @return weight. sum of the edge weights
     */
    public double weight() {
        return weight;  
        
    }
    /*
     * check optimal conditions
     * 
     * @param G. graph
     * 
     * @return true or false
     */
    private boolean check(EdgeWeightedGraph G) {
        double total = 0.0;
        //accumulate total weight
        for (Edge e : edges()) {
            total += e.weight();  
        }
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
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
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);  
            }
            //check if e is minimum weight edge in crossing cut
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
     * 
     * @return none
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);  
        }
        StdOut.printf("%.5f\n", mst.weight());  
    }  
}
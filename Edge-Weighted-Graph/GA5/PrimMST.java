package GA5;
public class PrimMST {
	//initialize variables
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private Edge[] edgeTo;       
    private double[] distTo;     
    private boolean[] marked;    
    private IndexMinPQ<Double> pq;
    /*
     *  minimum spanning tree .
     * 
     * @param G. graph
     * 
     * @return none
     */
    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        for (int v = 0; v < G.V(); v++) { 
            if (!marked[v]) {
            	//minimum spanning forest
            	prim(G, v);      
            }
        }
        //check optimality conditions
        assert check(G);
    }
    /* 
     * Prim's algorithm 
     * 
     * @param G. graph
     * @param s. vertex
     * 
     * @return none
     */
    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }
    /*
     * scan vertex
     * 
     * @param G. graph
     * @param v. vertex
     * 
     * @return none
     */
    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
            	continue;         
            }
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                	pq.decreaseKey(w, distTo[w]);
                }
                else {
                	pq.insert(w, distTo[w]);
                }
            }
        }
    }
    /*
     * edges in a minimum spanning tree 
     * 
     * @param none
     * 
     * @return mst.  edges in a minimum spanning tree 
     */
    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    /*
     * sum of the edge weights in a minimum spanning tree 
     * 
     * @param none
     * 
     * @return weight. sum of the edge weights in a minimum spanning tree 
     */
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
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
            int v = e.either(), w = e.other(v);
            if (uf.find(v) != uf.find(w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }
        //check if minimal spanning forest
        for (Edge e : edges()) {
            uf = new UF(G.V());
            for (Edge f : edges()) {
                int x = f.either();
                int y = f.other(x);
                if (f != e) {
                	uf.union(x, y);
                }
            }
            //check if e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either();
                int y = f.other(x);
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
     * Unit tests the 
     *
     * @param args the command-line arguments
     * 
     * @return none
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
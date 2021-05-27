package TraceIsConnected;

public class DepthFirstSearch {
	//initialize variables
	private boolean[] marked;
	private int count;
	/*
	 * default constructor for graph
	 * 
	 * @param G. graph
	 * @param s. source
	 */
	public DepthFirstSearch(Graph G) {
		marked = new boolean[G.V()];
	}
	/*
	 * search through graph
	 * 
	 * @param G. graph
	 * @param v. vertex
	 * 
	 * @return none
	 */
	private void dfs(Graph G, int v, int zero) {
		//initialize variables
		marked[v] = true;
		count++;
		//depth
		for(int x = 0; x < zero; x++) {
			StdOut.print("|     ");
		}
		StdOut.print("dfs(" + v + ")");
		//show all vertices that are marked
		display();
		for(int w : G.adj(v)) {
			if(count < 30) {
				if(!marked[w]) {
					dfs(G, w, (zero + 1));
				}
			}
		}
	}
	/*
	 * return if node is marked
	 * 
	 * @param w. vertex
	 * 
	 * @return true or false
	 */
	public boolean marked(int w) {
		return marked[w];
	}
	/*
	 * get number of connected components
	 * 
	 * @param none
	 * 
	 * @return count. number of connected components
	 */
	public int count() {
		return count;
	}
	/*
	 * check if graph is connected
	 * 
	 * @param G. graph
	 * @param s. source
	 * 
	 * @return none
	 */
	public void isConnected(Graph G, int s) {
		display();
		dfs(G, s, 0);
	}
	/*
	 * Output marked vertices
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public void display() {
		StdOut.print(" marked = [");
		//output each vertex if it is marekd or not
		for(int x = 0; x < marked.length - 1; x++) {
			if(marked[x] == true) {
				//output T if true
				StdOut.print("T,");
			}
			else {
				//output F if false
				StdOut.print("F,");
			}
		}
		StdOut.print("]\n");
	}
	
}

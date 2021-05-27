package IsConnected;

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
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	/*
	 * search through graph
	 * 
	 * @param G. graph
	 * @param v. vertex
	 * 
	 * @return none
	 */
	private void dfs(Graph G, int v) {
		marked[v] = true;
		count++;
		for(int w : G.adj(v)) {
			if(count < 30) {
				if(!marked[w]) {
					dfs(G, w);
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
	 * @param none
	 * 
	 * @return true or false
	 */
	public boolean isConnected() {
		if(count == marked.length)
			return true;
		return false;
	}
}

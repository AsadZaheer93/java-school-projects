/*
 * Program Name: Nonrecursive.java
 * @author Asad Zaheer
 * @date 27 March 2020
 * 
 * Exercise 3.2.13 (1 point) Non-recursive implementation for get and put in BST
 * 
 * 3.2.13 Give nonrecursive implementations of get() and put() for BST. Partial 
 * solution : Here is an implementation of get():
 * 
 * 	public Value get(Key key) {
 * 		Node x = root;
 * 		while (x != null) {
 * 			int cmp = key.compareTo(x.key); 
 * 			if (cmp == 0) return x.val; 
 * 			else if (cmp < 0) x = x.left; 
 * 			else if (cmp > 0) x = x.right;
 * 		}
 * 		return null;
 *	}
 *
 * The implementation of put() is more complicated because of the need to save 
 * a pointer to the parent node to link in the new node at the bottom. Also, 
 * you need a separate pass to check whether the key is already in the table 
 * because of the need to update the counts. Since there are many more searches 
 * than inserts in performance-critical implementations, using this code for 
 * get() is justified; the corresponding change for put() might not be noticed.
 * 
 */
package W7_ZAHEER_ASAD;

public class Nonrecursive<Key extends Comparable, Val> {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();    	
		//create table
		Nonrecursive<String, String> asad = new Nonrecursive<String, String>();
    	StdOut.println("Asad Zaheer Test 1\n");
    	//build table
    	asad.put("0", "A");
    	asad.put("1", "S");
    	asad.put("2", "A");
    	asad.put("3", "D");
    	asad.put("4", "Z");
    	asad.put("5", "A");
    	asad.put("6", "H");
    	asad.put("7", "E");
    	asad.put("8", "E");
    	asad.put("9", "R");
        //output results
        StdOut.println("Key 0: \tValue: " + asad.get("0")); 
        StdOut.println("Key 3: \tValue: " + asad.get("3")); 
        StdOut.println("Key 8: \tValue: " + asad.get("8")); 
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();    	
		//create table
		Nonrecursive<String, String> ateeb = new Nonrecursive<String, String>();
    	StdOut.println("Asad Zaheer Test 2\n");
    	//build table
    	ateeb.put("0", "A");
    	ateeb.put("1", "T");
    	ateeb.put("2", "E");
    	ateeb.put("3", "E");
    	ateeb.put("4", "B");
    	ateeb.put("5", "A");
    	ateeb.put("6", "M");
    	ateeb.put("7", "I");
    	ateeb.put("8", "R");
        //output results
        StdOut.println("Key 1: \tValue: " + ateeb.get("1")); 
        StdOut.println("Key 3: \tValue: " + ateeb.get("3")); 
        StdOut.println("Key 5: \tValue: " + ateeb.get("5")); 
        StdOut.println("Key 7: \tValue: " + ateeb.get("7")); 
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("\nExecution time " + time2 + " seconds.\n");
 		
 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();    	
		//create table
		Nonrecursive<String, String> asik = new Nonrecursive<String, String>();
    	StdOut.println("Asad Zaheer Test 3\n");
    	//build table
    	asik.put("0", "A");
    	asik.put("1", "S");
    	asik.put("2", "I");
    	asik.put("3", "K");
    	asik.put("4", "R");
    	asik.put("5", "E");
    	asik.put("6", "T");
    	asik.put("7", "H");
    	asik.put("8", "W");
    	asik.put("9", "A");
    	asik.put("10", "N");
        //output results
        StdOut.println("Key 2: \tValue: " + asik.get("2")); 
        StdOut.println("Key 3: \tValue: " + asik.get("3")); 
        StdOut.println("Key 4: \tValue: " + asik.get("4")); 
        StdOut.println("Key 6: \tValue: " + asik.get("6")); 
        StdOut.println("Key 8: \tValue: " + asik.get("8")); 
        StdOut.println("Key 10: Value: " + asik.get("10")); 
        StdOut.println("Key 0: \tValue: " + asik.get("0")); 
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("\nExecution time " + time3 + " seconds.\n");
    }
	//initialize node
	private Node root;
	//linked-list node
    private class Node {
        private Key key;              
        private Val val;              
        private Node left; 
        private Node right;
        public Node(Key key, Val val) {
            this.key = key;
            this.val = val;
        }
    }
    /*
	 * put key-value pair into the table (remove key from table if value is null)
	 * resize table if needed
	 * 
	 * @param key. Location of valued pair
	 * @param val. Value of key pair
	 * 
	 * @return none
	 */
    public void put(Key key, Val val) {
    	//New node
        Node z = new Node(key, val);
        //check if root exists
        if (root == null) {
            root = z;
            return;
        }
        //initialize node
        Node parent = null;
        Node x = root;
        //add key and value to node
        while (x != null) {
            parent = x;
            int r = key.compareTo(x.key);
            if (r < 0) {
            	//reset node to left of
            	x = x.left;
            }
            else if (r > 0) {
            	//reset node to right of
            	x = x.right;
            }
            else {
            	//set value
                x.val = val;
                return;
            } 
        }
        int r = key.compareTo(parent.key);
        if (r < 0) {
        	parent.left  = z;
        }
        else {
        	parent.right = z;
        }
    }
    /*
	 * value paired with key (null if key is absent)
	 * 
	 * @param key. Location of valued pair
	 * 
	 * @return val. Value of key pair
	 */
    public Val get(Key key) {
    	//initialize node
        Node x = root;
        //grab key
        while (x != null) {
            int r = key.compareTo(x.key);
            if (r < 0) {
            	//reset node to left of
            	x = x.left;
            }
            else if (r > 0) {
            	//reset node to right of
            	x = x.right;
            }
            else {
            	//return node value
            	return x.val;
            }
        }
        return null;
    }
    /*
	 * Is there a value paired with key?
	 * 
	 * @param key. Location of valued pair
	 * 
	 * @return boolean. Existence of key
	 */
    public boolean contains(Key key) {
    	//check if keys exists
        return get(key) != null;
    }
    /*
     * Number of key-value pairs
     * 
     * @param none.
     * 
     * @return size. Number of key-value pairs
     */
    public int size() {
        return size(root);
    }
    /*
     * Number of key-value pairs
     * 
     * @param node. Node value
     * 
     * @return size. Number of key-value pairs
     */
    public int size(Node node) {
    	//initialize size
    	int size = 0;
    	//check if size exists
        if (node == null) {
        	size = 0;
        }
        else {
        	//calculate size
        	size = 1 + size(node.left) + size(node.right);
        }
        return size;
    }
}

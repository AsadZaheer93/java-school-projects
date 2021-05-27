/*
 * Program Name: BinearySearchAlphabetName.java
 * @author Asad Zaheer
 * @date 15 March 2020
 * 
 * Exercise 3 (1 point): Implement and test Algorithm 3.2
 * Implement Algorithm 3.2 (0.5 points). Implement Binary search in an ordered 
 * array for generic classes Key and Value. Follow the implementation in the 
 * textbook. 
 * Test Algorithm 3.2 (0.5 points). Create a test program for your implementation, 
 * that will test all the letters in the alphabet if they are or not in your name, 
 * and print the associated value if they are. For my name the output will start 
 * like:
 * 
 * A - fourth letter
 * B - sixth letter
 * C - ninth letter
 * D - not found
 * E - not found
 * 
 * This program will output the keys and values for each table and then compare
 * each item with an alphabet array to see if it is the same or not.
 */
package W6_ZAHEER_ASAD;

public class BinearySearchAlphabetName<Key extends Comparable<Key>, Value> {
	public static void main(String[] args) { 
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		BinearySearchAlphabetName<String, String> asad = new BinearySearchAlphabetName<String, String>();
		final int ALPHABET = 26;
        StdOut.println("Asad Zaheer Test 1");
        StdOut.println();
        //build first table
        asad.put("A", "first letter");
        asad.put("S", "second letter");
        asad.put("A", "third letter");
        asad.put("D", "fourth letter");
        asad.put("Z", "fifth letter");
        asad.put("A", "sixth letter");
        asad.put("H", "seventh letter");
        asad.put("E", "eighth letter");
        asad.put("E", "ninth letter");
        asad.put("R", "tenth"); 
        //initialize alphabet
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        //output name
        asad.display();
        //output letter and whether found or not	
        for (int x = 0; x < ALPHABET; x++) {
            String letter = alphabet[x];
            StdOut.println(letter + ": " + asad.get(letter));
        }
        double time = timer.elapsedTime();
        //display the execution time first test
        StdOut.println("\nExecution time " + time + " seconds.\n");
        
        Stopwatch timer2 = new Stopwatch();
		BinearySearchAlphabetName<String, String> ateeb = new BinearySearchAlphabetName<String, String>();
        StdOut.println("Asad Zaheer Test 2");
        StdOut.println();
        //build second table
        ateeb.put("A", "first letter");
   	 	ateeb.put("T", "second letter");
   	 	ateeb.put("E", "third letter");
   	 	ateeb.put("E", "fourth letter");
   	 	ateeb.put("B", "fifth letter");
   	 	ateeb.put("M", "sixth letter");
   	 	ateeb.put("A", "seventh letter");
   	 	ateeb.put("M", "eighth letter");
   	 	ateeb.put("I", "ninth letter");
   	 	ateeb.put("R", "tenth");
   	 	//output name
   	 	ateeb.display();
   	 	//output letter and whether found or not
        for (int x = 0; x < ALPHABET; x++) {
            String letter = alphabet[x];
            StdOut.println(letter + ": " + ateeb.get(letter));
        }
        double time2 = timer2.elapsedTime();
        //display the execution time first test
        StdOut.println("\nExecution time " + time2 + " seconds.\n");
        
        Stopwatch timer3 = new Stopwatch();
		BinearySearchAlphabetName<String, String> asik = new BinearySearchAlphabetName<String, String>();
        StdOut.println("Asad Zaheer Test 3");
        StdOut.println();
        //build third table
        asik.put("A", "first letter");
   	 	asik.put("S", "second letter");
   	 	asik.put("I", "third letter");
   	 	asik.put("K", "fourth letter");
   	 	asik.put("R", "fifth letter");
   	 	asik.put("E", "sixth letter");
   	 	asik.put("T", "seventh letter");
   	 	asik.put("H", "eighth letter");
   	 	asik.put("W", "ninth letter");
   	 	asik.put("A", "tenth");
   	 	//output name
   	 	asik.display();
   	 	//output letter and whether found or not
        for (int x = 0; x < ALPHABET; x++) {
            String letter = alphabet[x];
            StdOut.println(letter + ": " + asik.get(letter));
        }
        double time3 = timer3.elapsedTime();
        //display the execution time third test
        StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	//initialize node
	private static final int MAX = 10;
    private Key[] keys;
    private Value[] vals;
    private int size = 0;
    /*
     * Sets the maximum
     * 
     * @param none
     * 
     * @return none
     */
    public BinearySearchAlphabetName() {
        this(MAX);
    }
    /*
     * Sets the maximum key and value
     * 
     * @param max. Maximum values
     * 
     * @return none
     */
    public BinearySearchAlphabetName(int max) { 
        keys = (Key[]) new Comparable[max]; 
        vals = (Value[]) new Object[max]; 
    }   
    /*
     * Number of key-value pairs
     * 
     * @param none.
     * 
     * @return size. Number of key-value pairs
     */
    public int size() {
        return size;
    }
    /*
	 * Check if table is empty
	 * 
	 * @param none.
	 * 
	 * @return boolean. Whether table is empty or not
	 */
    public boolean isEmpty() {
        return size() == 0;
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
	 * Resize the table and copy keys and values to new table
	 * 
	 * @param max. Maximum values
	 * 
	 * @return none
	 */
    private void resize(int max) {
    	//initialize new size
        Key[] tempKey = (Key[])   new Comparable[max];
        Value[] tempValue = (Value[]) new Object[max];
        //copy keys and values
        for (int x = 0; x < size; x++) {
        	tempKey[x] = keys[x];
        	tempValue[x] = vals[x];
        }
        vals = tempValue;
        keys = tempKey;
    }
    /*
	 * value paired with key (null if key is absent)
	 * 
	 * @param key. Location of valued pair
	 * 
	 * @return val. Value of key pair
	 */
    public Value get(Key key) {
    	//return nothing if table is empty
        if (isEmpty()) {
        	return null;
        }
        //find key rank
        int x = search(key); 
        if (x < size){
           if (keys[x].compareTo(key) == 0) {
        	   return vals[x]; 
           }
        }
        return null;
    } 
    /*
     * Number of keys less than key
     * 
     * @param key. Location of valued pair
     * 
     * @return mid. Number of keys
     * @return lo. Number of keys
     */
    public int rank(Key key) {
    	//Initialize variables
        int lo = 0;
        int hi = size - 1; 
        //search through each node
        while (lo <= hi) { 
        	//Initialize variables
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            //check rank size
            if (cmp < 0) {
            	//new rank
            	hi = mid - 1; 
            }
            else if (cmp > 0) {
            	//new rank
            	lo = mid + 1; 
            }
            else {
            	return mid; 
            }
        } 
        return lo;
    } 
    /*
     * Search for rank position and output steps, lo, mid, hi and comparisons
     * 
     * @param key. Location of valued pair
     * 
     * @return mid. Number of keys
     * @return lo. Number of keys 
     */
    public int search(Key key) {
    	//initialize variables
        int lo = 0;
        int hi = size - 1; 
        while (lo <= hi) { 
        	//initialize variables
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
            	//new rank
            	hi = mid - 1; 
            }
            else if (cmp > 0) {
            	//new rank
            	lo = mid + 1; 
            }
            else {
            	return mid; 
            }
        } 
        return lo;
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
    public void put(Key key, Value val)  {
        if (val == null) {
            delete(key);
            return;
        }
        //new rank
        int x = rank(key);
        //check if key is in the table
        if (x < size && keys[x].compareTo(key) == 0) {
            vals[x] = val;
            return;
        }
        //resize table
        if (size == keys.length) {
        	resize(2 * keys.length);
        }
        //copy table
        for (int y = size; y > x; y--)  {
            keys[y] = keys[y - 1];
            vals[y] = vals[y - 1];
        }
        //new keys and value after copy
        keys[x] = key;
        vals[x] = val;
        size++;
    } 
    /*
	 * Remove key (and its value) from table
	 * 
	 * @param key. Location of valued pair
	 * 
	 * @return none
	 */
    public void delete(Key key) {
        if (isEmpty()) {
        	return;
        }
        //get rank
        int rank = rank(key);
        // key not in table
        if ((rank == size) || (keys[rank].compareTo(key) != 0)) {
            return;
        }
        //copy table
        for (int x = rank; x < size - 1; x++)  {
            keys[x] = keys[x + 1];
            vals[x] = vals[x + 1];
        }
        //decrease size and change end of keys and values to null
        size--;
        keys[size] = null;  // to avoid loitering
        vals[size] = null;
        //resize by half if 25% full
        if ((size > 0) && (size == keys.length / 4)) {
        	resize(keys.length / 2);
        }
    } 
    /*
	 * Output the keys and values
	 * 
	 * @param none
	 * 
	 * @return none
	 */
    public void display() {
    	//output all keys based on current size
    	System.out.print("keys = {");
    	for (int x = 0; x < 9; x++) {
    		System.out.print(keys[x] + " , ");
    	}
    	System.out.print(keys[9] + "}");
    	StdOut.println();
    	//output all values based on current size
    	System.out.print("vals = {");
    	for (int x = 0; x < 9; x++) {
    		System.out.print(vals[x] + " , ");
    	}
    	System.out.println(vals[9] + "}");
    	StdOut.println();
    }
}

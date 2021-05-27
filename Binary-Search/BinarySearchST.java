/*
 * Program Name: BinarySearchST.java
 * @author Asad Zaheer
 * @date 15 March 2020
 * 
 * Exercise 2 (1.5 points): Trace Algorithm 3.2 Binary search in an ordered array (p. 379)
 * Step 1. (0.5 points) Create an ordered array containing the first 10 letters in your name 
 * as keys (first name followed by the last name, not necessary distinct, add a few letters 
 * at the end if your name is shorter, consider only the first 10 letters). My name: 
 * M I H A I B O I C U. The associated value for each letter will be a text like: "first 
 * letter", "second letter" to "tenth letter". Assume the capacity is 10. Trace the PUT 
 * method in the textbook to create the array, showing only the call made, and how the 
 * array will look after the call (not all the internal computations). Either use a 
 * graphical model or a text model, like below:
 * 
 * Key[] keys = {null, null, null, null, null, null, null, null, null, null};
 * Value[] vals = {null, null, null, null, null,null, null, null, null, null};
 * int n = 0;
 * put ("M","first letter")
 * keys = {"M", null, null, null, null, null, null, null, null, null};
 * vals = {"first letter", null, null, null, null,null, null, null, null, null};
 * n = 1;
 * put ("I", second letter")
 * keys = {"I", "M", null, null, null, null, null, null, null, null};
 * vals = {"second letter", "first letter", null, null, null,null, null, null, null, null};
 * n = 2;
 * 
 * Step 2: (0.5 points) Trace how search will work for searching a key with your sixth letter 
 * in your name. Trace both rank and get methods. For rank, trace the lo, hi, mid and cmp 
 * variables, for each step in the while method. Start with the result of the previous step. 
 * Show your values before the call. Present the trace as a table or as a text like above.
 * 
 * Step 3: (0.5 points) Trace how search will work for searching a key that is not in your 
 * name (e.g. "D" in my case). Trace both rank and get methods. For rank, trace the lo, hi, 
 * mid and cmp variables, for each step in the while method. Start with the result of the 
 * previous step. Show your values before the call. Present the trace as a table or as a 
 * text like above in step 2.
 * 
 * This program will trace the keys and values as the size of the table increases. Then
 * it will output a trace of the sixth position of the table and also the value of Q in
 * the table.
 */
package W6_ZAHEER_ASAD;

import java.util.*;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	public static void main(String[] args) { 
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
    	BinarySearchST<String, String> asad = new BinarySearchST<String, String>();
        StdOut.println("Asad Zaheer Test 1");
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
        //output current table	
        StdOut.println("Current Table:");
   	 	asad.display();
   	 	//trace sixth position
        StdOut.println("\nSearching sixth position:");
        StdOut.println("Value: " + asad.get("A"));
        //output current table
        StdOut.println("\nCurrent Table:");
        asad.display();
        //trace Q
        StdOut.println("\nSearching Q");
        StdOut.println("Value: " + asad.get("Q"));
        double time = timer.elapsedTime();
        //display the execution time first test
        StdOut.println("\nExecution time " + time + " seconds.\n");
        
        //start stop watch for second test
        Stopwatch timer2 = new Stopwatch();
    	BinarySearchST<String, String> ateeb = new BinarySearchST<String, String>();
        StdOut.println("Asad Zaheer Test 2");
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
   	 	//output current table	
   	 	StdOut.println("Current Table:");
	 	ateeb.display();
	 	//trace sixth position
        StdOut.println("\nSearching sixth position:");
        StdOut.println("Value: " + ateeb.get("M"));
        //output current table
        StdOut.println("\nCurrent Table:");
        ateeb.display();
        //trace Q	
        StdOut.println("\nSearching Q");
        StdOut.println("Value: " + ateeb.get("Q"));
        double time2 = timer2.elapsedTime();
        //display the execution time second test
        StdOut.println("\nExecution time " + time2 + " seconds.\n");
        
        Stopwatch timer3 = new Stopwatch();
    	BinarySearchST<String, String> asik = new BinarySearchST<String, String>();
        StdOut.println("Asad Zaheer Test 3");
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
   	 	//output results	
   	 	StdOut.println("Current Table:");
   	 	asik.display();
   	 	//trace sixth position
        StdOut.println("\nSearching sixth position:");
        StdOut.println("Value: " + asik.get("E")); 
        //output current table	
        StdOut.println("\nCurrent Table:");
   	 	asik.display();
   	 	//trace Q
        StdOut.println("\nSearching Q");
        StdOut.println("Value: " + asik.get("Q"));
        double time3 = timer3.elapsedTime();
        //display the execution time second test
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
    public BinarySearchST() {
        this(MAX);
    }
    /*
     * Sets the maximum key and value
     * 
     * @param max. Maximum values
     * 
     * @return none
     */
    public BinarySearchST(int max) { 
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
	 * Resize the table and copy keys and values to new table
	 * 
	 * @param max. Maximum values
	 * 
	 * @return none
	 */
    private void resize(int max) {
        //initialize new size
        Key[] tempKey = (Key[]) new Comparable[max];
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
    	//output initial key
        StdOut.println("get (" + key + ")");
        //find key rank
        int x = search(key); 
        if (x < size){
        	//check if values are equal
        	if (keys[x].compareTo(key) == 0) {
        		//output equal values
        		StdOut.println(key + " equal with " + keys[x]);
        		return vals[x]; 
        	}
        	else {
        		//output non-equal values
        		StdOut.println(key + " not equal with " + keys[x]);
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
        int step = 1;
        int lo = 0;
        int hi = size - 1; 
        //output current rank key
        StdOut.println("rank (" + key + ")\n");
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            //output steps, lo, mid, and hi values
            StdOut.println("Step " +step + ": \nlo: " + lo + "\nmid: " + mid + "\nhi: " + hi);
            int cmp = key.compareTo(keys[mid]);
            //output comparisons
            StdOut.println("cmp: " + cmp + " compares to " + mid); 
            StdOut.println();
            step++;  
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
        StdOut.println("put (" + key + ", " + val + ")");
        //output if key is in the table
        if (x < size && keys[x].compareTo(key) == 0) {
            vals[x] = val;
            display();
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
        display();
    } 
    /*
	 * Remove key (and its value) from table
	 * 
	 * @param key. Location of valued pair
	 * 
	 * @return none
	 */
    public void delete(Key key) {
    	//check if table is empty
        if (isEmpty()) {
        	//return nothing
        	return;
        }
        //get rank
        int rank = rank(key);
        //key does not exits in the table
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
        keys[size] = null;
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
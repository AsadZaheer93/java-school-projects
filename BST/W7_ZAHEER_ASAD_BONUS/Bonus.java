/*
 * Program Name: RandomKeySymbolTable.java
 * @author Asad Zaheer
 * @date 30 March 2020
 * 
 * Create a dictionary as a binary tree.
 * 1. Data structure (0.1 points) A word in a dictionary will keep the key (the defined word) 
 * and a definition (another string). For each node we will keep a link to the left subtree 
 * containing the words before the current word and a link to the right subtree containing 
 * the words after the current word. 
 * 
 * 2. Test and initialize (0.1 points) Create a method that will initialize a binary tree with 
 * 15 terms from the textbook. Provide correct names and definitions for the test data. 
 * 
 * 3. Print a binary tree (0.1 points) Create a method that will print a binary tree in the 
 * following format.
 * 		LEFT NODE
 * 	ROOT NODE
 * 		RIGHT NODE
 * Use a recursive function that will receive the number of spaces before a node (4 spaces 
 * for each level), and a node. The function will do nothing if the node is null. If the 
 * node has a left subtree, call it recursively to print the subtree, but with more spaces. 
 * Then print the spaces and the node key. Then print recursively the right subtree with 
 * more spaces. Test the method by showing the tree after each operation performed in step 2.
 * 
 * 3. Find a word in the dictionary (0.1 points) Create method that will receive a word and 
 * return the definition if the word is in dictionary or null otherwise. Test the method 
 * with two words from dictionary and two not in the dictionary. 
 * 
 * 4. Insert a word (0.1 points) Create method that will receive a word and its definition. 
 * If the word is in dictionary, update the definition. If not, add the word to the dictionary. 
 * Test the method with two refined definitions and two new definitions. Print the dictionary 
 * after each operation.
 * 
 * 5. Check if leaf, single leaf and two leaves (0.1 points) Create three methods that will 
 * check if a word is a leaf, has a single child or has 2 children. Returns true if the property 
 * holds, otherwise false. Check the method with various words: 2 leafs, 2 single child, 2 two 
 * children and 2 not in the dictionary. Print the dictionary after each operation.
 * 
 * 6. Delete a leaf node (0.1 points) Create a method that will receive a word and if the word 
 * is a leaf delete the node from the dictionary. Check the method with various words: 2 leafs, 
 * 2 single child, 2 two children and 2 not in the dictionary. Print the dictionary after each 
 * operation.
 * One way to implement is: create a method that will receive a subtree root node and a key to 
 * delete. If the node is a leaf and has the same key remove the node from the tree and return 
 * the resulted subtree. The caller must link the subtree. 
 * 
 * 7. Delete a node with a child (0.1 points) Create  a method that will receive a word and if 
 * the word has a single child delete the node from the dictionary. Check the method with various 
 * words: 2 leafs, 2 single child, 2 two children and 2 not in the dictionary. Print the 
 * dictionary after each operation.
 * 
 * 8. Delete a node with two children (0.1 points) Create  a method that will receive a word and 
 * if the word has two children delete the node from the dictionary. Check the method with various 
 * words: 2 leafs, 2 single child, 2 two children and 2 not in the dictionary. Print the dictionary 
 * after each operation.
 * 
 * 9. Delete any node  (0.1 points) Combine the previous 3 delete methods to create one method to 
 * delete any node. Check the method with various words: 2 leafs, 2 single child, 2 two children 
 * and 2 not in the dictionary. Print the dictionary after each operation.
 * 
 * 10. First and last word (0.1 points) Create  a method that will return the first and the last 
 * word from the dictionary. Check the methods.
 * 
 * 11. Preorder (0.3 points) Create a method that will traverse the tree in preorder and show 
 * the words in the console. Check the method. 
 * 
 * 12. Inorder (0.2 points) Create a method that will traverse the tree in inorder and show the 
 * words in the console. Check the method. 
 * 
 * 13. Postorder (0.3 points) Create a method that will traverse the tree in postorder and show 
 * the words in the console. Check the method. 
 * 
 * 14. Height of the tree (0.1 points) Create a method that will compute the height tree. Check 
 * the method. 
 * 
 * 15. Find the word with longest definition (0.1 points). Create a method that will compute 
 * the word with the longest definition. Check the method. 
 */
package W7_ZAHEER_ASAD_BONUS;

import java.util.*;

public class Bonus<Key extends Comparable<Key>, Value> {
	public static void main(String[] args) { 
		//start stop watch for first test
		Stopwatch timer = new Stopwatch(); 
		StdOut.println("Asad Zaheer Test 1\n");
	  	//add keys and values to dictionary table
		dictionary.put("declaration", "create a variable of a specified type, named with a given identifier");
		dictionary.put("assignment", "assign a data-type value to a variable");
		dictionary.put("initializing declaration", "declaration that also assigns an initial value");
		dictionary.put("implicit assignment", "i = i + 1;"); 
		dictionary.put("conditional (if)", "execute a statement, depending on boolean expression"); 
		dictionary.put("conditional (if-else)", "execute one or the other statement, depending on boolean expression"); 
		dictionary.put("loop (while)", "execute statement until boolean expression is false"); 
		dictionary.put("loop (for)", "compact version of while statement"); 
		dictionary.put("call", "invoke other methods "); 
		dictionary.put("return", "return from a method"); 
		dictionary.put("arrays", "stores a sequence of values that are all of the same type"); 
		dictionary.put("strings", "a sequence of characters"); 
		dictionary.put("path", "a sequence of vertices connected by edges"); 
		dictionary.put("cycle", "a path with at least one edge whose first and last vertices are the same"); 
		dictionary.put("tree", "an acyclic connected graph"); 
		//display tree
		StdOut.println("Print Binary Tree");
		displayBinaryTree("", dictionary.root, false);
		//find word and display word and definition
		StdOut.println("\nDefinitions:");
		getDef("tree");
		getDef("one");
		getDef("assignment");
		getDef("data");
		//new or updated definitions
		StdOut.println("\nNew/Updated Definitions:");
		newWordDef("tree", "a woody perennial plant, typically having a single stem or trunk growing to a considerable height and bearing lateral branches at some distance from the ground.");
		newWordDef("path", "a way or track laid down for walking or made by continual treading."); 
		newWordDef("datatype", "a particular kind of data item, as defined by the values it can take, the programming language used, or the operations that can be performed on it."); 
		newWordDef("program", "a series of coded software instructions to control the operation of a computer or other machine"); 
		//display tree with new words and definitions added
		displayBinaryTree("", dictionary.root, false);
		//display first word in tree
		StdOut.println("\nFirst word: " + dictionary.min());
		//display last word in tree
        StdOut.println("Last word: " + dictionary.max());
		//display tree in order of when data is entered
        StdOut.println("\nPre Ordered List:");
        displayPreOrder();
        //display tree in alphabetical order
        StdOut.println("\nIn Ordered List:");
        displayInOrder();
        //display tree in reverser order
        StdOut.println("\nPrint reverse Order:");
        displayPostOrder(dictionary.root);
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time + " seconds.\n");
 		
 		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch(); 
 		StdOut.println("Asad Zaheer Test 2\n");
 		//display tree
 		StdOut.println("Print Binary Tree");
		displayBinaryTree("", dictionary.root, false);
		//find word and display word and definition
		StdOut.println("\nDefinitions:");
		getDef("declaration");
		getDef("binary search");
		getDef("cycle");
		getDef("operators");
		//new or updated definitions
		StdOut.println("\nNew/Updated Definitions:");
		newWordDef("call", "cry out (a word or words)");
		newWordDef("return", "come or go back to a place or person."); 
		newWordDef("request", "an act of asking politely or formally for something."); 
		newWordDef("example", "a thing characteristic of its kind or illustrating a general rule."); 
		//display tree with new words and definitions added
		displayBinaryTree("", dictionary.root, false);
		//display first word in tree
		StdOut.println("\nFirst word: " + dictionary.min());
		//display last word in tree
        StdOut.println("Last word: " + dictionary.max());
		//display tree in order of when data is entered
        StdOut.println("\nPre Ordered List:");
        displayPreOrder();
        //display tree in alphabetical order
        StdOut.println("\nIn Ordered List:");
        displayInOrder();
        //display tree in reverser order
        StdOut.println("\nPrint reverse Order:");
        displayPostOrder(dictionary.root);
		double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("\nExecution time " + time2 + " seconds.\n");
 		
 		//start stop watch for second test
 		Stopwatch timer3 = new Stopwatch(); 
 		StdOut.println("Asad Zaheer Test 3\n");
 		//display tree
 		StdOut.println("Print Binary Tree");
		displayBinaryTree("", dictionary.root, false);
		//find word and display word and definition
		StdOut.println("\nDefinitions:");
		getDef("declaration");
		getDef("binary search");
		getDef("cycle");
		getDef("operators");
		//new or updated definitions
		StdOut.println("\nNew/Updated Definitions:");
		newWordDef("cycle", "a series of events that are regularly repeated in the same order.");
		newWordDef("strings", "material consisting of threads of cotton, hemp, or other material twisted together to form a thin length."); 
		newWordDef("trace", "find or discover by investigation."); 
		newWordDef("variable", "not consistent or having a fixed pattern; liable to change."); 
		//display tree with new words and definitions added
		displayBinaryTree("", dictionary.root, false);
		//display first word in tree
		StdOut.println("\nFirst word: " + dictionary.min());
		//display last word in tree
        StdOut.println("Last word: " + dictionary.max());
		//display tree in order of when data is entered
        StdOut.println("\nPre Ordered List:");
        displayPreOrder();
        //display tree in alphabetical order
        StdOut.println("\nIn Ordered List:");
        displayInOrder();
        //display tree in reverser order
        StdOut.println("\nPrint reverse Order:");
        displayPostOrder(dictionary.root);
		double time3 = timer3.elapsedTime();
 		//display the execution time first test
 		StdOut.println("\nExecution time " + time3 + " seconds.\n");
 		
	}
	private static Scanner scan = new Scanner(System.in);
	private static BST<String, String> dictionary = new BST<String, String>();
	/*
	 * display binary tree
	 * 
	 * @param pre. Prefix
	 * @param node. Node of tree
	 * @param left. check if left node exists
	 * 
	 * @return none
	 */
	public static void displayBinaryTree(String pre, BST<String, String>.Node node, boolean left) {
		//if node exists
	    if (node != null) {
	    	//add space for subtree if on the right
	    	displayBinaryTree(pre + "     ", node.right, false);
	        System.out.println (pre + ("--> ") + node.key);
	        //add space for subtree if on the left
	        displayBinaryTree(pre + "     ", node.left, true);
	    }
	}
	/*
	 * get definition of word
	 * 
	 * @param word. a word from main
	 * 
	 * @return none
	 */
	public static void getDef(String word) {
        StdOut.println(word + " - " + dictionary.get(word));
	}
	/*
	 * add or update a word
	 * 
	 * @param word. a word from main
	 * @param def. definition of word from main
	 * 
	 * @return none
	 */
	public static void newWordDef(String word, String def) {   
		//add to tree
		dictionary.put(word, def);
		//get definition for said word
		getDef(word);
	}
	/*
	 * display dictionary from when the table was created
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public static void displayPreOrder() {
        //display each word and definition
        for (String s : dictionary.levelOrder())
            StdOut.println(s + " " + dictionary.get(s));
	}
	/*
	 * display dictionary in alphabetical order
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public static void displayInOrder() {
        //display dictionary in order
        for (String s : dictionary.keys())
            StdOut.println(s + " - " + dictionary.get(s));
	}
	/*
	 * display tree if reverse order of when data was enter
	 * 
	 * @param node. Node of tree
	 * 
	 * @return none
	 */
	public static void displayPostOrder(BST<String, String>.Node node) { 
        int height = height(node); 
        for (int x = height; x >= 1; x--) { 
        	level(node, x); 
        } 
    } 
	/*
	 * calculate height of tree
	 * 
	 * @param node. Node of tree
	 * 
	 * @return
	 */
	public static int height(BST<String, String>.Node node) { 	// Compute the "height" of a tree -- the number of nodes along the longest path from the root node down to the farthest leaf node
        int height;
		if (node == null) {
            return 0; 
        }
        //calculate height of subtree
        else { 
            int lh = height(node.left); 
            int rh = height(node.right); 
            if (lh > rh) {
            	height = (lh + 1); 
                return height;
            }
            else {
            	height = (rh + 1);
                return height;
            }
        } 
    } 	
	/*
	 * display each word
	 * 
	 * @param node. Node of tree
	 * @param level. location of tree
	 * 
	 * @return none
	 */
	public static void level(BST<String, String>.Node node, int level) { 	
        if (node == null) {
            return; 
        }
        //display word if location is the same
        if (level == 1) {
            StdOut.print(" - " + node.key + " \n"); 
        }
        else if (level > 1) { 
        	level(node.left, level - 1); 
        	level(node.right, level - 1); 
        } 
    } 
	
	
	public Node root;             

    public class Node 
    {
    	public final Key key;      
    	public Value val;           
    	public Node left, right;  
    	public int size;           

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    
	public Node findNode(Key key) {
		return findNode(root, key);
	}
	    
	public Node findNode(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return findNode(x.left, key);
		else if (cmp > 0) return findNode(x.right, key);
		else			  return x;
	} 

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    public int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) 
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else			  return x.val;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }

    public Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    /**
     * Removes the smallest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    public Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the largest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    public Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key);
        assert check();
    }

    public Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 


    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    } 

    public Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    } 

    public Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    public Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 

    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    public Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    } 

    /**
     * Return the kth smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the kth smallest key in the symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>N</em> &minus; 1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    public Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    // Number of keys in the subtree less than key.
    public int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys() {
        return rangeSearch(min(), max());
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @return all keys in the sybol table between {@code lo} 
     *         (inclusive) and {@code hi} (exclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> rangeSearch(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    public void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

    /**
     * Returns the number of keys in the symbol table in the given range.
     *
     * @return the number of keys in the sybol table between {@code lo} 
     *         (inclusive) and {@code hi} (exclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public int rangeCount(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }

    /**
     * Returns the height of the BST (for debugging).
     *
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return height(root);
    }
    public int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     * Returns the keys in the BST in level order (for debugging).
     *
     * @return the keys in the BST in level order traversal
     */
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

  /*************************************************************************
    *  Check integrity of BST data structure.
    ***************************************************************************/
    public boolean check() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    public boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    public boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 

    // are the size fields correct?
    public boolean isSizeConsistent() { return isSizeConsistent(root); }
    public boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    } 

    // check that ranks are consistent
    public boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }


    /**
     * Unit tests the {@code BST} data type.
     */
}

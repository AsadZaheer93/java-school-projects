/*
 * Program Name: FirstTenLetters.java
 * @author Asad Zaheer
 * @date 15 March 2020
 * 
 * Step 1. (0.5 points) Create an unordered linked list containing the first 10 letters 
 * in your name as keys (first name followed by the last name, not necessary distinct, 
 * add a few letters at the end if your name is shorter, consider only the first 10 
 * letters). My name: M I H A I B O I C U. The associated value for each letter will be 
 * a text like: "first letter", "second letter" to "tenth letter". Trace the PUT method 
 * in the textbook to create the list, showing only the call made, and how the list 
 * will look after the call (not all the internal computations). Either use a graphical 
 * model or a text model, like below:
 * -Node first = null;
 * -put ("M", "first letter")
 * -Node first = {key="M", val="first letter", next=null}
 * -put ("I", second letter")
 * -Node first = {key="I", val="second letter", next={key="M", val="first letter", next=null}}
 * 
 * Step 2: (0.5 points) Trace how search will work for searching a key with your seventh 
 * letter in your name. Trace the local variable x. Start with the result of the previous 
 * step. Show your first value before the call. Present the trace as a table or as a text 
 * like below:
 * -The list will be: U C O B A H I M. I search for O. 
 * -Node first = {key="U", val="tenth letter", next={key="C", val="ninth letter", 
 * 	next={key="O", val="seventh letter", next={key="B", val="sixth letter", 
 * 	next={key="A", val="fourth letter", next={key="H", val="third letter", 
 * 	next={key="I", val="eighth letter", next={key="M", val="first letter", next=null}}}}}}}}
 * -get("O") key="O"
 * -x={key="U", val="tenth letter", next={key="C", val="ninth letter", next=...}},
 * -x not null, continue the for loop
 * -x.key = "U" not equal with "O"
 * -x = x.next ={key="C", val="ninth letter", next={key="O", val="seventh letter", next=...}}}
 * -x not null, continue the for loop
 * -x.key = "C" not equal with "O"
 * =x = x.next ={key="O", val="seventh letter", next={key="B", val="sixth letter", next=...}}
 * -not null, continue the for loop
 * -x.key = "O" equal with "O"
 * -return x.val = "seventh letter"
 * 
 * Step 3: (0.5 points) Trace how search will work for searching a key that is not in 
 * your name (e.g. "D" in my case). Trace the local variable x. Start with the result 
 * of the previous step. Show your first value before the call. Present the trace as 
 * a table or as a text like above in step 2.
 * 
 * This program will build a table and then output the trace of the put method.
 * Then it will search for the seventh letter in the name and compare it with the other
 * table items. It will output whether or not the values are keys are the same.
 * Then it will search for a letter that is not in the name and output whether or not
 * it is equal to it.
 */
package W6_ZAHEER_ASAD;

import java.util.*;

public class FirstTenLetters<Key extends Comparable<Key>, Value> {
	 public static void main(String[] args) {
		 //start stop watch for first test
		 Stopwatch timer = new Stopwatch();
		 FirstTenLetters<String, String> asad = new FirstTenLetters<String, String>();
		 //build first table
    	 StdOut.println("Asad Zaheer Test 1");
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
         StdOut.println("Table:");
         asad.display(); 
         StdOut.println();
         StdOut.println("This table will be A S A D Z A H E E R serach for H for seventh position.");
         //output values equal to seventh position
         StdOut.println("Value: " + asad.get("H"));
         StdOut.println();
         StdOut.println("Searching for the letter Q");
         //output values equal to Q
         StdOut.println("Value: " + asad.get("Q")); 
         double time = timer.elapsedTime();
         //display the execution time first test
         StdOut.println("\nExecution time " + time + " seconds.\n");
         
         //start stop watch for second test
         Stopwatch timer2 = new Stopwatch();
		 FirstTenLetters<String, String> ateeb = new FirstTenLetters<String, String>();
		 //build second table
    	 StdOut.println("Asad Zaheer Test 2");
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
         StdOut.println("Table:");
         ateeb.display(); 
         StdOut.println();
         StdOut.println("This table will be A T E E B M A M I R serach for A for seventh position.");
         //output values equal to seventh position
         StdOut.println("Value: " + ateeb.get("A"));
         StdOut.println();
         StdOut.println("Searching for the letter Q");
         //output values equal to Q
         StdOut.println("Value: " + ateeb.get("Q")); 
         double time2 = timer2.elapsedTime();
         //display the execution time first test
         StdOut.println("\nExecution time " + time2 + " seconds.\n");
         
         //start stop watch for second test
         Stopwatch timer3 = new Stopwatch();
		 FirstTenLetters<String, String> asik = new FirstTenLetters<String, String>();
		 //build third table
    	 StdOut.println("Asad Zaheer Test 3");
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
    	 //output current table	
         StdOut.println("Table:");
         asad.display(); 
         StdOut.println();
         StdOut.println("This table will be A S I K R E T H W A serach for T for seventh position.");
         //output values equal to seventh position
         StdOut.println("Value: " +asik.get("T"));
         StdOut.println();
         StdOut.println("Searching for the letter Q");
         //output values equal to Q
         StdOut.println("Value: " +asik.get("Q")); 
         double time3 = timer3.elapsedTime();
         //display the execution time first test
         StdOut.println("\nExecution time " + time3 + " seconds.\n");
    }
	//first node in the linked list
	private Node first; 
	//linked-list node
	private class Node { 
		Key key;
	    Value val;
	    Node next;
	    public Node(Key key, Value val, Node next) {    
	    	this.key = key;
	    	this.val = val;
	    	this.next = next;
	    }
	}
	/*
	 * value paired with key (null if key is absent)
	 * 
	 * @param key. Location of valued pair
	 * 
	 * @return val. Value of key pair
	 */
	public Value get(Key key) { 
		StdOut.println("get (" + key + ")");
		//Search for key, return associated value.
		for (Node x = first; x != null; x = x.next){
			StdOut.println(key + " not equal with " +x.key);
			if (key.equals(x.key)) {
				//search hit
				StdOut.println(key + " equal with " +x.key);
				return x.val; 
			}
		} 
		//search miss
		return null;  
	}   
	/*
	 * put key-value pair into the table (remove key from table if value is null)
	 * 
	 * @param key. Location of valued pair
	 * @param val. Value of key pair
	 * 
	 * @return none
	 */
	public void put(Key key, Value val) { 
		//Search for key. Update value if found; grow table if new.
		StdOut.println("put (" + key + ", " + val + ")");
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) { 
				//Search hit: update val.
				x.val = val; 
				displayNode(); 
				return; 
			} 
		}
		//Search miss: add new node.
		first = new Node(key, val, first); 
	    displayNode();
	}
	/*
	 * Output keys, values and next values/keys
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public void displayNode(){ 
		for (Node x = first; x != null; x = x.next) {
			if (x.next==null) {
	            break;
			}
			StdOut.println("(" + x.key + ", " + x.val +") next ("+ x.next.key +", "+ x.next.val +")");
		}
		StdOut.println();
	}   	
	/*
	 * Output keys and values
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public void display(){ 
		for (Node x = first; x != null; x = x.next) {
			StdOut.println("(" + x.key + ", " + x.val +")");
		}
		StdOut.println();
	}	    
}

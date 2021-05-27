/*
 * AIT 512-001
 * Program Name: Deque.java
 * @author Asad Zaheer
 * @date 28 January 2020
 * 
 * 1.3.33 Deque. A double-ended queue or deque (pronounced “deck”) 
 * is like a stack or a queue but supports adding and removing items 
 * at both ends. A deque stores a collection of items and supports 
 * the following API: Write a class Deque that uses a doubly-linked 
 * list to implement this API and a class ResizingArrayDeque that 
 * uses a resizing array. 
 * 
 * This will give the ability for a user to add values into a stack
 * from either the top or bottom of the stack. Once all values have 
 * been added this program will output the stack in the order that
 * it has been added.
 */
package e2_deque;

import java.util.*;

public class Deque<Value> implements Iterable<Value>{
	public static void main(String[] args) {  
		//start of time calculation
		long start = System.currentTimeMillis();
	    Deque<String> deque = new Deque<String>();
	    System.out.println("Asad Zaheer Test 1");
	    System.out.println("Asad Zaheer Test 2");
	    System.out.println("Asad Zaheer Test 3");
	    System.out.println("Asad Zaheer Test 4");
	    System.out.println("Asad Zaheer Test 5");
	    //end of time calculation
      	long end = System.currentTimeMillis();
      	//result of execution time
      	System.out.println("\nExecution speed "+ (end - start)+" ms");
	}
	private Node first; 
    private Node last;  
    private int N;      
    private class Node {  
    	Value value;
    	Node next; }
    /*
     * This will check to see if the stack is empty
     * 
     * @param none
     * 
     * @return true if the stack is empty; false if
     * the stack is not empty
     */
    public boolean isEmpty() {
    	if (N == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    /*
     * This will grab the current size of the bag
     * 
     * @param none
     * 
     * @return currentSize. the size of the bag
     */
    public int getSize() {
        return N;
    }
    /*
     * This will remove a value from the stack
     * 
     * @param value that will be added at the end of the stack
     * 
     * @return none
     */
    public void enqueue(Value value) {
    	
    }
    /*
     * Remove a value from the beginning of the stack
     * 
     * @param none
     * 
     * @return value. the first value in the stack
     */
    public Value dequeue() {  
    	Value value = first.value;
    	return value;
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Value> iterator() {  
    	return new ListIterator();  
    }
    
    private class ListIterator implements Iterator<Value> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Value next() {
			// TODO Auto-generated method stub
			return null;
		}
        
    }
}

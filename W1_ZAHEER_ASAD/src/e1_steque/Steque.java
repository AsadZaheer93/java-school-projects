/*
 * AIT 512-001
 * Program Name: Steque.java
 * @author Asad Zaheer
 * @date 27 January 2020
 * 
 * 1.3.32 Steque. A stack-ended queue or steque is a data type that 
 * supports push, pop, and enqueue. Articulate an API for this ADT. 
 * Develop a linked-list-based implementation.
 * 
 * This program will demonstrate how to use stack queue
 * where you can add and remove a single value to the stack.
 * At the end of the program it will display all values that are
 * in the stack in the order that they have been added in.
 * 
 * 
 */
package e1_steque;

import java.util.*;

public class Steque<Value> implements Iterable<Value> {
	public static void main(String[] args) {
		//start of time calculation
		long start = System.currentTimeMillis();
		//create a new stack
        Steque<Integer> steque = new Steque<>();
        //add and remove values from the stack
        steque.push(4);
        steque.push(5);
        steque.pop();
        steque.enqueue(98);
        steque.enqueue(63);
        //output all values from the stack
        StdOut.println("Asad Zaheer: Test set 1");
        StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		//add and remove values from the stack
		steque.push(4);
        steque.push(7);
        steque.pop();
        steque.push(3);
        steque.enqueue(912);
        steque.enqueue(33);
        //output all values from the stack
        StdOut.println("\nAsad Zaheer: Test set 2");
        StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		//add and remove values from the stack
		steque.push(6);
        steque.push(7);
        steque.push(12);
        steque.pop();
        steque.push(3);
        steque.push(56);
        steque.push(99);
        steque.enqueue(912);
        steque.enqueue(33);
        steque.enqueue(43);
        steque.enqueue(0);
        //output all values from the stack
        StdOut.println("\nAsad Zaheer: Test set 3");
        StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		//add and remove values from the stack
		steque.push(69);
        steque.push(22);
        steque.pop();
        steque.push(3);
        steque.push(44);
        steque.push(99);
        steque.enqueue(200);
        steque.enqueue(3);
        steque.enqueue(1);
        //output all values from the stack
        StdOut.println("\nAsad Zaheer: Test set 4");
        StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		//add and remove values from the stack
		steque.push(1);
        steque.pop();
        steque.push(2);
        steque.enqueue(3);
        //output all values from the stack
        StdOut.println("\nAsad Zaheer: Test set 5");
        StdOut.println(steque.pop());
		StdOut.println(steque.pop());
		//end of time calculation
		long end = System.currentTimeMillis();
		//result of execution time
		System.out.println("\nExecution speed "+ (end - start)+" ms");
    }
	/* default constructor for a node
	 * 
	 * @param none
	 * 
	 * @return node object
	 */
	private class Node {
		//default values created for constructor
		Value value;
        Node before;
        Node after;
    }
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Value> iterator() {
        return new StequeIterator();
    }
	//Initialize node pointers and position
    private Node start;
    private Node end;
    private int currentSize;
    /*
     * This will check to see if the stack is empty
     * 
     * @param none
     * 
     * @return true if the stack is empty; false if
     * the stack is not empty
     */
    public boolean isEmpty() {
    	if (currentSize == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    /*
     * This will add a value to the stack
     * 
     * @param value. A value grabbed from main.
     * 
     * @return none
     */
    public void push(Value value) {
    	//temporary node create to change pointers
        Node oldStart = start;
        //change the start of the pointer to the new one
        start = new Node();
        start.value = value;
        start.after = oldStart;
        //check to see which pointer will point to the end of the stack
        if (oldStart != null) {
        	oldStart.before = start;
        } else {
        	end = start;
        }
        //increase the size of the stack
        currentSize++;
    }
    /*
     * This will remove a value from the stack
     * 
     * @param none
     * 
     * @return value that will be removed from the stack
     */
    public Value pop() {
    	//error message for when the stack is empty
        if (isEmpty()) {
            throw new RuntimeException("Error! Stack is Empty");
        }
        //initialize start of the stack
        Value value = start.value;
        start = start.after;
        //check to see where the value will be removed
        if (start != null) {
        	start.before = null;
        } 
        else {
        	start = null;
        }
        //decrease size of stack
        currentSize--;
        return value;
    }
    /*
     * This will remove a value from the stack
     * 
     * @param value that will be added at the end of the stack
     * 
     * @return none
     */
    public void enqueue(Value value) {
    	//temporary node create to change pointers
        Node oldEnd = end;
        //change the end of the pointer to the new one
        end = new Node();
        end.value = value;
        end.before = oldEnd;
        //check to see which pointer will point to the start of the stack
        if (oldEnd == null) {
        	start = end;
        } 
        else {
        	oldEnd.after = end;
        }
        //increase size of stack
        currentSize++;
    }
    /*
     * 
     */
    private class StequeIterator implements Iterator<Value>{
    	//initialize position to the beginning of the stack
        Node currentPosition = start;
        int i = 0;
        //grab the next value in the stack
        @Override
        public boolean hasNext() {
        	if (i < currentSize) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        //increment to the next stack
        @Override
        public Value next() {
        	Value value = currentPosition.value;
        	currentPosition = currentPosition.after;
            i++;
            return value;
        }
    }
}

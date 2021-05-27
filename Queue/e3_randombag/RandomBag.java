/*
 * AIT 512-001
 * Program Name: RandomBag.java
 * @author Asad Zaheer
 * @date 27 January 2020
 * 
 * 1.3.34 Random bag. A random bag stores a collection of items and 
 * supports the following API: Write a class RandomBag that implements 
 * this API. Note that this API is the same as for Bag, except for the 
 * adjective random, which indicates that the iteration should provide 
 * the items in random order (all N ! permutations equally likely, for 
 * each iterator). Hint : Put the items in an array and randomize their 
 * order in the iterator’s constructor. 
 * 
 * This program will demonstrate how to add values into a stack
 * and then randomize the order of it and output the results.
 * 5 tests are conducted within main and this should output 5 different
 * results.
 * 
 */
package e3_randombag;

import java.util.*;
import e3_randombag.StdOut;

public class RandomBag<Value> implements Iterable<Value>{
	public static void main(String[] args) {
		//start of time calculation
		long start = System.currentTimeMillis();
		//create bag
        RandomBag<Integer> bag = new RandomBag<>();
        //add values into the bag
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        //output values after randomization
        StdOut.print("Asad Zaheer: Below are random values for Test 1\n");
        for (int value : bag) {	
        	StdOut.println(value);	
        }
        //output values after randomization
        StdOut.print("Asad Zaheer: Below are random values for Test 2\n");
        for (int value : bag) {	
        	StdOut.println(value);	
        }
        //output values after randomization
        StdOut.print("Asad Zaheer: Below are random values for Test 3\n");
        for (int value : bag) {	
        	StdOut.println(value);	
        }
        //output values after randomization
        StdOut.print("Asad Zaheer: Below are random values for Test 4\n");
        for (int value : bag) {	
        	StdOut.println(value);	
        }
        //output values after randomization
        StdOut.print("Asad Zaheer: Below are random values for Test 5\n");
        for (int value : bag) {	
        	StdOut.println(value);	
        }
        //end of time calculation
      	long end = System.currentTimeMillis();
      	//result of execution time
      	System.out.println("\nExecution speed "+ (end - start)+" ms");
    }
	//initialize the bag and the size of it
	private Value[] bag;
    private int currentSize;
    /*
     * default constructor for bag creation
     */
    @SuppressWarnings("unchecked")
    public RandomBag() {
    	bag = (Value[]) new Object[1];
        currentSize = 0;
    }
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
     * This will grab the current size of the bag
     * 
     * @param none
     * 
     * @return currentSize. the size of the bag
     */
    public int getCurrentSize() {
        return currentSize;
    }
    /*
     * this will add a value to the stack
     * 
     * @param value. a value grabbed from main
     * 
     * @return none
     */
    public void add(Value value) {
        if (getCurrentSize() == bag.length) {
        	newBagSize(bag.length * 2);
        }
        bag[getCurrentSize() ] = value;
        currentSize++;
    }
    /*
     * This will change the size of the bag based upon
     * 
     * @param the size of the current bag
     * 
     * @return none
     */
    @SuppressWarnings("unchecked")
    private void newBagSize(int size) {
    	//initialize and create a new bag size
    	Value[] temporary = (Value[]) new Object[size];
    	//copy the contents of the bag to the new bag
        for(int i = 0; i < getCurrentSize(); i++) {
        	temporary[i] = bag[i];
        }
        bag = temporary;
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Value> iterator() {
        return new RandomBagIterator();
    }
    /*
     * This will copy the contents of the current bag into a new
     * bag and then it will be randomized in a different method.
     * 
     * @param iterator
     * 
     * @return bag
     */
    @SuppressWarnings("unchecked")
    private class RandomBagIterator implements Iterator<Value> {
    	//initialize array and position
        int i;
        Value[] copy;
        public RandomBagIterator() {
        	//start from beginning of stack
            i = 0;
            copy = (Value[]) new Object[currentSize];
            //copy the bag into a new bag
            for(int x = 0; x < currentSize; x++) {
            	copy[x] = bag[x];
            }
            //call method to randomize the array
            randomize();
        }
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
        	if (i < getCurrentSize()) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        @Override
        public Value next() {
        	Value value = copy[i];
            i++;
            return value;
        }
        /*
         * This will reorder the stack in random order
         * 
         * @param none
         * 
         * @return none
         */
        private void randomize() {
            for(int x = 0; x < currentSize; x++) {
            	//randomize the bag
                int i = StdRandom.uniform(0, currentSize - 1);
                //change the values to the array
                Value temporary = copy[x];
                copy[x] = copy[i];
                copy[i] = temporary;
            }
        }
    }
}

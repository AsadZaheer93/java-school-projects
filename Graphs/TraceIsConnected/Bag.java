/******************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A generic bag or multiset, implemented using a singly linked list.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Bag < tobe.txt
 *  size of bag = 14
 *  is
 *  -
 *  -
 *  -
 *  that
 *  -
 *  -
 *  be
 *  -
 *  to
 *  not
 *  or
 *  be
 *  to
 *
 ******************************************************************************/

package TraceIsConnected;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The {@code Bag} class represents a bag (or multiset) of 
 *  generic items. It supports insertion and iterating over the 
 *  items in arbitrary order.
 *  <p>
 *  This implementation uses a singly linked list with a static nested class Node.
 *  See {@link LinkedBag} for the version from the
 *  textbook that uses a non-static nested class.
 *  See {@link ResizingArrayBag} for a version that uses a resizing array.
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations
 *  take constant time. Iteration takes time proportional to the number of items.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this bag
 */
public class Bag<Item> implements Iterable<Item> {
	private Item[] contents;  
	private int N;
	
	
	/**
	 * creates a new empty Bag.
	 */
	public Bag() {
		contents = (Item[]) new Object[1];
		N = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void add(Item item) {
		if (item == null)
			throw new NullPointerException("You cannot fool us with null insertion :)");
		if (N == contents.length) 
			resize(contents.length * 2);
		contents[N++] = item;
	}
	
	public void remove(Item item) {
		int j = 0;
		for(int i = 0; i < N; i++)
		{
			if(item.equals(contents[i]))
			{
				
			}
			else
			{
				contents[j] = contents[i];
				j ++ ;
			}
		}
		N = j;
	}

	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int size) {
		Item[] items = (Item[]) new Object[size];
		for (int i = 0; i < N; i++) {
			items[i] = contents[i];
		}
		contents = items;
	}
	
	
	private class BagIterator implements Iterator<Item> {

		private int current;
		
		public BagIterator() {
			current = 0;
		}
		
		public boolean hasNext() {
			return current != N;
		}

		public Item next() {
			return contents[current++]; 
		}

		public void remove() {
			throw new UnsupportedOperationException("Boo! Operation not supported :(");
		}
		
	}

}

/******************************************************************************
 *  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
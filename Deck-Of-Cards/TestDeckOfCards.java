/*
 * Program Name: TestDeckOfCards.java
 * @author Asad Zaheer
 * @date 10 February 2020
 * 
 * Exercise 3 Deck of cards for 2.1.13 - page 265 (1 points): Create 
 * a class named DeckOfCards that will represent a deck of cards, 
 * represented as a fixed size array of cards. Create the following methods:
	•	a constructor with no parameters that will create a deck of cards sorted 
		in the following order (2 diamond, 2 clubs, 2 hearts, 2 spades, 3 diamond,
	 	...); - This is not in the sorted order by the Comparable.
	•	getCard( position) where position is 0 for the top of the deck and a 
		maximum size for the bottom, return a card
	•	shuffle(number of exchanges) - shuffle the deck following the algorithm, 
		generate randomly two indexes for two cards, exchange the two cards in 
		the deck, repeat the process for the number of exchanges times
	•	toString()
	•	print()
	•	All the sorting methods will sort based on the comparable element 
		(suite first, then rank)
	•	selectionSort() - sort the deck using selection sort method
	•	insertionSort() - sort the deck using insertion sort method
	•	shellSort() - sort the deck using shell sort method
 * Create a test class that will perform 5 relevant tests, for each of the 
 * methods implemented. 
 * 
 * This program will create a new deck of cards and the user
 * will be asked from what position do they wish to grab a
 * card. It will then sort the deck based on 3 algorithms and
 * output the final result.
 */
package W3_ZAHEER_ASAD;

import java.util.*;

public class TestDeckOfCards {
	public static void main(String[] args){
		//start stop watch
		Stopwatch timer = new Stopwatch();
		//Initialize deck
		final int DECK = 52;
		int numOfExchanges;
		int position;
		Card deck[] = new Card[DECK];
		Scanner input = new Scanner(System.in);
		DeckOfCards.createDeck(deck);
		//ask user where they wish to grab a card from the deck
		StdOut.println("Asad Zaheer\nDeck of Cards\nWhat card position would you like to get?");
		position = input.nextInt();
		StdOut.println(DeckOfCards.getCard(deck, position));
		//ask user how many times they wish to randomize the deck
		StdOut.println("How many times do you want to shuffle the deck?");
		numOfExchanges = input.nextInt();
		DeckOfCards.shuffle(deck, numOfExchanges);
		//sort deck using selection sort
		StdOut.println("Selection Sort:");
		DeckOfCards.selectionSort(deck);
		//sort deck using insertion sort
		DeckOfCards.shuffle(deck, numOfExchanges);
		StdOut.println("Insertion Sort:");
		DeckOfCards.insertionSort(deck);
		//sort deck using shell sort
		DeckOfCards.shuffle(deck, numOfExchanges);
		StdOut.println("Shell Sort:");
		DeckOfCards.shellSort(deck);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
	}
}

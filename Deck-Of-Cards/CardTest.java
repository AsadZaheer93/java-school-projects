/*
 * Program Name: CardTest.java
 * @author Asad Zaheer
 * @date 8 February 2020
 * 
 * Exercise 2 Card - for Exercise 2.1.13 - page 265 (1 points): Create an immutable 
 * class named Card implementing the Comparable interface that will represent a card, 
 * have a suit: diamonds - lowest, clubs, hearts, spades - highest) and a rank 
 * ( 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A). The class must have a constructor 
 * provided with  a suit and rank, and the following methods: toString(), getSuit(), 
 * getRank(), print(). Create a static method that will randomly generate a card. 
 * Create a test class that will perform 5 relevant tests, for each of the methods 
 * implemented. A card is less than another either if the suite is lower or if 
 * they have the suite, then the rank is lower. 
 * 
 * This program will generate 2 random cards and then compare both cards.
 * The program will output both cards and notify the user which cards greater,
 * lesser or the same.
 */
package W3_ZAHEER_ASAD;

import java.util.*;

public class CardTest {
	public static void main(String args[]){
		//start stop watch
		Stopwatch timer = new Stopwatch();
		//initializing variables
		Card cards[] = new Card[2];
    	final int SIZE = 3;
    	int value;
    	System.out.println("Asad Zaheer\nGenerating 2 random cards");
    	//generate 2 random cards
		for (int x = 0; x < SIZE - 1; x++) {
			cards[x] = new Card (rank(), suit());
			StdOut.println(cards[x]);	
		}
		
		value = cards[0].compareTo(cards[1]);
		//check which card is greater, lesser or same
		if(value == 1) {
			//first card is greater than the second card
			StdOut.println(cards[0] + " is greater than " + cards[1]);
		}
		else if(value == -1) {
			//first card is lesser than the second card
			StdOut.println(cards[0] + " is less than " + cards[1]);
		}
		else {
			//both cards are the same
			StdOut.println(cards[0] + " and " + cards[1] + " are the same.");
		}
		double time = timer.elapsedTime();
		//display the execution time
		StdOut.println("\nExecution time " + time + " seconds.");
	}
	/*
	 * This will create a random ranked card
	 * 
	 * @param none
	 * 
	 * @return rank. The rank of a card
	 */
	public static int rank() {
		int rank = StdRandom.uniform(13) + 1;
		return rank;
	}
	/*
	 * This will create a random suit card
	 * 
	 * @param none
	 * 
	 * @return suit. The suit of a card
	 */
	public static int suit() {
		int suit = StdRandom.uniform(4);
		return suit;
	}
}

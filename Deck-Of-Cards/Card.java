/*
 * Program Name: Card.java
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
 * This program will create a new card object initiated by the 
 * CarTest.java file. This will store the card's rank and suit and also
 * compare between 2 card objects.
 */
package W3_ZAHEER_ASAD;

import java.util.*;

public class Card implements Comparable<Card>{
	//initialize input values
	private int rank;
	private int suit;
	//initialize cards rank and suit
	public static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};
	public static final String[] suits = {"DIAMOND", "CLUB", "HEART", "SPADE"};
	/*
	 * Card object is created
	 * 
	 * @param rank. The rank of a card
	 * @param suit. The suit of a card
	 * 
	 * @return none.
	 */
	Card(int rank, int suit){
		this.rank = rank;
		this.suit = suit;     
	}
	/*
	 * Get the current rank of the card
	 * 
	 * @param none
	 * 
	 * @return rank. The rank of the card
	 */
	int getRank(){
		return rank;
	}
	/*
	 * Get the current suit of the card
	 * 
	 * @param none
	 * 
	 * @return rank. The suit of the card
	 */
	int getSuit(){
		return suit;
	}
	/*
	 * Compare 2 different card objects
	 * 
	 * @param that. Rank and suit of card
	 * 
	 * @return -1, 0, 1. A value for comparison.
	 */
	public int compareTo(Card that) {
		//check if rank is lesser than
		if (this.rank < that.rank) {
            return -1;
		}
		//check if rank is greater than
		else if (this.rank > that.rank) {
            return 1;
		}
		//check if suit is lesser than
		if (this.suit < that.suit) {
            return -1;
		}
		//check if suit is greater than
		else if (this.suit > that.suit) {
            return 1;
		}
		return 0;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		//output the rank and suit of a card
	    return ranks[rank] + " of " + suits[suit];
	}
}

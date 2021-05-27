/* 
 * Program Name: TestDequeue.java
 * @author Asad Zaheer
 * @date 10 February 2020
 * 
 * Exercise 4: based on 2.1.14 Dequeue sort - page 265 (1 point): Explain 
 * the solution in a paragraph. Create the following methods in Deck of 
 * cards class, from exercise 3:
	•	exchangeTop() that exchanges the top cards in the deck
	•	moveTopToBottom() that moves the top card to the bottom of the 
		package
	•	dequeueSort() that implements your algorithm - be sure you call 
		only the above methods to sort and you can look only at the 
		values of the top two cards (Note: if you already submitted 
		with the method name sortFaceDown() there is no problem or 
		penalty)
 * Create a test class that will perform 5 relevant tests, for each of the methods implemented. 
 * 
 * This program will create a new deck of cards and the user
 * will be asked how many times they wish to shuffle the
 * deck of cards and will display the final order of cards
 * based on a dequeue sort.
 */
package W3_ZAHEER_ASAD;

import java.util.*;

public class TestDequeue {
	public static void main(String[] args){
		//start stop watch
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer");
		//Deck creation
		Card deck[] = new Card[52];
		Scanner input = new Scanner(System.in);
		DeckOfCards.createDeck(deck);
		//ask user how many times to randomize the deck
		StdOut.println("How many times would you like to shuffle?");
		int exchanges = input.nextInt();
		DeckOfCards.shuffle(deck, exchanges);
		StdOut.println();
		DeckOfCards.display(deck);
		StdOut.println("Dequeue Sort");
		//sort deck
		DeckOfCards.dequeueSort(deck);
		//output final results
		DeckOfCards.display(deck);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
	}
}

/*
 * Program Name: DeckOfCards.java
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
 * This program will create a new deck, randomize it, change its position
 * and sort based upon 4 different sorts.
 * 
 */
package W3_ZAHEER_ASAD;

public class DeckOfCards {
	//initialize deck of cards
	public Card deck[];
	/*
	 * Create a deck of cards object
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	public DeckOfCards() {
		Card[] deck = new Card[52];
	}   
	/*
	 * Create a new deck of cards
	 * 
	 * @param that.
	 * 
	 * @return none
	 */
	public static Card[] createDeck(Card[] that) { 
		//initialize index
		int i = 0;
		//create a deck of cards
		for (int rank = 1; rank <= 12; rank++) {
			for (int suit = 0 ; suit < 4; suit++) {
				//create a new card into array
	            that[i] = new Card(rank, suit);
	            //increase position
	            i++;
			}
		}
		return that;
	}
	/*
	 * Get a card position from user input
	 * 
	 * @param deck. The deck of cards created
	 * @param position. The position of the card
	 * 
	 * @return deck[position]. position of card in deck
	 */
	public static Card getCard(Card[] deck, int position) { 
		return deck[position];   
	}
	/*
	 * Randomize the deck of cards based upon how many
	 * times the user wishes to be randomized
	 * 
	 * @param deck. The deck of cards created
	 * @param exchange. Number of times the suer wishes to
	 * shuffle
	 * 
	 * @return none
	 */
	public static void shuffle(Card[] deck, int exchange) { 
		//Randomize the deck of cards a certain number of times
		for (int x = 0; x < exchange; x++){
			int i1=StdRandom.uniform(52);
			int i2=StdRandom.uniform(52);
			exch(deck, i1, i2);
	    }
	} 
	/*
	 * Change the positions of the deck of cards
	 * 
	 * @param deck. The deck of cards created
	 * @param pos1. Initial position
	 * @param pos2. New position
	 * 
	 * @return none
	 */
	private static void exch(Card[] deck, int pos1, int pos2) {
		//swap positions of cards in the deck
		Card swap = deck[pos1];
		deck[pos1] = deck[pos2];
		deck[pos2] = swap;
	}
	/*
	 * Swap the top card
	 * 
	 * @param deck. The deck of cards created
	 * 
	 * @return none
	 */
	public static void exchangeTop(Card deck[]) {
		exch(deck, 0, 1);
	}
	/*
	 * Switch top and bottom card
	 * 
	 * @param deck. The deck of cards created
	 * 
	 * @return none
	 */ 
	public static void moveToptoBottom(Card deck[]) { 
		//initialize top
		Card top = deck[0];
		for (int x = 0; x < 51; x++) { 
			deck[x]=deck[x + 1]; 
		}
		deck[51]= top;
	}
	/*
	 * Sort deck of cards
	 * 
	 * @param deck. The deck of cards created
	 * 
	 * @return none
	 */ 
	public static void dequeueSort(Card[] deck) {
		int n = 51;
		int k = 1;
		while(n > 0) {
			for (int i=0; i<n; i++) {
				if (deck[1].compareTo(deck[0]) > 1) {
					exchangeTop(deck);
				}
				//Move card to the top of the deck
				moveToptoBottom(deck);
			}
			for (int i=0; i<k; i++) {
				if(deck[1].compareTo(deck[0]) < 1) {
					exchangeTop(deck);
				}
				//Move card to the top of the deck
				moveToptoBottom(deck);
			}
			display(deck);
			n--;
			k++; 
		}
		//Move card to the top of the deck
		moveToptoBottom(deck); 
	}
	/*
	 * Sort array in using selection algorithm
	 * 
	 * @param array. Array from main
	 * 
	 * @return none
	 */
    public static void insertionSort(Card[] array) {  
		//initialize variables
		int size = array.length;
		//output array before sorted
		display(array);
		for (int x = 1; x < size; x++) { 
			int count = 0;
			for (int y = x; y > 0 && less(array[y], array[y - 1]); y--) {
				//switch element and increase count
				exch(array, y, y - 1);
				count++;
			}
			//output trace
			StdOut.print("I:   " + x + " min:  " + count + "   ");
			//output array sorted
			display(array);
		}
		//output final results
		display(array);
	}
    /*
	 * Sort array in using selection algorithm
	 * 
	 * @param array. Array from main
	 * 
	 * @return none
	 */
	public static void selectionSort(Card[] array) { 
		//initialize variables
		int size = array.length;
		StdOut.print("Asad Zaheer\nStart of tracing array with selection sort: ");
		//output array before sorted
		display(array);
		StdOut.println();
		for (int x = 0; x < size; x++) {  
			//minimum index
			int min = x;                
			for (int y = x + 1; y < size; y++) {
				if (less(array[y], array[min])) {
					//switch element
					min = y;
				}
			}
			//output trace
			StdOut.print("I:  " + x + " min:  " + min + "   ");
			//output array sorted
			display(array);
			exch(array, x, min);
		} 
		//output final results
		StdOut.println("End of trace result: ");
		display(array);
	}
    /*
	 * Sort array in using shell algorithm
	 * 
	 * @param array. Array from main
	 * 
	 * @return none
	 */
	public static void shellSort(Card[] array) {
		//initialize variables
		int size = array.length;
		int h = 1;
		StdOut.print("Asad Zaheer\nStart of tracing array with shell sort: ");
		//output array before sorted
		display(array);
		while (h < size/3) h = 3*h + 1; {
			while (h >= 1) {  
				int count = 0;
				for (int x = h; x < size; x++) { 
					for (int y = x; y >= h && less(array[y], array[y-h]); y -= h) {
						//switch element and increase count
						exch(array, y, y-h);
						count++;
					}
				}
				//output trace
				StdOut.print(h + "-sort     min: " + count + "    ");
				//output array sorted
				display(array);
				h = h/3; 
			}
		}
	}
    /*
	 * Output the array
	 * 
	 * @param array. Array created from main
	 * 
	 * @return none
	 */
    public static void display(Card[] array) {
		int size = array.length;
		for (int x = 0; x < size; x++) {
			//add spacing after each element
			StdOut.print(array[x] + " ");
		}
		StdOut.println();
	}
    /*
	 * Check which element is lesser than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * 
	 * @return boolean. If element lesser than
	 */
	private static boolean less(Card v, Card w) {  
		return v.compareTo(w) < 0;  
    }   
}

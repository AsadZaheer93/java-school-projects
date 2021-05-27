package GA8;
/*
 * Program Name: GA8.java
 * @author Asad Zaheer
 * @date 10 May 2020
 * 
 * Module 5.2 - Guided Assignment 8: Alphabet (0.5 points)
 * Read section: 
 * Alphabet  (page 741-742)
 * Implement and test
 * Modify TrieST class to accept an alphabet in the constructor
 * Follow textbook instructions
 * Update the test class for 3 different alphabets.
 */
public class GA8 {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 1\n");
		Alphabet alphabet1 = new Alphabet("alphabet");
		StdOut.println("Alphabet Input: alphabet");
		StdOut.println("toChar value of 'alphabet'");
		StdOut.println(alphabet1.toChar(1));
		StdOut.println("toIndex value of 'alphabet'");
		StdOut.println(alphabet1.toIndex("p".charAt(0)));
		StdOut.print();
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 2\n");
		Alphabet alphabet2 = new Alphabet("Asad");
		StdOut.println("Alphabet Input: Asad");
		StdOut.println("toChar value of 'Asad'");
		StdOut.println(alphabet2.toChar(2));
		StdOut.println("toIndex value of 'Asad'");
		StdOut.println(alphabet2.toIndex("s".charAt(0)));
		StdOut.print();
		double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 3\n");
		Alphabet alphabet3 = new Alphabet("Superman");
		StdOut.println("Alphabet Input: Superman");
		StdOut.println("toChar value of 'Superman'");
		StdOut.println(alphabet3.toChar(0));
		StdOut.println("toIndex value of 'Superman'");
		StdOut.println(alphabet3.toIndex("u".charAt(0)));
		StdOut.print();
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
	}
}

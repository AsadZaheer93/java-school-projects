package GA10;
/*
 * Program Name: GA10.java
 * @author Asad Zaheer
 * @date 10 May 2020
 * 
 * Module 5.2 - Guided Assignment 10: Internal one-way branching (0.5 points)
 * Read section: 
 * Properties of tries  (page 742-745)
 * Exercise 5.2.12
 * Implement and test
 * Duplicate TrieSTExternalOneWay (or TrieST) class and create TriesSTOneWay (containing both)
 * Implement external OneWayBranching as described in Exercise 5.2.12
 * Update the test class for 5 different tries.
 */
public class GA10 {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 1\n");
		TriesSTExternalOneWay<Value> tries1 = new TriesSTExternalOneWay<>();
		tries1.put("asad", new Value(1)); 
		tries1.put("ateeb", new Value(2));
		tries1.put("asik", new Value(2));
		StdOut.println("Input:");
		StdOut.println("asad");
		StdOut.println("ateeb");
		StdOut.println("asik");
		StdOut.println("Internal one-way branching:");
		tries1.print();
		StdOut.print("\n");
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");

 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 2\n");
		TriesSTExternalOneWay<Value> tries2 = new TriesSTExternalOneWay<>();
		tries2.put("virginia", new Value(1)); 
		tries2.put("maryland", new Value(2));
		tries2.put("florida", new Value(2));
		StdOut.println("Input:");
		StdOut.println("virginia");
		StdOut.println("maryland");
		StdOut.println("florida");
		StdOut.println("Internal one-way branching:");
		tries2.print();
		StdOut.print("\n");
		double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");

 		//start stop watch for third test
 		Stopwatch timer3 = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 3\n");
		TriesSTExternalOneWay<Value> tries3 = new TriesSTExternalOneWay<>();
		tries3.put("abc", new Value(1)); 
		tries3.put("aslen", new Value(2));
		tries3.put("obiehnerl", new Value(2));
		StdOut.println("Input:");
		StdOut.println("abc");
		StdOut.println("aslen");
		StdOut.println("obiehnerl");
		StdOut.println("Internal one-way branching:");
		tries3.print();
		StdOut.print("\n");
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");

 		//start stop watch for fourth test
 		Stopwatch timer4 = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 4\n");
		TriesSTExternalOneWay<Value> tries4 = new TriesSTExternalOneWay<>();
		tries4.put("superman", new Value(1)); 
		tries4.put("batman", new Value(2));
		tries4.put("wonderwoman", new Value(2));
		StdOut.println("Input:");
		StdOut.println("superman");
		StdOut.println("batman");
		StdOut.println("wonderwoman");
		StdOut.println("Internal one-way branching:");
		tries4.print();
		StdOut.print("\n");
		double time4 = timer4.elapsedTime();
 		//display the execution time fourth test
 		StdOut.println("Execution time " + time4 + " seconds.\n");

 		//start stop watch for fifth test
 		Stopwatch timer5 = new Stopwatch();
		//initialize trie
		StdOut.println("Asad Zaheer\n\nTest 5\n");
		TriesSTExternalOneWay<Value> tries5 = new TriesSTExternalOneWay<>();
		tries5.put("zaheer", new Value(1)); 
		tries5.put("amir", new Value(2));
		tries5.put("rethwan", new Value(2));
		StdOut.println("Input:");
		StdOut.println("zaheer");
		StdOut.println("amir");
		StdOut.println("rethwan");
		StdOut.println("Internal one-way branching:");
		tries5.print();
		StdOut.print("\n");
		double time5 = timer5.elapsedTime();
 		//display the execution time fifth test
 		StdOut.println("Execution time " + time5 + " seconds.\n");
	}
}

package GA4;
/*
 * Program Name: GA4.java
 * @author Asad Zaheer
 * @date 10 May 2020
 * 
 * Module 5.2 - Guided Assignment 4: Collecting keys (0.5 points)
 * Read Tries section: 
 * Collecting keys  (page 738)
 * CODE: Collecting the keys in a trie (page 738)
 * Implement and test
 * CODE: Collecting the keys in a trie in TrieST class (page 738)
 * Update the test class and test the method for 5 different tries.
 */
import java.util.*;

public class GA4 {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize trie
		TrieST<Value> trie1 = new TrieST<Value>();
		trie1.put("Node1", new Value(0));
		trie1.put("Node2", new Value(1));
		trie1.put("Node3", new Value(2));
		trie1.put("Node4", new Value(3));
		trie1.put("Node5", new Value(4));
		StdOut.println("Asad Zaheer\n\nTest 1\n");
		StdOut.println("Trie:");
		StdOut.println("Node1");
		StdOut.println("Node2");
		StdOut.println("Node3");
		StdOut.println("Node4");
		StdOut.println("Node5");
		StdOut.println("Collected keys in trie");
		Iterator<String> itr = trie1.keys().iterator();
		while(itr.hasNext()) {
			StdOut.println(itr.next());
		}
		StdOut.println();
		StdOut.println("Collected keys with prefix 'No' in trie:");
		Iterator<String> itr1 = trie1.keysWithPrefix("No").iterator();
		while(itr1.hasNext()) {
			StdOut.println(itr1.next());
		}
		StdOut.println();
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
		
 		//start stop watch for second test
 		Stopwatch timer2 = new Stopwatch();
		//initialize trie
		TrieST<Value> trie2 = new TrieST<Value>();
		trie2.put("TT1GXR5", new Value(0));
		trie2.put("IM1461F", new Value(1));
		trie2.put("CFXPFIY", new Value(2));
		trie2.put("MJI9VKV", new Value(3));
		trie2.put("Z1ETL4N", new Value(4));
		StdOut.println("Asad Zaheer\n\nTest 2\n");
		StdOut.println("Trie:");
		StdOut.println("TT1GXR5");
		StdOut.println("IM1461F");
		StdOut.println("CFXPFIY");
		StdOut.println("MJI9VKV");
		StdOut.println("Z1ETL4N");
		StdOut.println("Collected keys in trie");
		Iterator<String> itr2 = trie2.keys().iterator();
		while(itr2.hasNext()) {
			StdOut.println(itr2.next());
		}
		StdOut.println();
		StdOut.println("Collected keys with prefix 'MJ' in trie:");
		Iterator<String> itr3 = trie2.keysWithPrefix("MJ").iterator();
		while(itr3.hasNext()) {
			StdOut.println(itr3.next());
		}
		double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		//initialize trie
		TrieST<Value> trie3 = new TrieST<Value>();
		trie3.put("58Y998Y", new Value(0));
		trie3.put("7ER4L8F", new Value(1));
		trie3.put("H11A3FW", new Value(2));
		trie3.put("C178GU7", new Value(3));
		trie3.put("O25LTEM", new Value(4));
		StdOut.println("Asad Zaheer\n\nTest 3\n");
		StdOut.println("Trie:");
		StdOut.println("58Y998Y");
		StdOut.println("7ER4L8F");
		StdOut.println("CFXPFIY");
		StdOut.println("C178GU7");
		StdOut.println("O25LTEM");
		StdOut.println("Collected keys in trie");
		Iterator<String> itr4 = trie3.keys().iterator();
		while(itr4.hasNext()) {
			StdOut.println(itr4.next());
		}
		StdOut.println();
		StdOut.println("Collected keys with prefix 'E' in trie:");
		Iterator<String> itr5 = trie3.keysWithPrefix("E").iterator();
		while(itr5.hasNext()) {
			StdOut.println(itr5.next());
		}
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
		
		//start stop watch for fourth test
		Stopwatch timer4 = new Stopwatch();
		//initialize trie
		TrieST<Value> trie4 = new TrieST<Value>();
		trie4.put("SRWN1NN", new Value(0));
		trie4.put("T3VCCQE", new Value(1));
		trie4.put("G11G4N0", new Value(2));
		trie4.put("LCFIGVT", new Value(3));
		trie4.put("UVXPDVB", new Value(4));
		StdOut.println("Asad Zaheer\n\nTest 4\n");
		StdOut.println("Trie:");
		StdOut.println("SRWN1NN");
		StdOut.println("T3VCCQE");
		StdOut.println("G11G4N0");
		StdOut.println("LCFIGVT");
		StdOut.println("UVXPDVB");
		StdOut.println("Collected keys in trie");
		Iterator<String> itr6 = trie4.keys().iterator();
		while(itr6.hasNext()) {
			StdOut.println(itr6.next());
		}
		StdOut.println();
		StdOut.println("Collected keys with prefix '5' in trie:");
		Iterator<String> itr7 = trie4.keysWithPrefix("5").iterator();
		while(itr7.hasNext()) {
			StdOut.println(itr7.next());
		}
		double time4 = timer4.elapsedTime();
 		//display the execution time fourth test
 		StdOut.println("Execution time " + time4 + " seconds.\n");
		
		//start stop watch for fifth test
		Stopwatch timer5 = new Stopwatch();
		//initialize trie
		TrieST<Value> trie5 = new TrieST<Value>();
		trie5.put("SYQ6DCEH89", new Value(0));
		trie5.put("3RD6RR1RGV", new Value(1));
		trie5.put("MRFM3Z7RIV", new Value(2));
		trie5.put("1DEUMNPF4V", new Value(3));
		trie5.put("XBRN8PJZOL", new Value(4));
		StdOut.println("Asad Zaheer\n\nTest 5\n");
		StdOut.println("Trie:");
		StdOut.println("SYQ6DCEH89");
		StdOut.println("3RD6RR1RGV");
		StdOut.println("MRFM3Z7RIV");
		StdOut.println("1DEUMNPF4V");
		StdOut.println("XBRN8PJZOL");
		StdOut.println("Collected keys in trie");
		Iterator<String> itr8 = trie5.keys().iterator();
		while(itr8.hasNext()) {
			StdOut.println(itr8.next());
		}
		StdOut.println();
		StdOut.println("Collected keys with prefix 'q' in trie:");
		Iterator<String> itr9 = trie5.keysWithPrefix("q").iterator();
		while(itr9.hasNext()) {
			StdOut.println(itr9.next());
		}
		double time5 = timer5.elapsedTime();
 		//display the execution time fifth test
 		StdOut.println("Execution time " + time5 + " seconds.\n");
	}
}

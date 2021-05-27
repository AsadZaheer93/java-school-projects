/*
 * Program Name: MergeSortQueue.java
 * @author Asad Zaheer
 * @date 17 February 2020
 * 
 * 2.2.14 Merging sorted queues. Develop a static method that takes two 
 * queues of sorted items as arguments and returns a queue that results 
 * from merging the queues into sorted order.
 * 
 * This program will create 3 pairs sorted queues that will then be combined
 * based on each pair into one single queue. Each pair will be combined using
 * the merge sort algorithm.
 */
package W4_ZAHEER_ASAD;

import java.util.*;

public class MergeSortQueue implements Comparable<Comparable> {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize 2 sorted queues
		Queue<Comparable> queue1 = new Queue<Comparable>();
		Queue<Comparable> queue2 = new Queue<Comparable>();
		//add into first queue
		queue1.enqueue(1);
		queue1.enqueue(3);
		queue1.enqueue(5);
		queue1.enqueue(7);
		queue1.enqueue(9);
		//add into second queue
		queue2.enqueue(0);
		queue2.enqueue(2);
		queue2.enqueue(4);
		queue2.enqueue(6);
		queue2.enqueue(8);
		StdOut.println("Asad Zaheer\nTest 1\n");
        StdOut.println("Queue 1:");
        //output first queue
        display(queue1);
		StdOut.println();
		StdOut.println("Queue 2:");
		//output second queue
		display(queue2);
		StdOut.println();
		StdOut.println("Merge Sorted Queue Ouput: ");
		//merge both queues into one
		Queue mergedQueue1 = MergeSortQueue.merge(queue1, queue2);
		//output merged queue
		display(mergedQueue1);
        double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		//initialize 2 sorted queues
		Queue<Comparable> queue3 = new Queue<Comparable>();
		Queue<Comparable> queue4 = new Queue<Comparable>();
		//add into first queue
		queue3.enqueue(11);
		queue3.enqueue(13);
		queue3.enqueue(15);
		queue3.enqueue(17);
		queue3.enqueue(19);
		//add into second queue
		queue4.enqueue(10);
		queue4.enqueue(12);
		queue4.enqueue(14);
		queue4.enqueue(16);
		queue4.enqueue(18);
		StdOut.println("\nTest 2:\n");
        StdOut.println("Queue 1:");
        //output first queue
        display(queue3);
		StdOut.println();
		StdOut.println("Queue 2:");
		//output second queue
		display(queue4);
		StdOut.println();
		StdOut.println("Merge Sorted Queue Ouput: ");
		//merge both queues into one
		Queue mergedQueue2 = MergeSortQueue.merge(queue3, queue4);
		//output merged queue
		display(mergedQueue2);
        double time2 = timer2.elapsedTime();
		//display the execution time second test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		//initialize 2 sorted queues
		Queue<Comparable> queue5 = new Queue<Comparable>();
		Queue<Comparable> queue6 = new Queue<Comparable>();
		//add into first queue
		queue5.enqueue(21);
		queue5.enqueue(23);
		queue5.enqueue(25);
		queue5.enqueue(27);
		queue5.enqueue(29);
		//add into second queue
		queue6.enqueue(20);
		queue6.enqueue(22);
		queue6.enqueue(24);
		queue6.enqueue(26);
		queue6.enqueue(28);
		StdOut.println("\nTest 3:\n");
		//output first queue
        StdOut.println("Queue 1:");
        display(queue5);
		StdOut.println();
		StdOut.println("Queue 2:");
		//output second queue
		display(queue6);
		StdOut.println();
		StdOut.println("Merge Sorted Queue Ouput: ");
		//merge both queues into one
		Queue mergedQueue3 = MergeSortQueue.merge(queue5, queue6);
		//output merged queue
		display(mergedQueue3);
        double time3 = timer3.elapsedTime();
		//display the execution time third test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
	}
	/*
	 * Combine two sorted queues into one queue
	 * 
	 * @param queue1. First queue created from main
	 * @param queue2. Second queue created from main
	 * 
	 * @return queue. The combined queue of two queues
	 */
	public static Queue merge(Queue queue1, Queue queue2) {
		//initialize variables, queue and sizes
		Queue queue = new Queue(); 
		int size1 = queue1.size(); 
		int size2 = queue2.size(); 
		int i = 0; 
		int j = 0; 
		Comparable x;
		Comparable y;
		while (i < size1 || j < size2) {
			//elements exists in both queues
			if (i < size1 && j < size2) {
				//grab the last item from queue 1
				x = (Comparable) queue1.peek();
				//grab the last item from queue 2
				y = (Comparable) queue2.peek();
				//remove x from queue 1
				if (less(x,y)) { 
					queue1.dequeue();
					//add x to queue
					queue.enqueue(x);
					queue1.enqueue(x);
					i++; // increment
				}
				//remove y from Queue 2
				else {
					queue2.dequeue();
					//add y to queue
					queue.enqueue(y); 
					queue2.enqueue(y);
					j++; 
				}
			}
			//add to queue 1
			else if (i<size1 && j>=size2) {
				x=(Comparable) queue1.dequeue();
				queue1.enqueue(x);
				//add x to queue
				queue.enqueue(x); 
				i++; 
			}
		}
		return queue; // return new combined queue
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Comparable arg0) {
		return 0;   } 
	/*
	 * Check which element is lesser than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * 
	 * @return boolean. If element lesser than
	 */
	private static boolean less(Comparable v, Comparable w)   
	{  return v.compareTo(w) < 0;  }  
	/*
	 * Output the queue
	 * 
	 * @param queue. Queue created from main
	 * 
	 * @return none
	 */
	public static void display(Queue list) {
		StdOut.println("Size of queue: " + list.size() + "\nMerged Queue:");
		for (Object element : list) {
			StdOut.print(element + " ");
		}
		StdOut.println();
	}
}

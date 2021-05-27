/*
 * Program Name: LinkedListMergeSort.java
 * @author Asad Zaheer
 * @date 17 February 2020
 * 
 * Exercise 5: Creative Problem 2.2.17 Linked-list Merge Sort (1.5 point)
 * 2.2.17 Linked-list sort. Implement a natural mergesort for linked lists. 
 * (This is the method of choice for sorting linked lists because it uses 
 * no extra space and is guaranteed to be linearithmic.)
 * 
 * This program will create 3 sets of list nodes and within each set
 * will connect each node to one another. Afterwards this will sort 
 * each set using the merge sort algorithm for a linked list. This will
 * also call the LsitNode class to create a node and the LinkedListMergeSortDD
 * class to merge each node.
 */
package W4_ZAHEER_ASAD;

import java.util.*;

public class LinkedListMergeSort {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		StdOut.println("Asad Zaheer\nTest 1:");
		//initialize nodes
		ListNode node1 = new ListNode(8);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(9);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(4);
		//connect nodes
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		StdOut.println("\nList before sorted:\n" + node1);
		//merge nodes
		node1 = LinkedListMergeSortDD.sort(node1);
		StdOut.println("\nList after sorted:");
		//display merged list
		StdOut.println(node1);
		double time = timer.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time + " seconds.\n");
		
		//Second test
		//start stop watch for first test
		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Test 2:");
		//initialize nodes
		ListNode node11 = new ListNode("A");
		ListNode node12 = new ListNode("S");
		ListNode node13 = new ListNode("A");
		ListNode node14 = new ListNode("D");
		ListNode node15 = new ListNode("Z");
		ListNode node16 = new ListNode("A");
		ListNode node17 = new ListNode("H");
		ListNode node18 = new ListNode("E");
		ListNode node19 = new ListNode("E");
		ListNode node20 = new ListNode("R");
		//connect nodes
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
		node16.next = node17;
		node17.next = node18;
		node18.next = node19;
		node19.next = node20;
		StdOut.println("\nList before sorted:\n" + node11);
		//merge nodes
		node11 = LinkedListMergeSortDD.sort(node11);
		StdOut.println("\nList after sorted:");
		//display merged list
		StdOut.println(node11);
		double time2 = timer2.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time2 + " seconds.\n");
		
		//Third test
		//start stop watch for first test
		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Test 3:");
		//initialize nodes
		ListNode node111 = new ListNode("S");
		ListNode node112 = new ListNode("U");
		ListNode node113 = new ListNode("P");
		ListNode node114 = new ListNode("E");
		ListNode node115 = new ListNode("R");
		ListNode node116 = new ListNode("M");
		ListNode node117 = new ListNode("A");
		ListNode node118 = new ListNode("N");
		ListNode node119 = new ListNode("B");
		ListNode node120 = new ListNode("A");
		ListNode node121 = new ListNode("T");
		ListNode node122 = new ListNode("M");
		ListNode node123 = new ListNode("A");
		ListNode node124 = new ListNode("N");
		//connect nodes
		node111.next = node112;
		node112.next = node113;
		node113.next = node114;
		node114.next = node115;
		node115.next = node116;
		node116.next = node117;
		node117.next = node118;
		node118.next = node119;
		node119.next = node120;
		node120.next = node121;
		node121.next = node122;
		node122.next = node123;
		node123.next = node124;
		StdOut.println("\nList before sorted:\n" + node111);
		//merge nodes
		node111 = LinkedListMergeSortDD.sort(node111);
		StdOut.println("\nList after sorted:");
		//display merged list
		StdOut.println(node111);
		double time3 = timer3.elapsedTime();
		//display the execution time first test
		StdOut.println("\nExecution time " + time3 + " seconds.\n");
   }
}

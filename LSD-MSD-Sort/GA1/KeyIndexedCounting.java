package GA1;
/*
 * Program Name: KeyIndexedCounting.java
 * @author Asad Zaheer
 * @date 3 May 2020
 * 
 * Module 5.1 - Guided Assignment 1: Key-indexed counting (1 point)
 * Read
 * Section 5.1 Introduction (page 702)
 * Key-indexed counting (page 703-705)
 * CODE: Key indexed counting (pages 705)
 * Implement and test key indexed counting code (1 point)
 * Design and Implement a data structure with a name and a section (page 705)
 * Design and Implement class KeyIndexedCounting (page 705)
 * Test the class with 5 small arrays test cases
 */
public class KeyIndexedCounting {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize strings
		String[] s1 = new String[5];
		String[] s2 = new String[5];
		String[] s3 = new String[5];
		String[] s4 = new String[5];
		String[] s5 = new String[5];
		
		StdOut.println("Asad Zaheer\n\nTest 1\n");
		s1[0]="LS3BLNA3PS";
		s1[1]="130NIW5740";
		s1[2]="5D53KD8Y60";
		s1[3]="D48P1L3SOD";
		s1[4]="Y79HFL9XJM";
		sort(s1 , 10);
		for(int x = 0 ; x < s1.length ; x++) {
			StdOut.println(s1[x]);
		}
		StdOut.println();
		double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
		
		//start stop watch for second test
		Stopwatch timer2 = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 2\n");
		s2[0]="U45";
		s2[1]="J6Y";
		s2[2]="VRW";
		s2[3]="L60";
		s2[4]="ZVN";
		sort(s2 , 3);
		for(int x = 0 ; x < s1.length ; x++) {
			StdOut.println(s2[x]);
		}
		StdOut.println();
		double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
		
		//start stop watch for third test
		Stopwatch timer3 = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 3\n");
		s3[0]="NCDKJMN";
		s3[1]="0ZUBTWJ";
		s3[2]="TK58FLT";
		s3[3]="JNMCYJO";
		s3[4]="CG1LA9H";
		sort(s3 , 7);
		for(int x = 0 ; x < s1.length ; x++) {
			StdOut.println(s3[x]);
		}
		StdOut.println();
		double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
		
		//start stop watch for fourth test
		Stopwatch timer4 = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 4\n");
		s4[0]="K32Z";
		s4[1]="KJH6";
		s4[2]="5G9O";
		s4[3]="9JOL";
		s4[4]="VJNY";
		sort(s4 , 4);
		for(int x = 0 ; x < s1.length ; x++) {
			StdOut.println(s4[x]);
		}
		StdOut.println();
		double time4 = timer4.elapsedTime();
 		//display the execution time fourth test
 		StdOut.println("Execution time " + time4 + " seconds.\n");
		
		//start stop watch for fifth test
		Stopwatch timer5 = new Stopwatch();
		StdOut.println("Asad Zaheer\n\nTest 5\n");
		s5[0]="3KFLZOJ4";
		s5[1]="TNJ45FHX";
		s5[2]="AJC5QOR4";
		s5[3]="LOAQRP27";
		s5[4]="L9T7K8ZG";
		sort(s5 , 8);
		for(int x = 0 ; x < s1.length ; x++) {
			StdOut.println(s5[x]);
		}
		double time5 = timer5.elapsedTime();
 		//display the execution time fifth test
 		StdOut.println("Execution time " + time5 + " seconds.\n");
	}
	/*
	 * Sort a[] on leading W characters.
	 * 
	 * @param a. array
	 * @param W. length
	 * 
	 * @return none
	 */
	public static void sort(String[] a, int W) {
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		//Sort by key-indexed counting on dth char.
		for (int d = W-1; d >= 0; d--) { 
			int[] count = new int[R+1]; 
			//Compute frequency counts.
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}
			//Transform counts to indices.
			for (int r = 0; r < R; r++) {
				count[r+1] += count[r];
			}
			//Distribute.
			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			//Copy back.
			for (int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}
}

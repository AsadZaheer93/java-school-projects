package GA2;
/*
 * Program Name: BruteForceExcplicit.java
 * @author Asad Zaheer
 * @date 15 May 2020
 * 
 * Module 5.3 - Guided Assignment 2: Brute-force substring search with explicit backup (1 point)
 * Read
 * Section 5.3 Substring search (page 730)
 * A short history  (page 731)
 * Brute-force substring search (page 760-761)
 * CODE Brute-force substring search with explicit backup(page 761)
 * Implement and test:
 * Brute-force substring search with explicit backup (page 761)
 * Modify the program to trace the execution like below:
 * Show the parameters pat and txt
 * In the for-i loop show i, and the text starting from the i-th character
 * In the  for-j loop
 * show j
 * show the (i+j) character in the text
 * show j character in the pattern
 * if they are different write "NOT EQUAL"
 * if they are the same write "EQUAL"
 * if  j = m write " FOUND FROM POSITION " + i before returning the answer
 * if not found write "NOT FOUND"
 * Test the algorithm with 5 representative strings, showing the trace and the result
 */
public class BruteForceExplicit {
	public static void main(String args[]){
		//start stop watch
		Stopwatch timer = new Stopwatch();
        for(int x= 0 ; x < txt.length ; x++){
        	StdOut.println("\n\nAsad Zaheer\n\nTest " + (x + 1) + "\n");
            q2(pat[x], txt[x]);
        }
        StdOut.println();
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
    }
    static String txt[] = {
    		"This is a random sentence",
            "an algorithm of 5 ",
            "superman is the greatest",
            "my name is asad zaheer",
            "the semester is almost over"
    };

    static String pat[] = {
    		"is",
            "asad",
            "superman",
            "semester",
            "random"
    };

    public static int q2(String pat, String txt) {
        StdOut.println("txt: " + txt);
        StdOut.println("pat: " + pat);
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            StdOut.println("i: " + i + ", " + txt.substring(i));
            StdOut.println("j: " + j);
            StdOut.println("pat[j]: " + pat.charAt(j));
            if (txt.charAt(i) == pat.charAt(j)) {
                StdOut.println("EQUAL");
                j++;
            }
            else {
                StdOut.println("NOT EQUAL");
                i -= j;
                j = 0;
            }
        }
        //found
        if (j == M) { 
            StdOut.println(" FOUND FROM POSITION " + i );
            return i - M;
        }
        //not found
        else {
            StdOut.println("NOT FOUND");
            return N;  
        }
    }
}

package GA4;
/*
 * Program Name: DFA.java
 * @author Asad Zaheer
 * @date 15 May 2020
 * 
 * Module 5.3 - Guided Assignment 4: Constructing the DFA (1 point)
 * Read
 * Constructing the DFA (page 765-767)
 * CODE Constructing the DFA for KMP substring search (page 766)
 * Implement and test:
 * CODE Constructing the DFA for KMP substring search (page 766)
 * Modify the program to trace the execution like below:
 * Show the parameters pat 
 * Show all the non zero assignments to dfa in the format: dfa['A'][3] = 4
 * In the for-j loop show x and j, and the j-th character in the pattern character
 * In the  for-c loop
 * show c
 * show the dfa assignment
 * Show the new x value
 * At the end show the entire matrix
 * Test the algorithm with 5 representative strings, showing the trace and the result
 */
import java.util.*;

public class DFA {
	public static void main(String args[]){
		//start stop watch
		Stopwatch timer = new Stopwatch();
		for(int x = 0 ; x < pat.length ; x++){
			StdOut.println("\n\nAsad Zaheer\n\nTest " + (x + 1) + "\n");
            q4(pat[x]);
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

    public static void q4(String pat){
        char[] chars = pat.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        String index = sb.toString();
        int M = pat.length();
        int R = index.length();
        int dfa[][] = new int[R][pat.length()];
        System.out.println("pat: " + pat);
        dfa[index.indexOf(pat.charAt(0))][0] = 1;
        System.out.println("dfa['" + pat.charAt(0) + "'] [" + 0 + "] = " + 1);
        //Compute dfa[][j]
        for (int X = 0, j = 1; j < M; j++) {  
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
                System.out.println("c: " + c);
                if(dfa[c][X] > 0) {
                    System.out.println("dfa['" + index.charAt(c) + "'] [" + j + "] = " + dfa[c][X]);
                }
            }
            dfa[index.indexOf(pat.charAt(j))][j] = j+1;
            System.out.println("dfa['" + pat.charAt(j) + "'] [" + j + "] = " + (j+1));
            X = dfa[index.indexOf(pat.charAt(j))][X];
            System.out.println("X: " + X);
        }
        for(int i = 0 ; i < index.length() ; i++){
            System.out.println(index.charAt(i) + ": " + Arrays.toString(dfa[i]));
        }
    }
}

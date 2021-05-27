package GA5;
/*
 * Program Name: GA5.java
 * @author Asad Zaheer
 * @date 15 May 2020
 * 
 * Module 5.3 - Guided Assignment 5: KMP substring search (1 point)
 * Read
 * Algorithm 5.6 and its explanations (page 768-769)
 * CODE Algorithm 5.6 KMP substring search (page 768)
 * Implement and test:
 * CODE Algorithm 5. 6 KMP substring search (page 768)
 * Modify the program to trace the execution of the search method like below:
 * Show the parameter text 
 * In the for-ij loop show i and j
 * show i and j
 * show the i-th character in the input text
 * show the new value of j
 * if j is m then show "FOUND " and the starting index
 * otherwise show "NOT FOUND" and the starting index
 * Test the algorithm with 5 representative strings, showing the trace and the result
 */
public class GA5 {
	 public static void main(String args[]){
		//start stop watch
		 Stopwatch timer = new Stopwatch();
		 q5();
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

   
    public static void q5(){
        for(int i = 0 ; i < pat.length ; i++){
        	StdOut.println("\n\nAsad Zaheer\n\nTest " + (i + 1) + "\n");
            KMP kmp = new KMP(pat[i]);
            int offset = kmp.search(txt[i]);
            System.out.println("text:    " + txt[i]);
            System.out.print("pattern: ");
            for (int j = 0; j < offset; j++)
                System.out.print(" ");
            System.out.println(pat[i]);
        }
    }
}

package GA2;
/*
 * Program Name: LSD.java
 * @author Asad Zaheer
 * @date 3 May 2020
 * 
 * Module 5.1 - Guided Assignment 2: LSD string sort (1 point)
 * Read
 * LSD string sort (page 706-709)
 * ALGORITHM 5.1 LSD String sort(page 710)
 * Implement and test LSD String sort (1 point)
 * Implement LSD String sort (page 710)
 * Test the class with 5 small arrays test cases
 */
public class LSD {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize strings
		String[] s1 = {"LS3BLNA3PS","130NIW5740","5D53KD8Y60","D48P1L3SOD","Y79HFL9XJM"};
		String[] s2 = {"U45","J6Y","VRW","L60","ZVN"};
		String[] s3 = {"NCDKJMN","0ZUBTWJ","TK58FLT","JNMCYJO","CG1LA9H"};
		String[] s4 = {"K32Z","KJH6","5G9O","9JOL","VJNY"};
		String[] s5 = {"3KFLZOJ4","TNJ45FHX","AJC5QOR4","LOAQRP27","L9T7K8ZG"};
    	int n = 5;
    	
    	StdOut.println("Asad Zaheer\n\nLSD Test 1\n");
        //check if all strings are of the same length
        int w = s1[0].length();
        for (int x = 0; x < n; x++) {
        	if(s1[x].length() == w) {
        		sort(s1,w);
        		StdOut.println(s1[x]);
        	}
        	else {
        		StdOut.println("ERROR! All strings should be the same length");
        	}
        }
        StdOut.println();
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
        
        //start stop watch for second test
        Stopwatch timer2 = new Stopwatch();
        StdOut.println("Asad Zaheer\n\nLSD Test 2\n");
        //check if all strings are of the same length
        int w1 = s2[0].length();
        for (int x = 0; x < n; x++) {
        	if(s2[x].length() == w1) {
        		sort(s2,w1);
        		StdOut.println(s2[x]);
        	}
        	else {
        		StdOut.println("ERROR! All strings should be the same length");
        	}
        }
        StdOut.println();   
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
        
        //start stop watch for third test
        Stopwatch timer3 = new Stopwatch();
        StdOut.println("Asad Zaheer\n\nLSD Test 3\n");
        //check if all strings are of the same length
        int w2 = s3[0].length();
        for (int x= 0; x < n; x++) {
        	if(s3[x].length() == w2) {
        		sort(s3,w2);
		      	StdOut.println(s3[x]);
        	}
        	else {
        		StdOut.println("ERROR! All strings should be the same length");
        	}
        }
        StdOut.println();  
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
        
        //start stop watch for fourth test
        Stopwatch timer4 = new Stopwatch();
        StdOut.println("Asad Zaheer\n\nLSD Test 4\n");
        //check if all strings are of the same length
        int w3 = s4[0].length();
        for (int x = 0; x < n; x++) {
        	if(s4[x].length() == w3) {
        		sort(s4,w3);
        		StdOut.println(s4[x]);
        	}
        	else {
        		StdOut.println("ERROR! All strings should be the same length");
        	}
        }
        StdOut.println();
        double time4 = timer4.elapsedTime();
 		//display the execution time fourth test
 		StdOut.println("Execution time " + time4 + " seconds.\n");
        
        //start stop watch for fifth test
        Stopwatch timer5 = new Stopwatch();
        StdOut.println("Asad Zaheer\n\nLSD Test 5\n");
        //check if all strings are of the same length
        int w4 = s5[0].length();
        for (int x = 0; x < n; x++) {
        	if(s5[x].length() == w4) { 
        		sort(s5,w4);
        		StdOut.println(s5[x]);
        	}
        	else {
        		StdOut.println("ERROR! All strings should be the same length");
        	}
        }      
        StdOut.println();
        double time5 = timer5.elapsedTime();
 		//display the execution time fifth test
 		StdOut.println("Execution time " + time5 + " seconds.\n");
    }
	private static final int BITS_PER_BYTE = 8;
	/*
	 * object creation
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	private LSD() { 
		
	}
	/*
	 * Sort a[] on leading W characters.
	 * 
	 * @param a. array
	 * @param W. length
	 * 
	 * @return none
	 */
	public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 256;   
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++) {
            	count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
            	count[r+1] += count[r];
            }
            for (int i = 0; i < n; i++) {
            	aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < n; i++) {
            	a[i] = aux[i];
            }
        }
    }
	/*
	 * sort array
	 * 
	 * @param a. array
	 * 
	 * @return none
	 */
	public static void sort(int[] a) {
        final int BITS = 32;                 
        final int R = 1 << BITS_PER_BYTE;   
        final int MASK = R - 1;              
        final int w = BITS / BITS_PER_BYTE; 
        int n = a.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) { 
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++) {           
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
            }
            for (int r = 0; r < R; r++){
            	count[r+1] += count[r];
            }
            if (d == w-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++) {
                	count[r] += shift1;
                }
                for (int r = R/2; r < R; r++) {
                	count[r] -= shift2;
                }
            }
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                aux[count[c]++] = a[i];
            }
            for (int i = 0; i < n; i++) {
            	a[i] = aux[i];
            }
        }
    }
}


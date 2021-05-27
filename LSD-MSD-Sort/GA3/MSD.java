package GA3;
/*
 * Program Name: MSD.java
 * @author Asad Zaheer
 * @date 3 May 2020
 * 
 * Module 5.1 - Guided Assignment 3: MSD string sort (1 point)
 * Read
 * MSD string sort (page 710-718)
 * ALGORITHM 5.2 MSD String sort (page 712)
 * CODE: insertion sort for strings whose first d characters are equal (page 715)
 * Implement and test MSD String sort (1 point)
 * Implement MSD String sort (page 712)
 * Test the class with 5 small arrays test cases
 */
public class MSD {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
		//initialize variables
    	String[] s1 = {"LS3A3PS","130N740","53KD8Y60","D48P1L3D","Y7M"};
		String[] s2 = {"U45","J6Y","VRW","L60","ZVN"};
		String[] s3 = {"NCDJMN","0BTWJ","TK5FLT","JNYJO","C1LA9H"};
		String[] s4 = {"K32Z","KJH6","5G9O","9JOL","VJNY"};
		String[] s5 = {"3J4","TFHX","A5QOR4","L7","L9T7K8ZG"};
        
		int n = s1.length;
        sort(s1);
        StdOut.println("Asad Zaheer\n\nMSD Test 1\n");
        for (int x = 0; x < n; x++) {
        	StdOut.println(s1[x]);
        }
        StdOut.println();
        double time = timer.elapsedTime();
 		//display the execution time first test
 		StdOut.println("Execution time " + time + " seconds.\n");
        
        //start stop watch for second test
        Stopwatch timer2 = new Stopwatch();
        int n1 = s2.length;
        StdOut.println("Asad Zaheer\n\nMSD Test 2\n");
        sort(s2);
        for (int x = 0; x < n1; x++) {
        	StdOut.println(s2[x]);
        }
        StdOut.println();
        double time2 = timer2.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time2 + " seconds.\n");
        
        //start stop watch for third test
        Stopwatch timer3 = new Stopwatch();
        int n2 = s3.length;
        StdOut.println("Asad Zaheer\n\nMSD Test 3\n");
        sort(s3);
        for (int x = 0; x < n2; x++) {
        	StdOut.println(s3[x]);
        }
        StdOut.println();
        double time3 = timer3.elapsedTime();
 		//display the execution time third test
 		StdOut.println("Execution time " + time3 + " seconds.\n");
        
        //start stop watch for fourth test
        Stopwatch timer4 = new Stopwatch();
        int n3 = s4.length;
        StdOut.println("Asad Zaheer\n\nMSD Test 4\n");
        sort(s4);
        for (int x = 0; x < n3; x++) {
        	StdOut.println(s4[x]);
        }
        StdOut.println();
        double time4 = timer4.elapsedTime();
 		//display the execution time fourth test
 		StdOut.println("Execution time " + time4 + " seconds.\n");
        
        //start stop watch for fifth test
        Stopwatch timer5 = new Stopwatch();
        int n4 = s5.length;
        StdOut.println("Asad Zaheer\n\nMSD Test 5\n");
        sort(s5);
        for (int x = 0; x < n4; x++) {
        	StdOut.println(s5[x]);
        }
        StdOut.println();
        double time5 = timer5.elapsedTime();
 		//display the execution time fifth test
 		StdOut.println("Execution time " + time5 + " seconds.\n");
    }
	//initialize variables
	private static final int BITS_PER_BYTE =   8;
    private static final int BITS_PER_INT  =  32;   
    private static final int R             = 256;   
    private static final int CUTOFF        =  15;   
    /*
	 * object creation
	 * 
	 * @param none
	 * 
	 * @return none
	 */
    private MSD() { 
    	
    } 
    /*
	 * Sort array
	 * 
	 * @param a. array
	 * 
	 * @return none
	 */
    public static void sort(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n-1, 0, aux);
    }
    /*
	 * find character
	 * 
	 * @param s. string
	 * @param d. location
	 * 
	 * @return char. character
	 */
    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) {
        	return -1;
        }
        return s.charAt(d);
    }
    /*
     * Sort
     * 
     * @param a. array
     * @param lo. location
     * @param hi. location
     * @param d. location
     * @param aux. auxiliary element
     * 
     * @return none
     */
    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }
        for (int r = 0; r < R+1; r++) {
        	count[r+1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
        	a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
        	sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
        }
    }
    /*
	 * Sort array in using insertion algorithm
	 * 
	 * @param a. array
     * @param lo. location
     * @param hi. location
     * @param d. location
	 * 
	 * @return none
	 */
    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }
    /*
	 * Check which element is greater than
	 * 
	 * @param a. array
	 * @param i. First element
	 * @param j. Second element
	 * 
	 * @return boolean. If element greater than
	 */
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /*
	 * Check which element is lesser than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * @param d. location
	 * 
	 * @return boolean. If element lesser than
	 */
    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) {
            	return true;
            }
            if (v.charAt(i) > w.charAt(i)) {
            	return false;
            }
        }
        return v.length() < w.length();
    }
    /*
     * Sort
     * 
     * @param a. array
     * 
     * @return none
     */
    public static void sort(int[] a) {
        int n = a.length;
        int[] aux = new int[n];
        sort(a, 0, n-1, 0, aux);
    }
    /*
     * Sort
     * 
     * @param a. array
     * @param lo. location
     * @param hi. location
     * @param d. location
     * @param aux. auxiliary element
     * 
     * @return none
     */
    private static void sort(int[] a, int lo, int hi, int d, int[] aux) {
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        int[] count = new int[R+1];
        int mask = R - 1;   // 0xFF;
        int shift = BITS_PER_INT - BITS_PER_BYTE*d - BITS_PER_BYTE;
        for (int i = lo; i <= hi; i++) {
            int c = (a[i] >> shift) & mask;
            count[c + 1]++;
        }
        for (int r = 0; r < R; r++) {
        	count[r+1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            int c = (a[i] >> shift) & mask;
            aux[count[c]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        if (d == 4) {
        	return;
        }
        if (count[0] > 0) {
        	sort(a, lo, lo + count[0] - 1, d+1, aux);
        }
        for (int r = 0; r < R; r++) {
        	if (count[r+1] > count[r]) {
        		sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
        	}
        }
                
    }
    /*
	 * Sort array in using insertion algorithm
	 * 
	 * @param a. array
     * @param lo. location
     * @param hi. location
     * @param d. location
	 * 
	 * @return none
	 */
    private static void insertion(int[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && a[j] < a[j-1]; j--) {
            	exch(a, j, j-1);
            }
        }
    }
    /*
	 * Check which element is greater than
	 * 
	 * @param a. array
	 * @param i. First element
	 * @param j. Second element
	 * 
	 * @return boolean. If element greater than
	 */
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

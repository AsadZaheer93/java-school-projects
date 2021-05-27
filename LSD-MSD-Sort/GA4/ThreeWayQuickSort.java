package GA4;
/*
 * Program Name: ThreeWayQuickSort.java
 * @author Asad Zaheer
 * @date 3 May 2020
 * 
 * Module 5.1 - Guided Assignment 4: three way string quick sort (1 point)
 * Read
 * Three way string quick sort (page 719-725)
 * ALGORITHM 5.3 Three way string quick sort (page 720)
 * Implement and test Three way string quick sort (1 point)
 * Implement Three way string quick sort (page 720)
 * Test the class with 5 small arrays test cases
 */
public class ThreeWayQuickSort {
	public static void main(String[] args) {
		//start stop watch for first test
		Stopwatch timer = new Stopwatch();
    	String[] s1 = {"LS3A3PS","130N740","53KD8Y60","D48P1L3D","Y7M"};
		String[] s2 = {"U45","J6Y","VRW","L60","ZVN"};
		String[] s3 = {"NCDJMN","0BTWJ","TK5FLT","JNYJO","C1LA9H"};
		String[] s4 = {"K32Z","KJH6","5G9O","9JOL","VJNY"};
		String[] s5 = {"3J4","TFHX","A5QOR4","L7","L9T7K8ZG"};
		
        int n = s1.length;
        sort(s1);
        StdOut.println("Asad Zaheer\n\nThree-way Quicksort Test 1\n");
        for (int x = 0; x < n; x++) {
        	StdOut.println(s1[x]);
        }
        StdOut.println();
        double time = timer.elapsedTime();
 		//display the execution time second test
 		StdOut.println("Execution time " + time + " seconds.\n");
        
        //start stop watch for second test
        Stopwatch timer2 = new Stopwatch();
        int n1 = s2.length;
        StdOut.println("Asad Zaheer\n\nThree-way Quicksort Test 2\n");
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
        StdOut.println("Asad Zaheer\n\nThree-way Quicksort Test 3\n");
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
        StdOut.println("Asad Zaheer\n\nThree-way Quicksort Test 4\n");
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
        StdOut.println("Asad Zaheer\n\nThree-way Quicksort Test 5\n");
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
	private static final int CUTOFF =  15;   
	/*
	 * object creation
	 * 
	 * @param none
	 * 
	 * @return none
	 */
    private ThreeWayQuickSort() { 
    	
    } 

    /*
     * Sort array in ascending order
     *
     * @param a. array
     * 
     * @return none
     */
    public static void sort(String[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1, 0);
        assert isSorted(a);
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
     * three way quick sort
     * 
     * @param a. array
     * @param lo. location
     * @param hi. location
     * @param d. location
	 * 
	 * @return none
     */
    private static void sort(String[] a, int lo, int hi, int d) { 
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        int lt = lo;
        int gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) {
            	exch(a, lt++, i++);
            }
            else if (t > v) {
            	exch(a, i, gt--);
            }
            else {
            	i++;
            }
        }
        //a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
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
        assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
    /*
     * check if array is sorted
     * 
     * @param a. array
     * 
     * @return true or false
     */
    private static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
            	return false;
            }
        }
        return true;
    }
}

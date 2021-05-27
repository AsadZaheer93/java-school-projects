package GA5;

public class KMP {
	//initialize variables
    private static String pat;
    private int[][] dfa;

    /*
     * build DFA
     * 
     * @param pat. pattern
     * 
     * @return none
     */
    public KMP(String pat) {  
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        //Compute dfa[][j].
        for (int X = 0, j = 1; j < M; j++) {  
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }
    /*
     * search trough string
     * 
     * @param txt. text
     * 
     * @return N. found string
     */
    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            System.out.println("i: " + i + ", j: " + j);
            System.out.println("i-th char: " + txt.charAt(i));
            j = dfa[txt.charAt(i)][j];
            System.out.println("new j value: " + j);
        }
        //found (hit end of pattern)
        if (j == M) {
            System.out.println("FOUND");
            return i - M;  
        }
        //not found (hit end of text)
        else {
            System.out.println("NOT FOUND");
            return N;      
        }
    }
}

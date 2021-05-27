package GA10;

public class TriesSTExternalOneWay<Value> {
	//initialize variables
    private final Node root = new Node(false);
    private char CASE;   
    /*
     * default
     * 
     * @param none
     * 
     * @return none
     */
    public TriesSTExternalOneWay() {
        CASE = 'a';     // default case
    }
    /*
     * object creation
     * 
     * @param CASE. character
     * 
     * @return none
     */
    public TriesSTExternalOneWay(char CASE) {
        this.CASE = CASE;  
    }
    /*
     * add key and value
     * 
     * @param key. key
     * @param val. value
     * 
     * @return none
     */
    public void put(String key, Value val) {
    	insert(key, val);
    }
    /*
     * add word
     * 
     * @param word. word
     * @param val. value
     * 
     * @return none
     */
    private void insert(String word, Value val) {
        Node trav = root;
        int x = 0;
        trav.val = val;
        while (x < word.length() && trav.edgeLabel[word.charAt(x) - CASE] != null) {
            int index = word.charAt(x) - CASE, y = 0;
            StringBuilder label = trav.edgeLabel[index];
            while (y < label.length() && x < word.length() && label.charAt(y) == word.charAt(x)) {
                ++x;
                ++y;
            }
            if (y == label.length()) {
                trav = trav.children[index];
            } 
            else {
            	//add prefix to existing word
                if (x == word.length()) {   
                    Node existingChild = trav.children[index];
                    Node newChild = new Node(true);
                    StringBuilder remainingLabel = strCopy(label, y);
                    label.setLength(y); 
                    trav.children[index] = newChild; 
                    newChild.children[remainingLabel.charAt(0) - CASE] = existingChild;
                    newChild.edgeLabel[remainingLabel.charAt(0) - CASE] = remainingLabel;
                }
                //add word to existing word
                else {     
                    StringBuilder remainingLabel = strCopy(label, y);
                    Node newChild = new Node(false);
                    StringBuilder remainingWord = strCopy(word, x);
                    Node temp = trav.children[index];
                    label.setLength(y);
                    trav.children[index] = newChild;
                    newChild.edgeLabel[remainingLabel.charAt(0) - CASE] = remainingLabel;
                    newChild.children[remainingLabel.charAt(0) - CASE] = temp;
                    newChild.edgeLabel[remainingWord.charAt(0) - CASE] = remainingWord;
                    newChild.children[remainingWord.charAt(0) - CASE] = new Node(true);
                }
                return;
            }
        }
        //add new word
        if (x < word.length()) {    
            trav.edgeLabel[word.charAt(x) - CASE] = strCopy(word, x);
            trav.children[word.charAt(x) - CASE] = new Node(true);
        } 
        else {    
            trav.isEnd = true;
        }
    }
    /*
     * build string
     * 
     * @param str. string
     * @param index. index
     * 
     * @return result. accumulated string
     */
    private StringBuilder strCopy(CharSequence str, int index) {
        StringBuilder result = new StringBuilder(100);
        while (index != str.length()) {
            result.append(str.charAt(index++));
        }
        return result;
    }
    /*
     * output string
     * 
     * @param none
     * 
     * @return none
     */
    public void print() {
        printUtil(root, new StringBuilder());
    }
    /*
     * output string with node and string builder
     * 
     * @param node. node
     * @param str. string
     * 
     * @return none
     */
    private void printUtil(Node node, StringBuilder str) {
        if (node.isEnd) {
            System.out.println(str);
        }
        for (int i = 0; i < node.edgeLabel.length; ++i) {
            if (node.edgeLabel[i] != null) {
                int length = str.length();
                str = str.append(node.edgeLabel[i]);
                printUtil(node.children[i], str);
                str = str.delete(length, str.length());
            }
        }
    }
}

class Node {
    private final static int SYMBOLS = 26;
    Node[] children = new Node[SYMBOLS];
    StringBuilder[] edgeLabel = new StringBuilder[SYMBOLS];
    boolean isEnd;
    Object val;

    public Node(boolean isEnd) {
        this.isEnd = isEnd;
    }

}

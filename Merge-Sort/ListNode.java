package W4_ZAHEER_ASAD;

import java.util.*;

public class ListNode {
	//default values
	Comparable value;
    ListNode next;
    /*
     * default constructor for node creation
     * 
     * @param val. Value of node
     */
    ListNode(Comparable val) { 
    	value = val; 
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	String output = "";
        ListNode cur = this;
        //output each value in the nodes
        while (cur != null) {
            output += cur.value + " ";
            cur = cur.next;
        }
        return output;
    }
}

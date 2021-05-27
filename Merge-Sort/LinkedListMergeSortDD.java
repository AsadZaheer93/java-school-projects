package W4_ZAHEER_ASAD;

public class LinkedListMergeSortDD {
    /* 
     * Get the minimum value and put it at the beginning of the node
     * 
     * @param node. Node object with its values
     * 
     * @return min. Minimum value of node
     */
    private static ListNode getMin(ListNode node) {
    	//initialize node locations
        Comparable minVal = node.value;
        ListNode current = node;
        ListNode minNode = null;
        //check if a node exists
        while (current.next != null) {
            if (less(current.next.value, minVal)) {
            	//change value of minimum node and value
            	minVal = current.next.value;
                minNode = current;
            }
            current = current.next;
        }
        //return node if no value exists
        if (minNode == null) {
        	return node;
        }
        //change existing minimum value to the new one found
        ListNode temp = minNode.next.next;
        ListNode min = minNode.next;
        min.next = node;
        minNode.next = temp;
        //minimum value
        return min;
    }
    /*
     * Sort nodes in order
     * 
     * @param node. Node object with its values
     * 
     * @return node. Sorted node
     */
    public static ListNode sort(ListNode node) {
        //Initialize variables
    	node = getMin(node);
        ListNode top = node;
        while (true) {
        	ListNode lo = top.next;
        	ListNode mid = lo;
        	//move node
            while (mid.next != null && !less(mid.next.value, mid.value)) {	
            	mid = mid.next;	
            }
            //check if sorted
            if (mid.next == null) {
            	//return if already sorted
                if (top == node) {
                	return node;
                }
                top = node;
                continue;
            }
            ListNode hi = mid.next;
            //move node
            while (hi.next != null && !less(hi.next.value, hi.value)) {
                hi = hi.next;
            }
            //sort node
            merge(top, lo, mid, hi);
            //check if sorted
            if (hi.next == null) {
            	//return if already sorted
                if (top == node) {
                	return node;
                }
                top = node;
            } 
            else {	
            	top = hi;	
            }
        }
    }
    /*
     * Combine nodes using the merge algorithm
     * 
     * @param node. Current location of node
     * @param lo. Lowest location of node
     * @param mid. Middle location of node
     * @param hi. Highest location of node
     * 
     * @return none.
     */
    public static void merge(ListNode node, ListNode lo, ListNode mid, ListNode hi) {
    	//initialize locations of node
    	ListNode leftNode = lo;
    	ListNode rightNode = mid.next;
    	ListNode currentNode = node;
    	ListNode lastLeftNode = mid.next;
    	ListNode lastRightNode = hi.next;
    	//checking for nodes to merge
        while (leftNode != lastLeftNode|| rightNode != lastRightNode) {
        	//move node to right
            if (leftNode == lastLeftNode) {
            	currentNode.next = rightNode;
                rightNode = rightNode.next;
            } 
            //move node to left
            else if ((rightNode == lastRightNode) || (less(leftNode.value, rightNode.value))) {
            	currentNode.next = leftNode;
                leftNode = leftNode.next;
            }
            //move node to right
            else {
            	currentNode.next = rightNode;
                rightNode = rightNode.next;
            }
            //locate next node
            currentNode = currentNode.next;
        }
        currentNode.next = lastRightNode;
    }
    /*
	 * Check which element is lesser than
	 * 
	 * @param v. First element
	 * @param w. Second element
	 * 
	 * @return boolean. If element lesser than
	 */
    private static boolean less(Comparable v, Comparable w)  {	
    	return v.compareTo(w) < 0;	}
}

package GA10;

import java.util.*;

public class TrieST<Value> {
	//initialize variables
	private static int R = 256; 
	private Node root; 
	/*
	 * object creation
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}
	/*
	 * get values
	 * 
	 * @param key. the key
	 * 
	 * @return none
	 */
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null) {
			return null;
		}
		return (Value) x.val;
	}
	/*
	 * Return value associated with key in the subtrie rooted at x
	 * 
	 * @param x. node
	 * @param key. the key
	 * @param d. position
	 * 
	 * @return node
	 */
	private Node get(Node x, String key, int d) { 
		if (x == null) {
			return null;
		}
		if (d == key.length()) {
			return x;
		}
		char c = key.charAt(d); 
		return get(x.next[c], key, d + 1);
	}
	/*
	 * add value
	 * 
	 * @param key. the key
	 * @param val. value
	 * 
	 * @return none
	 */
	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}
	/*
	 * Change value associated with key if in subtrie rooted at
	 * 
	 * @param x. node
	 * @param key. the key
	 * @param val. value
	 * @param d. position
	 * 
	 * @return none
	 */
	private Node put(Node x, String key, Value val, int d) { 
		if (x == null) {
			x = new Node();
		}
		if (d == key.length()) {
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
	/*
	 * get size
	 * 
	 * @param none
	 * 
	 * @return size(root). size 
	 */
	public int size() {
		return size(root);
	}
	/*
	 * get size of nodes
	 * 
	 * @param x. node
	 * 
	 * @return count. size of nodes
	 */
	private int size(Node x) {
		if (x == null) {
			return 0;
		}
		int count = 0;
		if (x.val != null) {
			count++;
		}
		for (char c = 0; c < R; c++) {
			count += size(x.next[c]);
		}
		return count;
	}
	
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new LinkedList<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}
	/*
	 * gather trie
	 * 
	 * @param x. node
	 * @param pre. prefix
	 * @param q. queue
	 * 
	 * @return none
	 */
	private void collect(Node x, String pre, Queue<String> q) {
		if (x == null) {
			return;
		}
		if (x.val != null) {
			q.add(pre);
		}
		for (char c = 0; c < R; c++) {
			collect(x.next[c], pre + c, q);
		}
	}
	/*
	 * iterate through queue
	 * 
	 * @param pat
	 * 
	 * @return q. queue
	 */
	public Iterable<String> keysThatMatch(String pat) {
		Queue<String> q = new LinkedList<String>();
		collect(root, "", pat, q);
		return q;
	}
	/*
	 * gather trie
	 * 
	 * @param x. node
	 * @param pre. prefix
	 * @param pat
	 * @param q. queue
	 * 
	 * @return none
	 */
	public void collect(Node x, String pre, String pat, Queue<String> q) {
		int d = pre.length();
		if (x == null) {
			return;
		}
		if (d == pat.length() && x.val != null) {
			q.add(pre);
		}
		if (d == pat.length()) {
			return;
		}
		char next = pat.charAt(d);
		for (char c = 0; c < R; c++) {
			if (next == '.' || next == c) {
				collect(x.next[c], pre + c, pat, q);
			}
		}
	}
	/*
	 * find longest prefix
	 * 
	 * @param s. String
	 * 
	 * @return substring of prefix
	 */
	public String longestPrefixOf(String s) {
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}
	/*
	 * look through trie
	 * 
	 * @param x. node
	 * @param s. string
	 * @param d. position
	 * @param length. length of node
	 * 
	 * @return search
	 */
	private int search(Node x, String s, int d, int length) {
		if (x == null) {
			return length;
		}
		if (x.val != null) {
			length = d;
		}
		if (d == s.length()) {
			return length;
		}
		char c = s.charAt(d);
		return search(x.next[c], s, d + 1, length);
	}
	/*
	 * delete key
	 * 
	 * @param key. the key
	 * 
	 * @return none
	 */
	public void delete(String key) {
		root = delete(root, key, 0);
	}
	/*
	 * delete node
	 * 
	 * @param x. node
	 * @param key. the key
	 * @param d. position
	 * 
	 * @return Node
	 */
	private Node delete(Node x, String key, int d) {
		if (x == null) {
			return null;
		}
		if (d == key.length()) {
			x.val = null;
		}
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		if (x.val != null) {
			return x;
		}
		for (char c = 0; c < R; c++) {
			if (x.next[c] != null) {
				return x;
			}
		}
		return null;
	}
}


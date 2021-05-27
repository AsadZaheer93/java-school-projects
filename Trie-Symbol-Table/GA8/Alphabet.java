package GA8;

public class Alphabet {
	//Initialize variables
	private static int R;
	private static String str;
	/*
	 * object creations
	 * 
	 * @param str. alphabet
	 * 
	 * @return none
	 */
	public Alphabet(String str) {
		this.R = str.length();
		this.str = str;
	}
	/*
	 * locate character
	 * 
	 * @param index. position
	 * 
	 * @return position
	 */
	public static char toChar(int index) {
		return str.charAt(index);
	}
	/*
	 * find position
	 * 
	 * @param c. character
	 * 
	 * @return c. character
	 */
	public static int toIndex(char c) {
		for(int i = 0; i < R; i++) {
			if(str.charAt(i) == c) {
				return i;
			}
		}
		return c;
	}
}

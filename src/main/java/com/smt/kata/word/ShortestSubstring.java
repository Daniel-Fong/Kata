package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: ShortestSubstring.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Shortest Substring Kata
 * 
 * Given a string and a set of characters, return the shortest substring 
 * containing all the characters in the set.  The characters in the set can be in 
 * any order.
 * 
 * For example, given the string "figehaeci" and the set of characters {a, e, i}, 
 * you should return "aeci".
 * 
 * Another example, given the string "figehaeci" and the set of characters {i, a, e }, 
 * you should return "aeci" as well.
 * 
 * If there is no substring containing all the characters in the set, return ""

 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 29, 2022
 * @updates:
 ****************************************************************************/
public class ShortestSubstring {

	/**
	 * Find the smallest substring for the given word and chatracters
	 * @param word Word to evaluate against
	 * @param sequence Characters to find in the smallest substring
	 * @return Smallest substring.  Empty if not found
	 */
	public String find(String word, char[] sequence) {
		if (word == null || word.length() < 1 || sequence == null || sequence.length > word.length() || sequence.length < 1) return ""; 
		String result = "";
		int length = word.length() + 1;
		for (int i = 0; i < word.length(); i++) {
			for (int j = i + 1; j <= word.length(); j++) {
				String newWord = word.substring(i, j);
				String temp = word.substring(i, j);
				boolean valid = true;
				for (char c : sequence) {
					if (temp.indexOf(c) < 0) {
						valid = false;
					} else {
						temp = temp.replaceFirst(c + "", "");
					}
				}
				if (valid && length > newWord.length()) {
					result = newWord;
					length = newWord.length();
				}
			}
		}
		return result;
	}
}
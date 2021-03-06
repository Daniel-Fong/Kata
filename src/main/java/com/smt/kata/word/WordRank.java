package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: WordRank.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Word Rank
 * Take a phrase and evaluate each word in the phrase.  Add up all of the values for
 * each word.  Return the word in the phrase that has the highest value.  If two words
 * share the same value, use the first value.  The values will be a=1, b=2, ....
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
public class WordRank {

	/**
	 * 
	 */
	public WordRank() {
		super();
	}

	/**
	 * Ranks the words and returns the proper entry
	 * @param phrase
	 * @return
	 */
	public String calculate(String phrase) {
		if (phrase == null || phrase == "") {
			return "";
		}
		String[] originalArr = phrase.split(" ");
		String upper = phrase.toUpperCase();
		String[] arr = upper.split(" ");
		int max = 0;
		String highest = "";
		
		for (int i=0; i<arr.length; i++) {
			int temp = 0;
			for (int j=0; j<arr[i].length(); j++) {
				temp += arr[i].charAt(j) - 64;
			}
			if (temp > max) {
				max = temp;
				highest = originalArr[i];
			}
		}
		return highest;
	}
}

package com.smt.kata.word;

import java.util.ArrayList;
// JDK 11.x
import java.util.Collection;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: RearrangeWords.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Rearrange Words Kata
 * 
 * Given a string with repeated characters, rearrange the string so that no two 
 * adjacent characters are the same. If this is not possible, return None.  Return a 
 * collection of all of the possible variations that can occur with no two
 * characters repeated
 * 
 * If the word passed in already has no repeating characters, return just that word
 * 
 * For example, given "aaabbc", you could return :
 * ababac, ababca, abacab, abacba, abcaba, acabab, acbaba, babaca, bacaba, cababa 
 * 
 * Given "aaab", return an empty collection.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
public class RearrangeWords {

	/**
	 * Rearranges the characters in a word such that there are no 2 adjacent characters
	 * @param word Word to rearrange
	 * @return All the possible ways the word can be rearranged to not have sequential characters
	 */
	public Collection<String> arrange(String word) {
		if (word == null || word.length() <= 1) return new ArrayList<>();
		List<String> results = new ArrayList<String>();
		boolean repeating = false;
		for (int i = 0; i < word.length() - 1 ; i++) {
			if ((int) word.charAt(i) < 65 || (int) word.charAt(i) > 122) return results;
			if (word.charAt(i) == word.charAt(i + 1)) {
				repeating = true;
				break;
			} 
		}
		if (repeating == false) {
			results.add(word);
			return results;
		} else {
			return rearrange(word);
		}
	}
	
	public Collection<String> rearrange(String word) {
		List<String> results = new ArrayList<String>();
		getAllWords(results, word, "");
		for (int j = 0; j < results.size(); j++) {
			for (int i = 0; i < word.length() - 1 ; i++) {
				if (results.get(j).charAt(i) == results.get(j).charAt(i + 1)) {
					results.remove(j);
					j = j -1;
					break;
				} 
			}
		}
		return results;
	}
	
	public void getAllWords(List<String> words, String str, String ans) {
		if (str.length() == 0) {
			words.add(ans);
			return;
		}

		boolean alpha[] = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			String ros = str.substring(0, i) + 
					str.substring(i + 1);

			if (alpha[ch - 'a'] == false)
				getAllWords(words, ros, ans + ch);
			alpha[ch - 'a'] = true;
		}
	}


}

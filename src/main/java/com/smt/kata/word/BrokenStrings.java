package com.smt.kata.word;

import java.util.ArrayList;
// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: BrokenStrings.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Broken Strings
 * Given a string s and an integer k, break up the string into multiple lines such 
 * that each line has a length of k or less. You must break it up so that words don't 
 * break across lines. Each line has to have the maximum possible amount of words. 
 * If there's no way to break the text up, then return empty list.
 * 
 * You can assume that there are no spaces at the ends of the string and that there 
 * is exactly one space between each word.
 * 
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, 
 * you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. 
 * No string in the list has a length of more than 10.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 10, 2021
 * @updates:
 ****************************************************************************/
public class BrokenStrings {

	/**
	 * 
	 */
	public BrokenStrings() {
		super();
	}
	
	/**
	 * Slices the phrase into chunks no greater than k characters long
	 * @param phrase Phrase to slice
	 * @param k Max characters per slice
	 * @return Collection of sliced words
	 */
	public List<String> slice(String phrase, int k) {
		List<String> result = new ArrayList<>();
		if (phrase == null) {
			return result;
		}
		String[] splitArr = phrase.split(" ");
		String words = "";
		for (int i = 0; i < splitArr.length; i++) {
			if (words.length() + splitArr[i].length() <= k) {
				words += " " + splitArr[i];
				System.out.println(words);
			}else {
				result.add(words.trim());
				words = splitArr[i];
			}
		}
		
		return result;
	}
}

package com.smt.kata.code;

import java.util.ArrayList;
import java.util.Arrays;
// JDK 11.x
import java.util.Collection;

/****************************************************************************
 * <b>Title:</b> AnagramIndicese.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Anagram Indicie
 * 
 * Given a word W and a string S, find all starting indices in S which are anagrams of W.
 * 
 * For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
 * 
 * Remember, we are working with words, not characters.  The indice is the first
 * index of W in S
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 28, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class AnagramIndices {

	/**
	 * Finds the location of each indices of w in s
	 * @param w characters to find
	 * @param s String to locate w
	 * @return Collection of indices locations.  Empty collection if none found
	 */
	public Collection<Integer> find(String w, String s) {
		Collection<Integer> results = new ArrayList();
		if(w == null || s == null || w.length() == 0 || w.length() > s.length())  {
			return results;
		}
		w = w.toUpperCase();
		s=s.toUpperCase();
		char[] wArr = w.toCharArray();
		Arrays.sort(wArr);
		for (int i = 0; i<s.length()-w.length()+1; i++) {
			char[] subArr = s.substring(i, i+w.length()).toCharArray();
			Arrays.sort(subArr);
			if (String.valueOf(subArr).contains(String.valueOf(wArr))) {
				results.add(i);
			}
		}
		return results;
	}
}

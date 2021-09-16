package com.smt.kata.word;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.lang3.ArrayUtils;

/****************************************************************************
 * <b>Title</b>: AlienDictionary.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Alien Dictionary Kata
 * 
 * In an alien language, surprisingly, they also use English lowercase letters, 
 * but possibly in a different order. The order of the alphabet is some permutation 
 * of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographically in this alien language.
 * 
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], 
 * hence the sequence is unsorted.
 * 
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is 
 * shorter (in size.) According to lexicographical rules "apple" > "app", 
 * because 'l' > '∅', where '∅' is defined as the blank character which is less 
 * than any other character (More info).
 * 
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 
 * All characters in words[i] and order are English lowercase letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
public class AlienDictionary {

	private String order;
	/**
	 * Initializes the class with the new alphabet order
	 * @param order Order of the letters in the new alphabet
	 * @throws DatatypeConfigurationException If the order of letters is invalid
	 */
	public AlienDictionary(String order) throws DatatypeConfigurationException {
		super();
		this.order = order;
		if (this.order.length() != 26) {
			throw new DatatypeConfigurationException("Don't do this");
		}
	}

	/**
	 * Determines if the provided words are in order
	 * @param words Words to check
	 * @return True if the words are in order and false otherwise
	 */
	public boolean isSorted(String[] words) {
		if (words == null || words.length <= 1) return false;
		String order = this.order;
		for (int i = 0; i < words.length - 1; i++) {
			if (words[i] == null) ++i;
			String firstWord = words[i].toLowerCase();
			if (words[i+1] == null) ++i;
			String secondWord = words[i+1].toLowerCase();
			if (!inOrder(firstWord, secondWord)) return false;
		}
		return true;
	}
	
	public boolean inOrder(String first, String second) {
		char[] arr1 = first.toCharArray();
		char[] arr2 = second.toCharArray();
		char[] orderArr = this.order.toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(order.indexOf(arr1[i]) + " | " + order.indexOf(arr2[i]));
			if (i == arr2.length -1) return false;
			if (order.indexOf(arr1[i]) < order.indexOf(arr2[i])) return true;
			if (order.indexOf(arr1[i]) > order.indexOf(arr2[i])) {
				return false;
			}
		}
		return true;
	}
}

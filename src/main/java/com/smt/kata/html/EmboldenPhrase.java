package com.smt.kata.html;

import java.util.ArrayList;
// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: EmboldenPhrase.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Embolden a Phrase Kata
 * 
 * Implement the function embolden(s, lst) which takes in a string s and list of 
 * substrings lst, and wraps all substrings in s with an HTML bold tag <b> and </b>.
 * 
 * If two bold tags overlap or are contiguous, they should be merged.
 * 
 * For example, given s = abcdefg and lst = ["bc", "ef"], return the string 
 * a<b>bc</b>d<b>ef</b>g.
 * 
 * Given s = abcdefg and lst = ["bcd", "def"], return the string 
 * a<b>bcdef</b>g, since they overlap.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 31, 2022
 * @updates:
 ****************************************************************************/
public class EmboldenPhrase {

	public static final String OPEN_TAG = "<b>";
	public static final String CLOSED_TAG = "</b>";
	
	/**
	 * HTML bold the words and combos from the provided phrase and words
	 * @param phrase Phrase to bold words
	 * @param boldWords Words in the phrase to bold
	 * @return Bolded phrase
	 */
	public String embolden(String phrase, List<String> boldWords) {
		if (phrase == null || phrase.length() == 0)
	       return "";
	    if (boldWords == null || boldWords.isEmpty())
	       return phrase;
		List<String> jointList = getJoints(boldWords);
		List<String> result = new ArrayList<>();
		
		for (int i = 0; i < phrase.length(); i++) {
			boolean added = false;
			for (String joint : jointList) {
				if (i + joint.length() <= phrase.length()) {
					String match = phrase.substring(i, i + joint.length());
					if (joint.equals(match)) {
						result.add(OPEN_TAG + joint + CLOSED_TAG);
						i += joint.length() - 1;
						added = true;
					}
				}
				
			}
			for (String bold : boldWords) {
				if (!added && i + bold.length() <= phrase.length()) {
					String match = phrase.substring(i, i + bold.length());
					if (bold.equals(match)) {
						result.add(OPEN_TAG + bold + CLOSED_TAG);
						i += bold.length() - 1;
						added = true;
					}
				}
			}
			if (!added) {
				result.add(phrase.charAt(i) + "");
			}
		}
		return String.join("", result);
	}
	
	public List<String> getJoints(List<String> boldWords) {
		List<String> jointList = new ArrayList<>();
		for (String str : boldWords) {
			for(String str2 : boldWords) {
				String joint = str;
				if (str.charAt(str.length() - 1) == str2.charAt(0)) {
					for (int i = 1; i < str2.length(); i++) {
						joint += str2.charAt(i);
					}
					jointList.add(joint);
				}
			}
		}
		return jointList;
	}
}

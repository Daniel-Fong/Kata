package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: ReverseWord.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reverse Words in a String
 * Given an input string, reverse the string word by word.
 * 
 * Examples
 * reverseWords("the sky is blue") ➞ "blue is sky the"
 * 
 * reverseWords("  hello world!  ") ➞ "world! hello"
 * 
 * reverseWords("a good   example") ➞ "example good a"
 * Notes
 * A word is defined as a sequence of non-space characters.
 * The input string may contain leading or trailing spaces. However, your reversed 
 * string should not contain leading or trailing spaces. You need to reduce multiple 
 * spaces between two words to a single space in the reversed string. You *** MAY NOT ***
 * utilize String.split() or parsing methods.  You must loop the phrase and process in a 
 * loop.  You may use collections to store words if desired.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
public class ReverseWord {

	/**
	 * Takes the phrase and reverses the ords
	 * @param phrase
	 * @return
	 */
	public String processPhrase(String phrase) {
		if (phrase == null) {
			return "";
		}
		String result = "";
		for (int i = 0; i<phrase.length(); i++) {
			String word = "";
			if (phrase.charAt(i) != ' ') {
				
				int counter = 0;
				
				if (i == phrase.length()-1) {
					result = word + " " + result;
					continue;
				}		
				else {
					word += phrase.charAt(i);
				}
			}
			if (phrase.charAt(i) == ' ') {
				result = word + " " + result;
				i ++;
				break;
			}
		}
		System.out.println(result);
		return result.trim();
	}
}

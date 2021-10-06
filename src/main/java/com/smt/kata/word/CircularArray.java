package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: CircularArray.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Circular Array Kata
 * 
 * Given a list of words, determine whether the words can be chained to form a circle. 
 * A word X can be placed in front of another word Y in a circle if the last 
 * character of X is same as the first character of Y.
 * 
 * For example, the words ['chair', 'height', 'racket', touch', 'tunic'] can 
 * form the following circle: chair --> racket --> touch --> height --> tunic --> chair.

 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 13, 2021
 * @updates:
 ****************************************************************************/
public class CircularArray {

	private List<String> resultList;
	
	public CircularArray() {
		super();
		this.resultList = new ArrayList<>();
	}
	
	/**
	 * Creates the circular array from the array of words
	 * @param words Words to reorder in a circular pattern
	 * @return Collection of words reordered.  Empty list if not possible
	 */
	public List<String> create(String[] words) {
		if (words== null || words.length <= 1) return new ArrayList<>();
		for (String word : words) {
			List<String> wordsList = new ArrayList<>();
			for (String loopWord : words) {
				wordsList.add(loopWord);
			}
			recurse(new ArrayList<>(), wordsList, words.length, word);
		}
		return resultList;
	}
	
	public void recurse (List<String> result, List<String> words, int length, String cur) {
		List<String> newResult = new ArrayList<>();
		for (String res : result) {
			newResult.add(res);
		}
		newResult.add(cur);
		List<String> newWords = new ArrayList<>();
		for (String word : words) {
			newWords.add(word);
		}
		newWords.remove(cur);
		if (newResult.size() == length) {
			newResult.add(newResult.get(0));
			resultList = newResult;
			return;
		}
		for (String word : words) {
			if (cur.charAt(cur.length()-1) == word.charAt(0)) {
				recurse (newResult, newWords, length, word);
			} 
		}
		return;
	}
	
	
}

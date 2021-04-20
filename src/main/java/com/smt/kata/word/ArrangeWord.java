package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: ArrangeWord.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Find all permutations of a given string.  Use recursion
 * to iterate through the method and find all possible combinations
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 6, 2021
 * @updates:
 ****************************************************************************/
public class ArrangeWord {
	
	/**
	 * Holds the results of the permutation
	 */
	private List<String> items;

	/**
	 * 
	 */
	public ArrangeWord() {
		super();
	}
	
	/**
	 * Loads and returns the possible permutations of a word
	 * @param word
	 * @return
	 */
	public List<String> getPermutations(String word) {
		items = new ArrayList<>();
		recur ("", word);
		return items;
	}
	
	public static void recur (String permutation, String word) {
		if (word == "") {
		}
		for (int i = 0; i<word.length(); i++) {
			char c = word.charAt(i);
			String sub1= word.substring(0, i);
			String sub2= word.substring(i, word.length()-i);
		}
	}
    public List<String> getPermutations(String word) {
        items = new ArrayList<>();
        
        if(word == null || word.isEmpty()) {
            return items;
        }
        
        //Call recursive function
        permutation("", word);
        
        return items;
    }
    
    /**
     * Recursive method to get the permutations
     * @param permutation
     * @param word
     */
    private void permutation(String permutation, String word) {
        //Check the base case
        if (word.isEmpty()) {
            items.add(permutation + word);

        } else {
            //iterate through all of the characters
            for (int i = 0; i < word.length(); i++) {
                //Call recursive function with sub strings
                permutation(permutation + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }

    }
}

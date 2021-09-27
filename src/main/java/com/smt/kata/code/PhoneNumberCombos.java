package com.smt.kata.code;

//JDK 11.x
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

/****************************************************************************
 * <b>Title</b>: PhoneNumberCombos.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Phone Number Combos Kata
 * 
 * A phone number keypad has a series of characters that are associated with 
 * each number (except 1 and 0) as shown in this image 
 * https://i.insider.com/5aa8433b3be59f1f008b4651?width=1200
 * 
 * In this kata, you will be provided a set of digits.  You must create all of 
 * the possible permutations from each set of numbers provided
 * 
 * Example 1
 * input "5"
 * output: [ "j", "k","l" ]
 * 
 * Example 2
 * input "23"
 * output: [ "ad","ae","af","bd","be","bf","cd","ce","cf" ]
 * 
 * Example 3
 * input ""
 * output: [ ]
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 2, 2021
 * @updates:
 ****************************************************************************/
public class PhoneNumberCombos {
	
	private List<String> results = new ArrayList<String>();
	
	/**
	 * Map with the digits to it's character options.  Array location matches the digit value
	 */
	protected static final String[] DIGIT_MAP = new String[] {
		"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" 
	};

	/**
	 * Calculates all of the possible permutations for a phone number to letter mapping
	 * @param digits Digits to transcribe 
	 * @return Collection of all of the permutations
	 */
	public List<String> calculate(String digits) {
		if (digits == null || digits.length() == 0) return new ArrayList<String>();
		List<String> words = new ArrayList<>();
		for (char c : digits.toCharArray()) {
			if (c < '0' || c > '9') return new ArrayList<String>();
			words.add(DIGIT_MAP[Integer.parseInt(c + "")]);
		}
		
		recurse(words, "", 0);
		return this.results;
		
//		for (int i = 0; i < digits.length(); i++) {
//			if (digits.charAt(i) < '0' || digits.charAt(i) > '9') return new ArrayList<String>();
//			List<String> newList = new ArrayList<String>();
//			String str = DIGIT_MAP[Integer.parseInt(digits.charAt(i) + "")];
//			for (int j = 0; j < str.length(); j++) {
//				if (results.size() == 0) newList.add(str.charAt(j)+"");
//				for (String result : results) {
//					newList.add(result + str.charAt(j) + "");
//				}
//			}
//			results = newList;
//		}
//		for (String res : results) System.out.println(res);
//		return results;
	}
	
	public void recurse(List<String> words, String cur, int index) {
		if (index == words.size()) {
			results.add(cur);
			return;
		}
		for (char c : words.get(index).toCharArray()) {
			recurse(words, cur + c, index + 1);
		}
	}
}

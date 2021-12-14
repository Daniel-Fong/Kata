package com.smt.kata.number;

import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.util.Convert;

/****************************************************************************
 * <b>Title</b>: AdditiveNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Additive Number Kata
 * 
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for the 
 * first two numbers, each subsequent number in the sequence must be the sum of 
 * the preceding two.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine 
 * if it's an additive number.
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 
 * 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Example 1:
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * Example 2:
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 *              1 + 99 = 100, 99 + 100 = 199
 * 
 * Constraints:
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 18, 2021
 * @updates:
 ****************************************************************************/
public class AdditiveNumber {
	List<List<Integer>> allLists = new ArrayList<>();
	/**
	 * Determines if the provided sequence is additive
	 * @param sequence Numeric sequence to evaluate
	 * @return True if additive, false otherwise
	 */
	public boolean isAdditive(String sequence) {
		if (sequence == null || sequence.length() < 3 || !sequence.matches("^[0-9]+$")) return false;
		recurse(sequence, 0, new ArrayList<>());
		for (List<Integer> list: allLists) {
			System.out.println(list);
		}
		for (List<Integer> list : allLists) {
			if (list.size() < 3) return false;
			if (checkAdditive(list)) {
				return true;
			}
		}
		return false;
	}
	
	public void recurse(String sequence, int index, List<Integer> numList) {
		for (int i = 1; i < sequence.length() - index + 1; i++) {
			List<Integer> newList = new ArrayList<>();
			for (int num: numList) {
				newList.add(num);
			}
			String str = sequence.substring(index, index + i);
			if (str.charAt(0) == '0') break;
			newList.add(Convert.formatInteger(str));
			if (index + i >= sequence.length() - 1 && newList.size() > 2) {
				allLists.add(newList);
			} else {
				recurse(sequence, index + i, newList);
			}
		}
	}
	
	public boolean checkAdditive(List<Integer> list) {
		for (int i = 0; i < list.size() - 2; i++) {		
			if (list.get(i) + list.get(i+1) != list.get(i+2)) {
				return false;
			} 
		}
		return true;
	}
}

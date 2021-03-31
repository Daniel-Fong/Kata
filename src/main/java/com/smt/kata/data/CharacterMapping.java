package com.smt.kata.data;

// JDK 11.x
import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title:</b> CharacterMapping.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Character Mapping
 * Given a mapping of digits to letters (as in a phone number), and a digit 
 * character, concatenate the corresponding location between the arrays. You can assume 
 * each valid number in the mapping is a single digit.
 * 
 * For example if {2: ['a', 'b', 'c'], 3: ['d', 'e', 'f'], …} then '23' 
 * should return ["ad", "be", "cf"].
 * 
 * You may use java.util.Map and any of it's implementing classes.  No other 
 * collections may be used or anything other than the standard java imports
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class CharacterMapping {
	
	protected Map<Integer, char[]> digitMap;

	/**
	 * Constructor assigns amp
	 * @param digitMap The digit make to work against
	 */
	public CharacterMapping(Map<Integer, char[]> digitMap) throws InvalidObjectException {
		super();
		if (digitMap == null) {
			throw new InvalidObjectException(null);
		}
		if (digitMap.isEmpty()) {
			throw new InvalidObjectException("Empty");
		}
		this.digitMap = digitMap;
	}

	/**
	 * Adds (concatenates) the elements in the provided locations
	 * @param locations Locations to concatenate
	 * @return concatenated string array
	 */
	public String[] add(int[] locations) {
		int size = 0;
		for (int i = 0; i<locations.length; i++) {
			if (digitMap.get(locations[i]) == null) {
				continue;
			}
			if (digitMap.get(locations[i]).length > size) {
				size = digitMap.get(locations[i]).length;
			}
		}
		String [] result = new String[size];
		for (int j = 0; j<size; j++) {
			String entry = "";
			for (int k = 0; k<locations.length; k++) {
				if (digitMap.get(locations[k]) == null || digitMap.get(locations[k]).length<j + 1) {
					continue;
				} else {
					entry += digitMap.get(locations[k])[j] + "";
				}
			}
			result[j] = entry;
		}
		
		return result;
	}
}

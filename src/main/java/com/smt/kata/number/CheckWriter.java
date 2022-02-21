package com.smt.kata.number;

// JDK 8.x
import java.util.HashMap;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;

/****************************************************************************
 * <b>Title</b>: CheckWriter.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b>
 * Given a currency value output the English equivalent as written on a check:
 * 
 * Input: 10,985.25   Output: Ten thousand nine hundred eighty five dollars and 25/100
 * Input: 125.75      Output: One hundred twenty five dollars and 75/100
 * Input: 95.00       Output: Ninety five dollars only
 * Input: 69          Output: Sixty nine dollars only
 * Input: 217.12	  Output: Two hundred seventeen dollars and 12/100
 * 
 * Note the initial capital on the output line.
 * Note the input may be an integer or a float.
 * 
 * Collections, Strings or other java classes (other than currency specific classes) may be used.

 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class CheckWriter {
	/**
	 * Holds the map to convert integer to words
	 */
	Map<Integer, String> numberMap = new HashMap<>();
	Map<Integer, String> placeMap = new HashMap<>();
	
	/**
	 * Initializes the Checkwriter and loads the xref map
	 */
	public CheckWriter() {
		// Load the word map
		loadMap();
	}

	/**
	 * Converts a number into a check syntax sentence
	 * @param data
	 * @return
	 */
	public String convertWords(double data) {
		String[] split = String.valueOf(data).split("\\.");
		String cents = "";
		if (split.length == 2) {
			cents = " and " + split[1] + "/100";
		}
		String dollars = "dollars";
		String str = split[0];
		for (int x = 0; x < (str.length() - 1) / 2; x++) {
			String sub = "";
			int lengthToSub = 0;
			if (str.length() > x * 3 + 2) {
				lengthToSub = 3;
			} else if (str.length() == x * 3 + 2) {
				lengthToSub = 2;
			} else {
				lengthToSub = 1;
			}
			sub = str.substring(str.length() - lengthToSub - (x * 3), str.length() - (x * 3));	
			System.out.println(sub);
			if (lengthToSub == 3) {
				String tens = "";
				if (Integer.parseInt(sub.substring(1, 3)) > 19) {
					tens = numberMap.get(Integer.parseInt(sub.charAt(1) + "0")) + " " + numberMap.get(Integer.parseInt(sub.charAt(2) + "")); 
				} else {
					tens = numberMap.get(Integer.parseInt(sub.substring(1, 2)));
				}
				dollars = " " + numberMap.get(Integer.parseInt(sub.charAt(0) + "")) + " hundred " + tens + " " + placeMap.get(x) + dollars;
			} else {
				System.out.println(sub);
				System.out.println(sub.substring(0, 2));
				String tens = "";
				if (Integer.parseInt(sub.substring(0, sub.length())) > 19) {
					tens = numberMap.get(Integer.parseInt(sub.charAt(0) + "0")) + " " + numberMap.get(Integer.parseInt(sub.charAt(1) + "")); 
				} else {
					tens = numberMap.get(Integer.parseInt(sub.substring(0, 1)));
				}
				dollars = " " + numberMap.get(Integer.parseInt(sub)) + " " + placeMap.get(x) + dollars;
			}
		}
		String result = (dollars + cents).trim();
		return result.substring(0, 1).toUpperCase() + result.substring(1);
	}

	/**
	 * Create a numbers map to convert ints to words
	 */
	protected void loadMap() {
		/** Put something here **/
	    numberMap.put(0, "");
        numberMap.put(1, "one");
        numberMap.put(2, "two");
        numberMap.put(3, "three");
        numberMap.put(4, "four");
        numberMap.put(5, "five");
        numberMap.put(6, "six");
        numberMap.put(7, "seven");
        numberMap.put(8, "eight");
        numberMap.put(9, "nine");
        numberMap.put(10, "ten");
        numberMap.put(11, "eleven");
        numberMap.put(12, "twelve");
        numberMap.put(13, "thirteen");
        numberMap.put(14, "fourteen");
        numberMap.put(15, "fifteen");
        numberMap.put(16, "sixteen");
        numberMap.put(17, "seventeen");
        numberMap.put(18, "eighteen");
        numberMap.put(19, "nineteen");
        numberMap.put(20, "twenty");
        numberMap.put(30, "thirty");
        numberMap.put(40, "forty");
        numberMap.put(50, "fifty");
        numberMap.put(60, "sixty");
        numberMap.put(70, "seventy");
        numberMap.put(80, "eighty");
        numberMap.put(90, "ninety");
        placeMap.put(0, "");
        placeMap.put(1, "thousand");
        placeMap.put(2, "thousand");
	}

}

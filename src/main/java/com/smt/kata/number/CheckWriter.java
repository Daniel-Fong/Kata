package com.smt.kata.number;

// JDK 8.x
import java.util.HashMap;
import java.util.Map;

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
		String str = data + "";
		String cents = "";
		if (str.contains(".")) {
			cents = str.substring(str.length() - 2, str.length());
			str = str.substring(0, str.length() - 3);
		}
		String result = "";
		if (str.length() > 3) {
			String thousands = str.substring(0, str.length() - 3);
			str = str.substring(str.length() - 3, str.length());
			System.out.println(thousands);
			System.out.println(str);
			if (Integer.parseInt(thousands) <= 20) {
				result += numberMap.get(Integer.parseInt(thousands)) + " ";
			} else {
				result += numberMap.get(Integer.parseInt(thousands.charAt(0) + "0")) + " ";
				result += numberMap.get(Integer.parseInt(thousands.charAt(1)+ "")) + " ";
			}
			result += "thousand ";
		}
		
		if (str.charAt(0) != '0') {
			result += numberMap.get(Integer.parseInt(str.charAt(0) + "")) + " ";
			result += "hundred ";
		}
		if (Integer.parseInt(str.substring(1, str.length())) <= 20) {
			result += numberMap.get(Integer.parseInt(str.substring(1, str.length()))) + " ";
		} else {
			result += numberMap.get(Integer.parseInt(str.charAt(1) + "0")) + " ";
			result += numberMap.get(Integer.parseInt(str.charAt(2)+ "")) + " ";
		}
		result += "dollars ";
		if (cents.length() > 0 && Integer.parseInt(cents) > 0) {
			result += "and ";
			result += cents + "/100";
		}
		
		System.out.println(result);
		
		result = result.substring(0, 1).toUpperCase() + result.substring(1);

		return result.trim();
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
	}

}

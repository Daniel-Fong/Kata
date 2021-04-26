package com.smt.kata.code;

/****************************************************************************
 * <b>Title:</b> PhoneNumberDecoder.java
 * <b>Project:</b> Daily-Kata
 * <b>Description:</b> Phone Number Word Decoder
 * 
 * Create a program that converts a phone number with letters to one with only numbers.
 * Examples
 * 
 * textToNum("123-647-EYES") ➞  "123.647.3937"
 * textToNum("(325)444-TEST") ➞ "325.444.8378"
 * textToNum("653-TRY-THIS") ➞  "653.879.8447"
 * textToNum("435-224-7613") ➞  "435.224.7613"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class PhoneNumberDecoder {

	/**
	 * 
	 */
	public PhoneNumberDecoder() {
		super();
	}

	/**
	 * Converts a phone number with text to a formatted phone number
	 * @param pn phone number to parse
	 * @return formatted phone number.
	 */
	public String textToNum(String pn) {
		if (pn == null || pn == "") {
			return "";
		}
		String upper = pn.toUpperCase();
		String[] arr = upper.split("");
		for (int i = 0; i < pn.length(); i++) {
			if (pn.charAt(i) > 64 && pn.charAt(i) < 91) {
				System.out.println(pn.charAt(i));
				int x = (int)pn.charAt(i) - 64;
				int counter = 1;
				while (x >= 3) {
					x -= 3;
					counter ++;
				}
				arr[i] = Integer.toString(counter);
			} else if (pn.charAt(i) == 45) {
				arr[i] = ".";
			}
		}
//		System.out.println()
		return String.join("", arr);
	}
}

package com.smt.kata.code;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;

/****************************************************************************
 * <b>Title</b>: PolybiusSquare.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> The Polybius Square cipher is a simple substitution cipher 
 * that makes use of a 5x5 square grid. The letters A-Z are written into the grid, 
 * with "I" and "J" typically sharing a slot (as there are 26 letters and only 25 slots).

			1	2	3	4	5
		1	A	B	C	D	E
		2	F	G	H	I/J	K
		3	L	M	N	O	P
		4	Q	R	S	T	U
		5	V	W	X	Y	Z

 * To encipher a message, each letter is merely replaced by its row and column numbers in the grid.
 * Create a function that takes a plaintext or ciphertext message, and returns the corresponding ciphertext or plaintext.
 * As "I" and "J" share a slot, both are enciphered into 24, but deciphered only into "I" (see third and fourth test).
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class PolybiusSquare {
	Map<Character, String> map = new HashMap<>();
	Map<String, String> decodeMap = new HashMap<>();
	
	public PolybiusSquare() {
		// Load the word map
		loadMap();
	}

	/**
	 * Encodes a sentence into its polybius values
	 * @param term
	 * @return
	 */
	public String polybiusEncode(String term){
		if (term == null|| term.length() == 0) return "";
		String upper = term.toUpperCase();
		String result = "";
		for (char c : upper.toCharArray()) {
			if (!map.containsKey(c)) {
				result += " ";
			} else {
				result += map.get(c);	
			}
		}
		return result;
	}
	
	/**
	 * Decodes the polybius back to a string
	 * @param code
	 * @return
	 */
	public String decodeValue(String code){
		if (code == null|| code.length() == 0) return "";
		String result = "";
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == ' ') {
				result += " ";
				continue;
			} else {
				String str = code.charAt(i) + "" + code.charAt(i+1) + "";
				result += decodeMap.get(str);
				++i;
			}
			
		}
		return result;
	}
	
	public void loadMap() {
		map.put('A', "11");
		map.put('C', "13");
		map.put('B', "12");
		map.put('D', "14");
		map.put('E', "15");
		map.put('F', "21");
		map.put('G', "22");
		map.put('H', "23");
		map.put('I', "24");
		map.put('J', "24");
		map.put('K', "25");
		map.put('L', "31");
		map.put('M', "32");
		map.put('N', "33");
		map.put('O', "34");
		map.put('P', "35");
		map.put('Q', "41");
		map.put('R', "42");
		map.put('S', "43");
		map.put('T', "44");
		map.put('U', "45");
		map.put('V', "51");
		map.put('W', "52");
		map.put('X', "53");
		map.put('Y', "54");
		map.put('Z', "55");
		decodeMap.put("11", "a");
		decodeMap.put("13", "b");
		decodeMap.put("12", "c");
		decodeMap.put("14", "d");
		decodeMap.put("15", "e");
		decodeMap.put("21", "f");
		decodeMap.put("22", "g");
		decodeMap.put("23", "h");
		decodeMap.put("24", "i");
		decodeMap.put("25", "k");
		decodeMap.put("31", "l");
		decodeMap.put("32", "m");
		decodeMap.put("33", "n");
		decodeMap.put("34", "o");
		decodeMap.put("35", "p");
		decodeMap.put("41", "q");
		decodeMap.put("42", "r");
		decodeMap.put("43", "s");
		decodeMap.put("44", "t");
		decodeMap.put("45", "u");
		decodeMap.put("51", "v");
		decodeMap.put("52", "w");
		decodeMap.put("53", "x");
		decodeMap.put("54", "y");
		decodeMap.put("55", "z");
	}           
}

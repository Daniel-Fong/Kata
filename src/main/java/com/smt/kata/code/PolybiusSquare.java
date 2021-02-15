package com.smt.kata.code;

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

	/**
	 * Encodes a sentence into its polybius values
	 * @param term
	 * @return
	 */
	public String polybiusEncode(String term){
		return term;
	}
	
	/**
	 * Decodes the polybius back to a string
	 * @param code
	 * @return
	 */
	public String decodeValue(String code){
	    return code;
	}

}

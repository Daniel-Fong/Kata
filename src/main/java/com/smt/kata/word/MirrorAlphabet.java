package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

// Kata Libs
import com.smt.kata.util.Dictionary;

/****************************************************************************
 * <b>Title</b>: MirrorAlphabet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Every kid learns that A is for Apple ... and Z is for Zebra.
 * But not every kid learns the mirror-alphabet words:
 * A is for Anaconda
 * B is for Bathtub
 * C is for Comic
 * ...
 * Z is for Zizz
 * Not only are the first letters of each word alphabetic, so are the last letters!
 * 
 * Unfortunately, you can't complete this list: no word in English begins and ends with X.
 * 
 * But what if you shift the alphabet by one letter for the ending?
 * 
 * A is for Absorb
 * B is for Byronic
 * C is for Caryatid
 * ...
 * X is for Xenophoby
 * Y is for Yez
 * Z is for Zebra
 * You'll find that this won't work either. How about shifting the end letter alphabet by 2?
 * 
 * A is for Antihemorrhagic
 * B is for Blindfold
 * C is for Capstone
 * ...
 * Y is for Yoga
 * Z is for Zimb
 * That fails, too! In fact, there is only one mirror-alphabetic ordering that works for English.
 * 
 * Write a program that generates a valid mirror-alphabet word list.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class MirrorAlphabet {
	/**
	 * Array holding all of the words in the dictionary
	 */
	protected String[] dict;
	
	/**
	 * Loads the dictionary for the kata
	 * @throws IOException 
	 */
	public MirrorAlphabet() throws IOException {
		Dictionary dictionary = new Dictionary();
		this.dict = dictionary.getDictionaryArray();
	}

	/**
	 * Loads the dictionary for the kata
	 */
	public MirrorAlphabet(String[] dict) {
		this.dict = dict;
	}
	
	/**
	 * Gets the list of 26 matching words
	 * @return
	 */
	public List<String> getMagicList() {
		return new ArrayList<>();
	}
}

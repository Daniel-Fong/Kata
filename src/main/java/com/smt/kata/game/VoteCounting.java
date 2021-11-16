package com.smt.kata.game;

import java.io.BufferedReader;
// JDK 11.x
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.graalvm.compiler.hotspot.nodes.type.MethodCountersPointerStamp;

/****************************************************************************
 * <b>Title</b>: VoteCounting.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Vote Counting
 * 
 * On election day, a voting machine writes data in the form ot a tab delimiter 
 * (voter_id \t candidate_id) to a text file. Write a program that reads this 
 * file as a stream and returns the top 3 candidates at any given time. If you 
 * find a voter voting more than once, report this as fraud.
 * 
 * The voting files are located in the resources/data folder
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 4, 2021
 * @updates:
 ****************************************************************************/
public class VoteCounting {
	/**
	 * Location of the dictionary
	 */
	public static final String RESOURCE = "/data/voting_%d.txt";
	
	/**
	 * Candidates whom votes will be counted
	 */
	public enum Candidates {
		BILL, DAVE, BECKY, JOSE, CHRIS, DANIEL, JOSEPH, MARY
	}
	
	// Members
	private List<Integer> possibleFraudVotes = new ArrayList<>();

	/**
	 * Counts the votes for a given version
	 * @param version Version of the voter file to parse.  
	 * Example value of 1 -> voting_1.txt
	 * @return Top 3 vote getters
	 * @throws IOException If votes can't be loaded
	 */
	public List<Candidates> count(int version) throws IOException {
		var fileName = String.format(RESOURCE, version);
		Map<Candidates, Integer> counts = new HashMap<>();
		try (var reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName)))) {
			String line;
			while ((line = reader.readLine()) != null) {
			    if (line.isEmpty()) {
			        break;
			    }
			    List<String> list = Arrays.asList(line.split("\\s+"));
				if (counts.containsKey(list.get(1))) {
				}
			}
		}
		return new ArrayList<>();
	}
	

	/**
	 * @return the possibleFraudVotes
	 */
	public List<Integer> getPossibleFraudVotes() {
		return possibleFraudVotes;
	}
	
	/**
	 * Method to check whether fraud may exist in the votes
	 * @return
	 */
	public boolean hasPotentialFraud() {
		return !possibleFraudVotes.isEmpty();
	}
}

package com.smt.kata.word;

import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.util.StringUtil;

/****************************************************************************
 * <b>Title</b>: TextJustification.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Text Justification Kata
 * 
 * Given an array of strings words and a width maxWidth, format the text such that 
 * each line has exactly maxWidth characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words 
 * as you can in each line. Pad extra spaces ' ' when necessary so that each line h
 * as exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the 
 * number of spaces on a line does not divide evenly between words, the empty slots 
 * on the left will be assigned more spaces than the slots on the right.
 * 
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * In an unbalanced spacing, higher spacing comes first.  For example, if you need 
 * 4 spaces between a word and 3 between the next, the higher spacing would be first
 * 
 * Example 1:
 * Input: words = ["This is an example of text justification"], maxWidth = 16
 * Output:
 *    "This    is    an",
 *    "example  of text",
 *    "justification   "
 * 
 * Example 2:
 * Input: words = ["What must be acknowledgment shall be"], maxWidth = 16
 * Output:
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
 * 
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", 
 * because the last line must be left-justified instead of fully-justified.
 * 
 * Note that the second line is also left-justified because it contains only one word.
 * 
 * Example 3:
 * Input: words = ["Science is what we understand well enough to explain to a computer. Art is everything else we do"], maxWidth = 20
 * Output:
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * 
 * Constraints:
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 29, 2021
 * @updates:
 ****************************************************************************/
public class TextJustification {

	/**
	 * Formats the provided text into a fully formatted document
	 * @param phrase Phrase to format
	 * @param maxWidth Maximum width to format each line
	 * @return Formatted phrase
	 */
	public String formatPhrase(String phrase, int maxWidth) {
		if (phrase == null || phrase.length() == 0 || !checkWords(phrase, maxWidth)) return "";
		
		List<List<String>> lines = splitPhrase(phrase, maxWidth);
		
		StringBuilder result = new StringBuilder(maxWidth * lines.size() + lines.size() * 2);
		
		for (int i = 0; i < lines.size()-1; i++) {
			result.append(spaceAdder(lines.get(i), maxWidth)).append("\n");
		}
		
		result.append(spaceAdderLastLine(lines.get(lines.size()-1), maxWidth));
		
		return result.toString();
	}
	
	private boolean checkWords(String phrase, int maxWidth) {
		for (String s : phrase.split(" ")) {
			if (s.length() > maxWidth) return false;
		}
		return true;
	}
	
	private List<List<String>> splitPhrase(String phrase, int maxWidth) {
		List<List<String>> lines = new ArrayList<>();
		List<String> line = new ArrayList<>();
		int curLen = 0;
		for (String s : phrase.split(" ")) {
			if ((curLen + s.length()) > maxWidth) {
				lines.add(line);
				curLen = 0;
				line = new ArrayList<>();
			}
			line.add(s);
			curLen += s.length();
			
			//Add the default space if we have room
			if (curLen < maxWidth) curLen++;
		}
		lines.add(line);
		
		return lines;
	}

	public String spaceAdder(List<String> line, int maxWidth) {
		int strWidth = 0;
		for (String str : line) {
			strWidth += str.length();
		}
		int numSpaces = maxWidth - strWidth;
		
		int wordSpace = line.size() > 2 ? line.size() - 2 : 0;
		
		int currentIndex = 0; 
		
		while (numSpaces > 0) {
			line.set(currentIndex, line.get(currentIndex) + " ");
			if (currentIndex < wordSpace) {
				++currentIndex;
			} else {
				currentIndex = 0;
			}
			--numSpaces;
		}
		
		return String.join("", line);
	}

	public String spaceAdderLastLine(List<String> line, int maxWidth) {
		for (int i = 0; i < line.size()-1; i++) {
			line.set(i, line.get(i) + " ");
		}
		return StringUtil.padRight(String.join("", line), ' ', maxWidth);
	}
}

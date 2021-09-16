package com.smt.kata.tree;

import java.util.Arrays;

/****************************************************************************
 * <b>Title</b>: OpenTheLock.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Open The Lock Kata
 * 
 * You have a lock in front of you with 4 circular wheels. Each wheel has 
 * 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
 * freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
 * Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any of 
 * these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the lock, 
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * 
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * 
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * 
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * 
 ************************ Hint: Breadth First Search!!
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class OpenTheLock {

	/**
	 * Calculates the number of moves to unlock the lock
	 * @param deadends Numbers that are not allowed to be used
	 * @param target Combination to target
	 * @return Number of moves.  -1 if it can't be accomplished
	 */
	public int calculatePath(String[] deadends, String target) {
		char[] code = new char[]{'0','0','0','0'};
		int moves = 0;
		int failDigit=-1;
		int curDigit=0;

		if (!isPossible(deadends, target)) return -1;
		
		while(true) {
			if (curDigit > 3) { 
				curDigit = 0;
				failDigit++;
			}
			System.out.print(code);
			System.out.println("|"+target);
			if (new String(code).equals(target)) return moves;
			if (curDigit == failDigit) curDigit++;
			System.out.println(String.valueOf(code[curDigit]));
			int current = Integer.parseInt(String.valueOf(code[curDigit]));
			
			if (current == Integer.parseInt(String.valueOf(target.charAt(curDigit)))) {
				curDigit++;
				continue;
			}

			System.out.println(current);
			int direction = getMoves(current, Integer.parseInt(String.valueOf(target.charAt(curDigit))));	
			
			int movedDigit = current + direction;
			if (movedDigit == 10) movedDigit = 0;
			if (movedDigit == -1) movedDigit = 9;

			System.out.println((char)movedDigit);
			code[curDigit] = Character.forDigit(movedDigit, 10);
			
			for (String s : deadends) {
				if (s.equals(new String(code))) {
					System.out.println("breaking on " + s);
					code[curDigit] = Character.forDigit(current, 10);
					curDigit = 0;
					failDigit++;
					moves++;
					
					code[curDigit] = Character.forDigit(Integer.parseInt(String.valueOf(code[curDigit]))+1, 10);
					if (failDigit > 3) return -1;
					continue;
				}
			}
			moves++;
			
			if (movedDigit == Integer.parseInt(String.valueOf(target.charAt(curDigit))))
				curDigit++;
		}
    }

	private int getMoves(int charAt, int charAt2) {
		if(charAt2 - charAt > 5) {
			return -1;
		} else {
			return 1;		
		}
	}

	public boolean isPossible(String[] deadends, String target) {
		for (int i = 0; i < target.length(); i++) {
			String higher = target.substring(0, i) + (Character.getNumericValue(target.charAt(i)) == 9 ? 0 : (Character.getNumericValue(target.charAt(i)) + 1) + target.substring(i, 3));
			String lower = target.substring(0, i) + (Character.getNumericValue(target.charAt(i)) == 0 ? 9 : (Character.getNumericValue(target.charAt(i)) - 1) + target.substring(i, 3));
			// System.out.println(higher + "|" + lower);
			if (!Arrays.asList(deadends).contains(higher) || !Arrays.asList(deadends).contains(lower)) return true;
		}
				
		return false;
	}

	
}

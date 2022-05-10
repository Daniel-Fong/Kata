package com.smt.kata.money;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MinimumChangeReceived.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Minimum Coins Received
 * 
 * Find the minimum number of coins required to make n cents.
 * 
 * You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.
 * 
 * For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 3, 2022
 * @updates:
 ****************************************************************************/
public class MinimumChangeReceived {

	/**
	 * Calculates the smallest number of coins in the change
	 * @param dAmt
	 * @return
	 */
	public int calculate(double dAmt) {
		List<Integer> coins = new ArrayList<>();
		coins.add(25);
		coins.add(10);
		coins.add(5);
		coins.add(1);
		int count = 0;
		double curAmt = dAmt * 100;
		for(double coin: coins) {
			while(curAmt >= coin) {
				++count;
				curAmt = curAmt - coin;
			}
		}
		return count;
	}

}

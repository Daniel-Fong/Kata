package com.smt.kata.game;

import java.util.ArrayList;
import java.util.Collections;
// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: LazyBartender.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Lazy Bartender Kata
 * 
 * At a popular bar, each customer has a List of favorite drinks, and will happily 
 * accept any drink among this List. For example, in the following situation, customer 
 * 0 will be satisfied with drinks 0, 1, 3, or 6.
 * 
 * preferences = {
 *     0: [0, 1, 3, 6],
 *     1: [1, 4, 7],
 *     2: [2, 4, 7, 5],
 *     3: [3, 2, 5],
 *     4: [5, 8]
 * }
 * 
 * A lazy bartender working at this bar is trying to reduce his effort by limiting 
 * the drink recipes he must memorize. Given a dictionary input such as the one 
 * above, return the fewest number of drinks he must learn in order to satisfy 
 * all customers.
 * 
 * For the input above, the answer would be 2, as drinks 1 and 5 will satisfy everyone.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 1, 2021
 * @updates:
 ****************************************************************************/
public class LazyBartender {

	/**
	 * Finds the minimum number of drinks the bartender has to memorize to satisfy all customers
	 * @param custDrinks Map of customers and their drink preferences
	 * @return Minimum number of drinks to memorize.
	 */
	public int minimumTypes(Map<Integer, List<Integer>> custDrinks) {
		if (custDrinks == null) return 0;
		List<Integer> drinks = new ArrayList<>();
		for (var item : custDrinks.entrySet()) {
			for (int num: item.getValue()) {
				if (!drinks.contains(num)) drinks.add(num);
			}
		}
		List<List<Integer>> powerList = powerList(drinks);
		
		
		List<Integer> counts = new ArrayList<>();
		
		for (List<Integer> list : powerList) {
			if (coversAll(custDrinks, list)) {
				counts.add(list.size());
			}
		}
		Collections.sort(counts);
		return counts.get(0);
	}
	
	public boolean coversAll(Map<Integer, List<Integer>> custDrinks, List<Integer> drinks) {
		for (var item : custDrinks.entrySet()) {
			boolean hasOne = false;
			for (var num : item.getValue()) {
				if (drinks.contains(num)) {
					hasOne = true;
				}
			}
			if (!hasOne) return false;
		}
		return true;
	}
	
	public static List<List<Integer>> powerList(List<Integer> originalList) {
	    List<List<Integer>> lists = new ArrayList<>();
	    if (originalList.isEmpty()) {
	        lists.add(new ArrayList<>());
	        return lists;
	    }
	    List<Integer> list = new ArrayList<>(originalList);
	    int head = list.get(0);
	    List<Integer> rest = new ArrayList<>(list.subList(1, list.size())); 
	    for (List<Integer> List : powerList(rest)) {
	        List<Integer> newList = new ArrayList<>();
	        newList.add(head);
	        newList.addAll(List);
	        lists.add(newList);
	        lists.add(List);
	    }       
	    return lists;
	}  
}
